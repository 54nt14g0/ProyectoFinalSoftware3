import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators, FormsModule } from '@angular/forms';
import { RegistroRequest } from '../../modelo/registro-request';
import { AuthService } from '../../servicios/auth.service';
import { NotificacionesService } from '../../servicios/toastr.service';


@Component({
  selector: 'app-crear-cliente',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, FormsModule],
  templateUrl: './crear-cliente.component.html',
  styleUrl: './crear-cliente.component.css'
})
export class CrearClienteComponent {
  registroFallido = false;
  mensajeError = '';
  crearClienteForm: FormGroup;
  crearClientePressed: boolean = false;

  constructor(private fb: FormBuilder, private authService: AuthService, private toastr: NotificacionesService) {
    this.crearClienteForm = this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      correo: ['', Validators.required],
      contrasena: ['', Validators.required],
      direccion: ['', Validators.required],
      telefono: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  limpiarFormulario() {
    this.crearClienteForm.reset();
    this.crearClientePressed = false;
  }

  onSubmit(): void {
    if (!this.crearClientePressed) {
      this.crearClientePressed = true;
    }
    if (this.crearClienteForm.valid) {
      this.registroFallido = false;
      const registroRequest: RegistroRequest = {
        nombre: this.crearClienteForm.value.nombre,
        apellido: this.crearClienteForm.value.apellido,
        correo: this.crearClienteForm.value.correo,
        contrasena: this.crearClienteForm.value.contrasena,
        telefono: this.crearClienteForm.value.telefono,
        direccion: this.crearClienteForm.value.direccion,
        rol: 'usuario',
        foto: null
      };
      console.log(registroRequest);
      this.authService.registro(registroRequest).subscribe({
        next: data => {
          if (data.token != null) {
            this.limpiarFormulario();
            this.toastr.mostrarMensaje(1, "Cliente registrado exitosamente", "Exito")
          } else {
            console.log(data.error)
            this.toastr.mostrarMensaje(2, data.error, "Error")
            this.registroFallido = true;
          }
        },
        error: error => {
          this.toastr.mostrarMensaje(2,"Error al registrar el usuraio", "Error");
          this.registroFallido = true;
        }
      });
    } else {
      this.registroFallido = true;
      this.mensajeError = "Por favor, llene todos los campos obligatorios."
    }

  }
}
