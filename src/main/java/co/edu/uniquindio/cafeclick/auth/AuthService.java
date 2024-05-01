//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.auth;

import co.edu.uniquindio.cafeclick.jwt.JwtService;
import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import co.edu.uniquindio.cafeclick.repositorios.UsuariosRepo;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.UsuariosServicioImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuariosServicioImpl usuariosServicio;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UsuariosRepo usuariosRepo;

    public AuthResponse login(LoginRequest request) {
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContrasena()));
        UserDetails usuario = usuariosRepo.findByCorreo(request.getCorreo()).orElseThrow();
        String token = this.jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .error(null)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuarios usuario = Usuarios.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .correo(request.getCorreo())
                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .telefono(request.getTelefono())
                .direccion(request.getDireccion())
                .rol(request.getRol())
                .foto(request.getFoto())
                .build();
        try {
            this.usuariosServicio.registrarUsuario(usuario);
            return AuthResponse.builder()
                    .token("Si")
                    .error(null)
                    .build();
        } catch (Exception var4) {
            return AuthResponse.builder()
                    .token(null)
                    .error(var4.getMessage())
                    .build();
        }
    }

}
