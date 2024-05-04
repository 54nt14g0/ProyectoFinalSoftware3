import { Routes } from '@angular/router';
import { ListaProductosComponent } from '../shop/lista-productos/lista-productos.component';
import { CarritoComprasComponent } from '../shop/carrito-compras/carrito-compras.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { DetalleProductoComponent } from './detalle-producto/detalle-producto.component';
import { CrearClienteComponent } from './clientes/crear-cliente/crear-cliente.component';
import { ListaClientesComponent } from './clientes/lista-clientes/lista-clientes.component';
import { VistaClienteComponent } from './clientes/vista-cliente/vista-cliente.component';
import { CrearProductoComponent } from './productos/crear-producto/crear-producto.component';
import { VistaProductoComponent } from './productos/vista-producto/vista-producto.component';
import { CrearPedidoComponent } from './pedidos/crear-pedido/crear-pedido.component';
import { ListaPedidosComponent } from './pedidos/lista-pedidos/lista-pedidos.component';
import { VistaPedidoComponent } from './pedidos/vista-pedido/vista-pedido.component';

export const routes: Routes = [
    { path: 'lista', component: ListaProductosComponent },
    { path: 'carrito', component: CarritoComprasComponent },
    { path: 'login', component: LoginComponent},
    { path: 'registro', component: RegistroComponent},
    { path: 'producto/:id', component: DetalleProductoComponent },
    { path: 'crear-cliente', component: CrearClienteComponent },
    { path: 'listar-clientes', component: ListaClientesComponent },
    { path: 'detalle-cliente/:id', component: VistaClienteComponent},
    { path: 'crear-producto', component: CrearProductoComponent },
    { path: 'listar-productos', component: ListaProductosComponent },
    { path: 'detalle-producto/:id', component: VistaProductoComponent },
    { path: 'crear-pedido', component: CrearPedidoComponent },
    { path: 'listar-pedidos', component: ListaPedidosComponent },
    { path: 'detalle-pedido/:id', component: VistaPedidoComponent },
];
