//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.servicios.implementaciones;

import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import co.edu.uniquindio.cafeclick.repositorios.UsuariosRepo;
import co.edu.uniquindio.cafeclick.servicios.interfaces.UsuariosServicio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuariosServicioImpl implements UsuariosServicio {
    private final UsuariosRepo usuariosRepo;

    public UsuariosServicioImpl(UsuariosRepo usuariosRepo) {
        this.usuariosRepo = usuariosRepo;
    }

    public Usuarios registrarUsuario(Usuarios u) throws Exception {
        System.out.println(u.getId_usuario());
        if (this.estaOcupadoEmail(u.getCorreo())) {
            throw new Exception("El correo " + u.getCorreo() + " ya está en uso");
        } else {
            return (Usuarios)this.usuariosRepo.save(u);
        }
    }

    public Usuarios actualizarUsuario(Usuarios u) throws Exception {
        return null;
    }

    public void eliminarUsuario(Integer id) throws Exception {
    }

    public Usuarios obtenerUsuario(Integer id) throws Exception {
        return null;
    }

    public List<Usuarios> listarUsuarios() {
        return this.usuariosRepo.findAll();
    }

    public boolean estaOcupadoEmail(String correo) {
        return this.usuariosRepo.existsByCorreo(correo);
    }
}
