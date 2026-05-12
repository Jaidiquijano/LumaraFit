package LumaraFit.dto.request;

public record EjercicioRequest(
        String nombre,
        String descripcion,
        String grupoMuscular,
        String videoUrl,
        String nivelDificultad
) {
}
