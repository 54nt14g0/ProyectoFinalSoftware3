import { Injectable, inject } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class NotificacionesService {
  toastr = inject(ToastrService)

  constructor(toastr: ToastrService) { }

  mostrarMensaje(tipo: number, mensaje: string, titulo: string) {
    if (tipo == 1) {
      this.toastr.success(mensaje, titulo)
    } else if (tipo == 2) {
      this.toastr.error(mensaje, titulo)
    } else if (tipo == 3) {
      this.toastr.warning(mensaje, titulo)
    } else {
      this.toastr.info(mensaje, titulo)
    }
  }
}
