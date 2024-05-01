import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductoService } from '../servicios/producto.service';

@Component({
  selector: 'app-detalle-producto',
  templateUrl: './detalle-producto.component.html',
  styleUrls: ['./detalle-producto.component.css']
})
export class DetalleProductoComponent implements OnInit {
  productId!: number;
  producto: any; // Aquí deberías definir la estructura del producto

  constructor(private route: ActivatedRoute, private productoService: ProductoService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.productId = +params['id']; // Obtener el ID del producto de los parámetros de la ruta
      // Aquí deberías cargar los detalles del producto utilizando su ID, por ejemplo, desde un servicio.
      // Puedes hacer una llamada a un servicio que obtenga el producto por su ID.
      this.obtenerDetallesProducto(this.productId);
    });
  }

  obtenerDetallesProducto(productId: number) {
    // Aquí deberías cargar los detalles del producto utilizando su ID, por ejemplo, desde un servicio.
    // Puedes hacer una llamada a un servicio que obtenga el producto por su ID.
    // Ejemplo:
  this.producto = this.productoService.obtenerProductoPorId(productId);
  }
}
