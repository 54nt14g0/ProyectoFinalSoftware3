import { Component, OnInit } from '@angular/core';
import { CarritoService } from '../../app/servicios/carrito.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-productos',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div *ngFor="let product of products">
      <div>
        <h3>{{ product.name }}</h3>
        <p>Price: {{ product.price | currency  }}</p>
        <button (click)="anadirAlCarrito(product)">Add to Cart</button>
      </div>
    </div>
  `,
  styleUrl: './lista-productos.component.css'
})
export class ListaProductosComponent implements OnInit{
  ngOnInit() {}

  products = [
    { id: 1, name: 'Coffee A', price: 5.0 },
    { id: 2, name: 'Coffee B', price: 6.5 },
    // Añade más productos según sea necesario
  ];

  constructor(private CarritoService: CarritoService) {}

  anadirAlCarrito(producto: any) {
    this.CarritoService.anadirAlCarrito(producto);
  }

}
