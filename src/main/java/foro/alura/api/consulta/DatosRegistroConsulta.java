package foro.alura.api.consulta;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroConsulta(


        @NotBlank
        String mensaje,
        @NotBlank
        String curso,
        @NotBlank
        String titulo) {
}
