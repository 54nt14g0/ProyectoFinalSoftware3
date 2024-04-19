import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarritoService {
  private cartItemsSubject = new BehaviorSubject<any[]>([]);
  cartItems$ = this.cartItemsSubject.asObservable();

  constructor() { }

  anadirAlCarrito(producto: any) {
    console.log(producto);
    const currentItems = this.cartItemsSubject.value;
    this.cartItemsSubject.next([...currentItems, producto]);
    console.log(this.cartItemsSubject.value);
  }

  removerDelCarrito(idProducto: number) {
    const currentItems = this.cartItemsSubject.value.filter(
      (item) => item.id !== idProducto
    );
    this.cartItemsSubject.next(currentItems);
  }

  limpiarCarrito() {
    this.cartItemsSubject.next([]);
  }
}
