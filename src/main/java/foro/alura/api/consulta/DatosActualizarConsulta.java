package foro.alura.api.consulta;

import lombok.NonNull;

public record DatosActualizarConsulta(
        @NonNull
        Long id,
        String mensaje,
        String curso,
        String titulo) {
}
