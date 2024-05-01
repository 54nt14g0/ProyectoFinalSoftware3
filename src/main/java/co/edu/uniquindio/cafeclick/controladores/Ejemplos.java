package co.edu.uniquindio.cafeclick.controladores;

import co.edu.uniquindio.cafeclick.modelo.dto.MensajeDTO;
import co.edu.uniquindio.cafeclick.modelo.entidades.DetallePedido;
import co.edu.uniquindio.cafeclick.modelo.entidades.Estado;
import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.DetallePedidoServicioImpl;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.EstadoServicioImpl;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.ProductosServicioImpl;
import co.edu.uniquindio.cafeclick.servicios.implementaciones.UsuariosServicioImpl;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final ProductosServicioImpl productosServicioImpl;


    @GetMapping({"/ejemplo"})
    public ResponseEntity<?> listarDetallePedidos() {
        return ResponseEntity.ok(new MensajeDTO<>(null, this.detallePedidoServicioImpl.listarDetallePedidos()));
    }

    @GetMapping({"/ejemplo3"})
    public ResponseEntity<List<Estado>> listarEstados() {
        return ResponseEntity.ok(this.estadoServicioImpl.listarEstados());
    }

    @GetMapping({"/productos"})
    public ResponseEntity<?> obtenerProductos() {
        return ResponseEntity.ok(new MensajeDTO<>(null, this.productosServicioImpl.listarProductos()));
    }
    
    @GetMapping({"/clientes"})
    public ResponseEntity<?> obtenerClientes() {
        return ResponseEntity.ok(new MensajeDTO<>(null, this.usuariosServicioImpl.listarUsuarios()));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable Long id) {
        System.out.println("ID: " + id);
        try {
            return ResponseEntity.ok(new MensajeDTO<>(null, this.usuariosServicioImpl.obtenerUsuario(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(e.getMessage(), null));
        }
    }

    @PostMapping({"/demo"})
    public String welcome() {
        return "Welcome to the demo";
    }
}
