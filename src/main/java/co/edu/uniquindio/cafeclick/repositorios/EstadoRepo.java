package co.edu.uniquindio.cafeclick.repositorios;

import co.edu.uniquindio.cafeclick.modelo.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepo extends JpaRepository<Estado, Long> {
}
