package co.edu.uniquindio.cafeclick.servicios.interfaces;

import co.edu.uniquindio.cafeclick.modelo.entidades.Productos;

import java.util.List;

public interface ProductosServicio {

    Productos registrarProducto(Productos p) throws Exception;
    Productos actualizarProducto(Productos p) throws Exception;
    void eliminarProducto(Integer id) throws Exception;
    Productos obtenerProducto(Integer id) throws Exception;
    List<Productos> listarProductos();
}
