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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedidos {
    @Id
    @Column(
        length = 10,
        unique = true
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private @NotNull Long id_pedido;
    private @NotNull Date fechaPedido;
    private @NotNull Date fechaEntrega;
    @Column(
        length = 10
    )
    private @NotNull double total;
    @Column(
        length = 255
    )
    private @NotNull String direccion;
    @Column(
        length = 15
    )
    private @NotNull String telefono;
    @OneToMany(
        mappedBy = "pedido"
    )
    @JsonIgnoreProperties({"pedido"})
    private List<DetallePedido> detallePedidoList;
    @ManyToOne
    @JoinColumn(
        name = "id_usuario"
    )
    @JsonIgnoreProperties({"usuarioPedidosList"})
    private Usuarios usuario;
    @ManyToOne
    @JoinColumn(
        name = "id_estado"
    )
    @JsonIgnoreProperties({"pedidosListEstado"})
    private Estado estado;

}
