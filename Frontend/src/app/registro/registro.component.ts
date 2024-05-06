import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators, FormsModule } from '@angular/forms';
import { RegistroRequest } from '../modelo/registro-request';
import { AuthService } from '../servicios/auth.service';
import { Router } from '@angular/router';
import { NavegacionService } from '../servicios/navegacion.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, FormsModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  sesionFallida = false;
  registroForm: FormGroup;
  registeredPressed: boolean = false;
  mensajeError = '';

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

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router, private navegacion:NavegacionService) {
    this.registroForm = this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      correo: ['', Validators.required],
      contrasena: ['', Validators.required],
      direccion: ['', Validators.required],
      telefono: ['', Validators.required]
    });
  }

  validarValores(){
    if(this.registroForm.value.telefono == ''){
      this.registroForm.value.telefono = null;
    }
    if(this.registroForm.value.direccion == ''){
      this.registroForm.value.direccion = null;
    }
  }

    onSubmit() {
      if(!this.registeredPressed){
        this.registeredPressed = true;
      }
      this.validarValores();
      if (this.registroForm.valid) {
        // Procesar los datos de registro
        const registroRequest: RegistroRequest = {
          nombre: this.registroForm.value.nombre,
          apellido: this.registroForm.value.apellido,
          correo: this.registroForm.value.correo,
          contrasena: this.registroForm.value.contrasena,
          telefono: this.registroForm.value.telefono,
          direccion: this.registroForm.value.direccion,
          rol: 'usuario',
          foto: null
        };

        console.log(registroRequest);

        this.authService.registro(registroRequest).subscribe({
          next: data => {
            if(data.token != null){
            this.router.navigate(['/login']);
            } else {
              this.mensajeError = data.error;
              this.sesionFallida = true;
            }
      },
      error: error => {
        console.error('Error de autenticación:', error);
        this.sesionFallida = true;
      }
      });
    }
  }
  // Verifica si el usuario está autenticado
  get loggedIn() {
    return this.authService.isLogged();
  }
}
