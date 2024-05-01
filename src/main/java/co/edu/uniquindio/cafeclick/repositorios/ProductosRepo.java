package co.edu.uniquindio.cafeclick.repositorios;

import co.edu.uniquindio.cafeclick.modelo.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepo extends JpaRepository<Productos, Long> {
}
