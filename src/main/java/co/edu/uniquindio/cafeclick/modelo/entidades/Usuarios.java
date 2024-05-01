//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.uniquindio.cafeclick.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios implements UserDetails {
    @Id
    @Column(
        length = 10,
        unique = true
    )
    @GeneratedValue
    private @NotNull Long id_usuario;
    @Column(
        length = 100
    )
    private String nombre;
    @Column(
        length = 100
    )
    private @NotNull String apellido;
    @Column(
        length = 100,
        unique = true
    )
    private @NotNull @Email String correo;
    @Column(
        length = 100
    )
    private @NotNull String contrasena;
    @Column(
        length = 255
    )
    private @NotNull String direccion;
    @Column(
        length = 15
    )
    private @NotNull String telefono;
    @Column(
        length = 10
    )
    private @NotNull String rol;
    @Column
    private String foto;
    @OneToMany(
        mappedBy = "usuario"
    )
    @JsonIgnoreProperties({"usuario"})
    private List<Pedidos> usuarioPedidosList;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.rol));
    }

    public String getPassword() {
        return this.contrasena;
    }

    public String getUsername() {
        return this.correo;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
