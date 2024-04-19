import { Routes } from '@angular/router';
import { ListaProductosComponent } from '../shop/lista-productos/lista-productos.component';
import { CarritoComprasComponent } from '../shop/carrito-compras/carrito-compras.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    { path: 'lista', component: ListaProductosComponent },
    { path: 'carrito', component: CarritoComprasComponent },
    { path: 'login', component: LoginComponent}
];
