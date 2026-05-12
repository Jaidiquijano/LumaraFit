package LumaraFit.dto.response;

import java.time.LocalDateTime;

public record PerfilFisicoResponse(
        String id,
        String usuarioId,
        double peso,
        double altura,
        double porcentajeGrasaCorporal,
        double circunferenciaBrazo,
        double circunferenciaCintura,
        String somatotipo,
        double[] puntuacionCarter,
        LocalDateTime fechaEvaluacion
) {
}
