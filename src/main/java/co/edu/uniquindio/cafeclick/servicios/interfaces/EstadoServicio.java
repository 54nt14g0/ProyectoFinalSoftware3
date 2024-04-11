package co.edu.uniquindio.cafeclick.servicios.interfaces;

import co.edu.uniquindio.cafeclick.modelo.entidades.Estado;
import java.util.List;

public interface EstadoServicio {
    Estado registrarEstado(Estado e) throws Exception;

    Estado actualizarEstado(Estado e) throws Exception;

    void eliminarEstado(Integer id) throws Exception;

    Estado obtenerEstado(Integer id) throws Exception;

    List<Estado> listarEstados();
}
