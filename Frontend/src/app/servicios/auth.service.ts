import { Injectable, inject } from '@angular/core';
import { Router } from '@angular/router';
import { LoginRequest } from '../modelo/login-request';
import { AuthResponse } from '../modelo/auth-response';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private url = 'http://localhost:9090/auth';
  private toggleEvent = new Subject<void>();

  constructor(private http: HttpClient, private router: Router, private cookieService: CookieService) {}

  public isLogged(): boolean {
    return !!this.getToken();
  }

  public login(loginRequest: LoginRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.url}/login`, loginRequest);
  }

  public loginT(token: string) {
    this.toggleEvent.next(); // Emite un evento cuando el usuario se autentica
    this.cookieService.set('userState', 'agenda');
    this.setToken(token);
    this.router.navigate(['/']);
  }

  public setToken(token: string) {
    this.cookieService.set('AuthToken', token);
  }

  public getToken(): string | null {
    return this.cookieService.get('AuthToken');
  }

  onToggle() {
    return this.toggleEvent.asObservable();
  }

  emitToggle() {
    this.toggleEvent.next();
  }
}
