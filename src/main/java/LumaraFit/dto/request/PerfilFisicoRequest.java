package LumaraFit.dto.request;

public record PerfilFisicoRequest(
        String usuarioId,
        double peso,
        double altura,
        double porcentajeGrasaCorporal,
        double circunferenciaBrazo,
        double circunferenciaCintura
) {
}
