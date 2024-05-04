//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.servicios.implementaciones;

import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import co.edu.uniquindio.cafeclick.repositorios.UsuariosRepo;
import co.edu.uniquindio.cafeclick.servicios.interfaces.UsuariosServicio;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosServicioImpl implements UsuariosServicio {
    private final UsuariosRepo usuariosRepo;

    public Usuarios registrarUsuario(Usuarios u) throws Exception {
        System.out.println(u.getId_usuario());
        if (this.estaOcupadoEmail(u.getCorreo())) {
            throw new Exception("El correo ya está en uso");
        } else {
            return this.usuariosRepo.save(u);
        }
    }

    public Usuarios actualizarUsuario(Usuarios u) throws Exception {
        return null;
    }

    public void eliminarUsuario(Integer id) throws Exception {
    }

    public Optional<Usuarios> obtenerUsuario(Long id) throws Exception {
        Usuarios usuario = this.usuariosRepo.obtener(id);
        if(usuario.getUsuarioPedidosList() == null){
            usuario.setUsuarioPedidosList(new ArrayList<>());
        }
        return Optional.of(usuario);
    }

    @Override
    public Optional<Usuarios> obtenerUsuarioPorCorreo(String correo) throws Exception {
        return this.usuariosRepo.findByCorreo(correo);
    }

    public List<Usuarios> listarUsuarios() {
        return this.usuariosRepo.findAll();
    }

    public boolean estaOcupadoEmail(String correo) {
        return this.usuariosRepo.existsByCorreo(correo);
    }
}
