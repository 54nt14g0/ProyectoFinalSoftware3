//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetallePedido {
    @Id
    @Column(
        length = 10,
        unique = true
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private @NotNull Long id_detalle_pedido;
    private @NotNull int cantidad;
    private double descuento;
    private @NotNull double precioCompra;
    private @NotNull double precioVenta;
    private @NotNull double subtotal;
    @ManyToOne
    @JoinColumn(
        name = "id_producto"
    )
    @JsonIgnoreProperties({"detallePedidoListProducto"})
    private Productos producto;
    @ManyToOne
    @JoinColumn(
        name = "id_pedido"
    )
    @JsonIgnoreProperties({"detallePedidoList"})
    private Pedidos pedido;

}
