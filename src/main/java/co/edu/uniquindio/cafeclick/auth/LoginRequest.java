package co.edu.uniquindio.cafeclick.auth;

import lombok.*;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class LoginRequest {
    String correo;
    String contrasena;
}
