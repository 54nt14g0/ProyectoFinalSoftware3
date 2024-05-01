package co.edu.uniquindio.cafeclick.servicios.implementaciones;

import co.edu.uniquindio.cafeclick.modelo.entidades.Productos;
import co.edu.uniquindio.cafeclick.repositorios.ProductosRepo;
import co.edu.uniquindio.cafeclick.servicios.interfaces.ProductosServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductosServicioImpl implements ProductosServicio {
    private final ProductosRepo productosRepo;
    @Override
    public Productos registrarProducto(Productos p) throws Exception {
        return null;
    }

    @Override
    public Productos actualizarProducto(Productos p) throws Exception {
        return null;
    }

    @Override
    public void eliminarProducto(Integer id) throws Exception {

    }

    @Override
    public Productos obtenerProducto(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Productos> listarProductos() {
        return productosRepo.findAll();
    }
}
