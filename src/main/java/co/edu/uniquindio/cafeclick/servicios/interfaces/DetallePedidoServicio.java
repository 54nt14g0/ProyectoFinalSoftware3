package co.edu.uniquindio.cafeclick.servicios.interfaces;

import co.edu.uniquindio.cafeclick.modelo.entidades.DetallePedido;
import java.util.List;

public interface DetallePedidoServicio {
    DetallePedido registrarDetallePedido(DetallePedido dp) throws Exception;

    DetallePedido actualizarDetallePedido(DetallePedido dp) throws Exception;

    void eliminarDetallePedido(Integer id) throws Exception;

    DetallePedido obtenerDetallePedido(Integer id) throws Exception;

    List<DetallePedido> listarDetallePedidos();
}