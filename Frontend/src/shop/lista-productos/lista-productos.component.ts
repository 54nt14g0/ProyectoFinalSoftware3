import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ProductoService } from '../../app/servicios/producto.service';

@Component({
  selector: 'app-lista-productos',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div *ngFor="let producto of productos">
      <div>
        <h3>{{ producto.nombre }}</h3>
        <p>Price: {{ producto.precioVenta | currency  }}</p>
        <p>Stock: {{ producto.cantidad }}</p>
        <button (click)="verDetalles(producto.id_producto)">Ver detalles</button>
      </div>
    </div>
  `,
  styleUrl: './lista-productos.component.css'
})
export class ListaProductosComponent implements OnInit{
  productos: any[] = [];
  ngOnInit() {
    this.obtenerProductos();
  }

  obtenerProductos() {
    this.productoService.obtenerProductos().subscribe(
      (data: any) => {
        this.productos = data.respuesta;
      },
      (error: any) => {
        console.error(error);
      }
    );
  }

  

  constructor(private router: Router, private productoService: ProductoService) {}

  verDetalles(productId: number) {
    // Aquí puedes definir la ruta a la que deseas redirigir, por ejemplo:
    this.router.navigate(['/detalle-producto', productId]);
  }
}
