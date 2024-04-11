//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.servicios.implementaciones;

import co.edu.uniquindio.cafeclick.modelo.entidades.Estado;
import co.edu.uniquindio.cafeclick.repositorios.EstadoRepo;
import co.edu.uniquindio.cafeclick.servicios.interfaces.EstadoServicio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EstadoServicioImpl implements EstadoServicio {
    private final EstadoRepo estadoRepo;

    public EstadoServicioImpl(EstadoRepo estadoRepo) {
        this.estadoRepo = estadoRepo;
    }

    public Estado registrarEstado(Estado e) throws Exception {
        return null;
    }

    public Estado actualizarEstado(Estado e) throws Exception {
        return null;
    }

    public void eliminarEstado(Integer id) throws Exception {
    }

    public Estado obtenerEstado(Integer id) throws Exception {
        return null;
    }

    public List<Estado> listarEstados() {
        return this.estadoRepo.findAll();
    }
}
