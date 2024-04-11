package co.edu.uniquindio.cafeclick.controladores;

import co.edu.uniquindio.cafeclick.modelo.entidades.DetallePedido;
import co.edu.uniquindio.cafeclick.modelo.entidades.Estado;
import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.DetallePedidoServicioImpl;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.EstadoServicioImpl;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.UsuariosServicioImpl;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
    origins = {"http://localhost:4200"}
)
@RequestMapping({"/api"})
@RequiredArgsConstructor
public class Ejemplos {
    private final DetallePedidoServicioImpl detallePedidoServicioImpl;
    private final UsuariosServicioImpl usuariosServicioImpl;
    private final EstadoServicioImpl estadoServicioImpl;


    @GetMapping({"/ejemplo"})
    public ResponseEntity<List<DetallePedido>> listarDetallePedidos() {
        return ResponseEntity.ok(this.detallePedidoServicioImpl.listarDetallePedidos());
    }

    @GetMapping({"/ejemplo2"})
    public ResponseEntity<List<Usuarios>> listarUsuarios() {
        return ResponseEntity.ok(this.usuariosServicioImpl.listarUsuarios());
    }

    @GetMapping({"/ejemplo3"})
    public ResponseEntity<List<Estado>> listarEstados() {
        return ResponseEntity.ok(this.estadoServicioImpl.listarEstados());
    }

    @PostMapping({"/demo"})
    public String welcome() {
        return "Welcome to the demo";
    }
}
