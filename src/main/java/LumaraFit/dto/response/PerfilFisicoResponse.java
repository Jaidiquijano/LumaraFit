package LumaraFit.dto.response;

import java.time.LocalDateTime;

public record PerfilFisicoResponse(
        String id,
        String usuarioId,
        double peso,
        double altura,
        String somatotipo,
        double[] puntuacionCarter,
        LocalDateTime fechaEvaluacion
) {
}
