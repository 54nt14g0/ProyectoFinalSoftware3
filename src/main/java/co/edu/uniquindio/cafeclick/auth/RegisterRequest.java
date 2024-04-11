package co.edu.uniquindio.cafeclick.auth;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequest {
    String usuario;
    String nombre;
    String apellido;
    String correo;
    String contrasena;
    String telefono;
    String direccion;
    String rol;
    String foto;
}
