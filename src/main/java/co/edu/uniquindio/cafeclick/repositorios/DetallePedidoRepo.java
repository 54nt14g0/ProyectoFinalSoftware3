package co.edu.uniquindio.cafeclick.repositorios;

import co.edu.uniquindio.cafeclick.modelo.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepo extends JpaRepository<DetallePedido, Long> {
}
