import { Injectable } from '@angular/core';
import { MensajeDTO } from '../modelo/mensaje-dto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  clientes: any[] = [];
  private url = 'http://localhost:9090/api';

  constructor(private http: HttpClient) { }

  obtenerClientes(): Observable<MensajeDTO>{
    return this.http.get<MensajeDTO>(`${this.url}/clientes`);
  }

  obtenerCliente(id: number): Observable<MensajeDTO>{
    return this.http.get<MensajeDTO>(`${this.url}/cliente/${id}`);
  }
}
