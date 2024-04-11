package co.edu.uniquindio.cafeclick.servicios.interfaces;

import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import java.util.List;

public interface UsuariosServicio {
    Usuarios registrarUsuario(Usuarios u) throws Exception;

    Usuarios actualizarUsuario(Usuarios u) throws Exception;

    void eliminarUsuario(Integer id) throws Exception;

    Usuarios obtenerUsuario(Integer id) throws Exception;

    List<Usuarios> listarUsuarios();
}