package co.edu.uniquindio.cafeclick.repositorios;

import co.edu.uniquindio.cafeclick.modelo.entidades.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepo extends JpaRepository<Usuarios, Long> {
    @Query("SELECT u FROM Usuarios u WHERE u.correo = ?1")
    Usuarios obtener(String correo);

    boolean existsByCorreo(String correo);

    Optional<Usuarios> findByCorreo(String correo);
}
