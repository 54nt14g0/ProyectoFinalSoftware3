import { Injectable } from '@angular/core';
import { Router, NavigationStart } from '@angular/router';
import { filter } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class NavegacionService {
  constructor(private router: Router, private cookieService: CookieService) {
    // Suscríbete a eventos de navegación
    this.router.events
      .pipe(filter((event): event is NavigationStart => event instanceof NavigationStart))
      .subscribe((event: NavigationStart) => {
        // Guarda la URL actual como cookie justo antes de navegar a una nueva página
        if(event.url !== '/login'){
          this.cookieService.set('currentUrl', event.url);
        }
      });
  }

// Método para obtener la URL actual de la cookie
  getCurrentUrl(): string | null {
    return this.cookieService.get('currentUrl');
  }
}
