import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { CloudinaryModule } from '@cloudinary/ng';


import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { provideToastr } from 'ngx-toastr';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { NgxPaginationModule } from 'ngx-pagination';
import { ListaClientesComponent } from './clientes/lista-clientes/lista-clientes.component';
export const appConfig: ApplicationConfig = {
    providers: [
        provideRouter(routes),
        provideClientHydration(),
        provideHttpClient(withFetch()),
        CookieService,
        CloudinaryModule,
        provideToastr(), provideAnimationsAsync(),
        NgxPaginationModule,
        ListaClientesComponent
    ]
};