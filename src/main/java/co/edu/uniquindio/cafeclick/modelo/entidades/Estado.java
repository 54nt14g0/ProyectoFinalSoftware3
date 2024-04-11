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
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado {
    @Id
    @Column(
        length = 10,
        unique = true
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private @NotNull Long id_estado;
    @Column(
        length = 10
    )
    private @NotNull String nombre;
    @Column
    private @NotNull String descripcion;
    @OneToMany(
        mappedBy = "estado"
    )
    @JsonIgnoreProperties({"estado"})
    private List<Pedidos> pedidosListEstado;
}
