package foro.alura.api.consulta;

import jakarta.validation.constraints.NotBlank;

public record DatosRespuetaConsulta(long id, String mensaje,
                                    String curso,
                                    String titulo) {
}
