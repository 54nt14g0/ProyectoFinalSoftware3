import { Injectable } from '@angular/core';
import { MensajeDTO } from '../modelo/mensaje-dto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  private url = 'http://localhost:9090/api';

  obtenerProductoPorId(productId: number): any {
    throw new Error('Method not implemented.');
  }

  obtenerProductos(): Observable<MensajeDTO> {
    return this.http.get<MensajeDTO>(`${this.url}/productos`);
  }
  
  constructor(private http: HttpClient) { }
}
