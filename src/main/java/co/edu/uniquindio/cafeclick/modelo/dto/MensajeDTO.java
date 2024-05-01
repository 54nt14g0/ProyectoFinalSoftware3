package co.edu.uniquindio.cafeclick.modelo.dto;

public record MensajeDTO<T,U>(
        U error,
        T respuesta
) {
}
