export class RegistroRequest {
    nombre: string = "";
    apellido: string = "";
    correo: string = "";
    contrasena: string = "";
    telefono: string | null | undefined = null;
    direccion: string | null | undefined = null;
    rol: string = "";
    foto: string | null | undefined = null;
}
