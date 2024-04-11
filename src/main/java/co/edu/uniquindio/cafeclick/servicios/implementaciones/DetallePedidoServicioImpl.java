package co.edu.uniquindio.cafeclick.servicios.implementaciones;

import co.edu.uniquindio.cafeclick.modelo.entidades.DetallePedido;
import co.edu.uniquindio.cafeclick.repositorios.DetallePedidoRepo;
import co.edu.uniquindio.cafeclick.servicios.interfaces.DetallePedidoServicio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DetallePedidoServicioImpl implements DetallePedidoServicio {
    private final DetallePedidoRepo detallePedidoRepo;

    public DetallePedidoServicioImpl(DetallePedidoRepo detallePedidoRepo) {
        this.detallePedidoRepo = detallePedidoRepo;
    }

    public DetallePedido registrarDetallePedido(DetallePedido dp) throws Exception {
        return null;
    }

    public DetallePedido actualizarDetallePedido(DetallePedido dp) throws Exception {
        return null;
    }

    public void eliminarDetallePedido(Integer id) throws Exception {
    }

    public DetallePedido obtenerDetallePedido(Integer id) throws Exception {
        return null;
    }

    public List<DetallePedido> listarDetallePedidos() {
        return this.detallePedidoRepo.findAll();
    }
}
