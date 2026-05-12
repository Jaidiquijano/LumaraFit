package LumaraFit.dto.response;

public record EjercicioResponse(
        String id,
        String nombre,
        String descripcion,
        String grupoMuscular,
        String videoUrl,
        String nivelDificultad
) {
}
