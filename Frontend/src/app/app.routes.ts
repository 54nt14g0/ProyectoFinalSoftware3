import { Routes } from '@angular/router';
import { ListaProductosComponent } from '../shop/lista-productos/lista-productos.component';
import { CarritoComprasComponent } from '../shop/carrito-compras/carrito-compras.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { DetalleProductoComponent } from './detalle-producto/detalle-producto.component';
import { CrearClienteComponent } from './clientes/crear-cliente/crear-cliente.component';
import { ListaClientesComponent } from './clientes/lista-clientes/lista-clientes.component';
import { VistaClienteComponent } from './clientes/vista-cliente/vista-cliente.component';

export const routes: Routes = [
    { path: 'lista', component: ListaProductosComponent },
    { path: 'carrito', component: CarritoComprasComponent },
    { path: 'login', component: LoginComponent},
    { path: 'registro', component: RegistroComponent},
    { path: 'detalle-producto/:id', component: DetalleProductoComponent },
    { path: 'crear-cliente', component: CrearClienteComponent },
    { path: 'lista-clientes', component: ListaClientesComponent },
    { path: 'detalle-cliente/:id', component: VistaClienteComponent}
];
