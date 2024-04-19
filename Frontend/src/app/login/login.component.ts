import { Component } from '@angular/core';
import { AuthService } from '../servicios/auth.service';
import { LoginRequest } from '../modelo/login-request';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { NavegacionService } from '../servicios/navegacion.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  usuario = {
    correo: '',
    contrasena: ''
  };
  sesionFallida = false;

  constructor(private authService: AuthService, private router: Router, private navegacion:NavegacionService) {}

  ngOnInit() {
    // Verifica si el usuario ya está autenticado
    if (this.loggedIn) {
      // Obtiene la URL anterior
        const anteriorURL = this.navegacion.getCurrentUrl();
        // Redirige a la URL anterior
        if(anteriorURL){
            this.router.navigateByUrl(anteriorURL);
        // Redirige a la página principal
        }else{
            this.router.navigate(['/']);
        }
    }
}

  // Verifica si el usuario está autenticado
  get loggedIn() {
    return this.authService.isLogged();
  }

  // Método para enviar el formulario
  onSubmit() {
    const loginRequest: LoginRequest = {
      correo: this.usuario.correo,
      contrasena: this.usuario.contrasena
    };

    // Llama al servicio de autenticación
    this.authService.login(loginRequest).subscribe({
      next: data => {
        this.authService.loginT(data.token);
        this.authService.emitToggle();
      },
      error: error => {
        console.error('Error de autenticación:', error);
        this.sesionFallida = true;
      }
    });
  }
}
