package LumaraFit.mapper;

import LumaraFit.dto.request.EjercicioRequest;
import LumaraFit.dto.response.EjercicioResponse;
import LumaraFit.models.Ejercicio;

public class EjercicioMapper {
    public static Ejercicio toEntity(EjercicioRequest request) {
        Ejercicio ejercicio = new Ejercicio();
        ejercicio.setNombre(request.nombre());
        ejercicio.setDescripcion(request.descripcion());
        ejercicio.setGrupoMuscular(request.grupoMuscular());
        ejercicio.setVideoUrl(request.videoUrl());
        ejercicio.setNivelDificultad(request.nivelDificultad());
        return ejercicio;
    }

    public static EjercicioResponse toResponse(Ejercicio ejercicio) {
        return new EjercicioResponse(
                ejercicio.getId(),
                ejercicio.getNombre(),
                ejercicio.getDescripcion(),
                ejercicio.getGrupoMuscular(),
                ejercicio.getVideoUrl(),
                ejercicio.getNivelDificultad()
        );
    }
}
