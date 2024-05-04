import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClienteService } from '../../servicios/cliente.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vista-cliente',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, FormsModule],
  templateUrl: './vista-cliente.component.html',
  styleUrl: './vista-cliente.component.css'
})
export class VistaClienteComponent {

  datosBasicosForm: FormGroup;
  datosContactoForm: FormGroup;
  clienteId: number = 0;
  pedidos: any[] = [];

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.clienteId = +params['id'];
    });
    this.obtenerCliente(this.clienteId);
  }

  constructor(private fb: FormBuilder, private clienteService: ClienteService, private route: ActivatedRoute) {
    this.datosBasicosForm = this.fb.group({
      id: [''],
      nombre: [''],
      apellido: [''],
      correo: ['']
    });
    this.datosContactoForm = this.fb.group({
      telefono: [''],
      direccion: ['']
    });
  }

  obtenerCliente(id: number) {
    this.clienteService.obtenerCliente(this.clienteId).subscribe(
      (data: any) => {
        console.log(data);
        this.datosBasicosForm.setValue({
          id: data.respuesta.id_usuario,
          nombre: data.respuesta.nombre,
          apellido: data.respuesta.apellido,
          correo: data.respuesta.correo
        });
        this.datosContactoForm.setValue({
          telefono: data.respuesta.telefono,
          direccion: data.respuesta.direccion
        });
        this.pedidos = data.respuesta.usuarioPedidosList;
        console.log(this.pedidos);
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  validarDatosBasicos() {
  }

  onSubmitDB() {
    throw new Error('Method not implemented.');
  }

  onSubmitDC() {
    throw new Error('Method not implemented.');
  }

}
