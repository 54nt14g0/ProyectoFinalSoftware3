package co.edu.uniquindio.cafeclick.servicios.interfaces;

import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import java.util.List;
import java.util.Optional;

public interface UsuariosServicio {
    Usuarios registrarUsuario(Usuarios u) throws Exception;

    Usuarios actualizarUsuario(Usuarios u) throws Exception;

    void eliminarUsuario(Integer id) throws Exception;

    Optional<Usuarios> obtenerUsuario(Long id) throws Exception;

    Optional<Usuarios> obtenerUsuarioPorCorreo(String correo) throws Exception;

    List<Usuarios> listarUsuarios();
}