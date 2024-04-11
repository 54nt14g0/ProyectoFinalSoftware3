//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Productos {
    @Id
    @Column(
        length = 10,
        unique = true
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private @NotNull Long id_producto;
    @Column(
        length = 100
    )
    private @NotNull String nombre;
    @Column(
        length = 500
    )
    private @NotNull String descripcion;
    @Column(
        length = 10
    )
    private @NotNull double precioCompra;
    @Column(
        length = 10
    )
    private @NotNull double precioVenta;
    @Column(
        length = 10
    )
    private @NotNull int cantidad;
    @OneToMany(
        mappedBy = "producto"
    )
    private List<DetallePedido> detallePedidoListProducto;
}
