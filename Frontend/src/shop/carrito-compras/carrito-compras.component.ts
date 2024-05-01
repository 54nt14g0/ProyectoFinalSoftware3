import { Component, OnInit } from '@angular/core';
import { CarritoService } from '../../app/servicios/carrito.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carrito-compras',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div *ngIf="cartItems.length > 0">
      <h2>Cart</h2>
      <ul>
        <li *ngFor="let item of cartItems">
          <span>{{ item.nombre }} - {{ item.precio | currency }}</span>
          <button (click)="removerDelCarrito(item.id)">Remover</button>
        </li>
      </ul>
      <button (click)="limpiarCarrito()">Limpiar carrito</button>
    </div>
    <div *ngIf="cartItems.length === 0">
      <p>The cart is empty</p>
    </div>
  `,
  styleUrl: './carrito-compras.component.css'
})
export class CarritoComprasComponent implements OnInit {
  cartItems: any[] = [];

  constructor(private CarritoService: CarritoService) {}

  ngOnInit() {
    this.CarritoService.cartItems$.subscribe((items) => {
      this.cartItems = items;
    });
  }

  removerDelCarrito(idProducto: number) {
    this.CarritoService.removerDelCarrito(idProducto);
  }

  limpiarCarrito() {
    this.CarritoService.limpiarCarrito();
  }

}
