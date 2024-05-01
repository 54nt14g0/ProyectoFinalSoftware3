import { Component, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteService } from '../../servicios/cliente.service';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { Observable, map, of } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-lista-clientes',
  standalone: true,
  imports: [CommonModule, FormsModule, NgxPaginationModule],
  templateUrl: './lista-clientes.component.html',
  styleUrl: './lista-clientes.component.css'
})
export class ListaClientesComponent {
  paginaActual: number = 1;
  totalPages: number = 0;
  usuarioPorPagina: number[] = [5, 10, 20, 30];
  cantidadUsuarios = this.usuarioPorPagina[0];
  clientes: any[] = [];
  pageChange = new EventEmitter<number>();
  ngOnInit() {
    this.obtenerClientes();
  }
  constructor(private clienteService: ClienteService, private router:Router) { }
  obtenerClientes() {
    this.clienteService.obtenerClientes().subscribe(
      (data: any) => {
        this.clientes = data.respuesta;
        console.log(this.clientes);
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  getCliente(id: number): any[] {
    return this.clientes.filter((cliente) => cliente.id === id);
  }

  get totalPages$(): Observable<number> {
    const total = Math.ceil(this.clientes.length / this.cantidadUsuarios);
    this.totalPages = total;
    return of(total);
  }

  get usuariosPorPagina$(): number[] {
    let usuarios = [];
    let inicio = 0;
    let fin = 0;
    if(this.clientes.length > 0){
      inicio = Math.max(1, (this.paginaActual - 1) * this.cantidadUsuarios + 1);
      fin = Math.min(inicio  - 1 + parseInt(this.cantidadUsuarios.toString()), this.clientes.length)
    }
    usuarios = [inicio, fin]
    return usuarios;
  }

  get getPaginas$(): Observable<number[]> {
    return this.totalPages$.pipe(
      map((total) => {
        let startPage = Math.max(1, this.paginaActual - 1);
        let endPage = Math.min(startPage + 2, total);
        if(endPage === total){
          startPage = Math.max(1, endPage - 2);
        } 

        return Array.from({ length: endPage - startPage + 1 }, (_, i) => startPage + i);
      })
    );
  }

  anterior() {
    if (this.paginaActual > 1) {
      this.paginaActual--;
    }
  }

  siguiente() {
    if (this.paginaActual < this.totalPages) {
      this.paginaActual++;
    }
  }

  irAPagina(page: number) {
    this.paginaActual = page;
  }

  onChangeUsuarioPorPagina(){
    this.paginaActual = 1;
  }

  verClientes(clienteId: number) {
    this.router.navigate(['/detalle-cliente', clienteId]);
  }
  
}
