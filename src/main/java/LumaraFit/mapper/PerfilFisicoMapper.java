package LumaraFit.mapper;

import LumaraFit.dto.request.PerfilFisicoRequest;
import LumaraFit.dto.response.PerfilFisicoResponse;
import LumaraFit.models.PerfilFisico;

public class PerfilFisicoMapper {
    public static PerfilFisico toEntity(PerfilFisicoRequest request) {
        PerfilFisico perfil = new PerfilFisico();
        perfil.setUsuarioId(request.usuarioId());
        perfil.setPeso(request.peso());
        perfil.setAltura(request.altura());
        return perfil;
    }

    public static PerfilFisicoResponse toResponse(PerfilFisico perfil) {
        return new PerfilFisicoResponse(
                perfil.getId(),
                perfil.getUsuarioId(),
                perfil.getPeso(),
                perfil.getAltura(),
                perfil.getSomatotipo(),
                perfil.getPuntuacionCarter(),
                perfil.getFechaEvaluacion()
        );
    }
}
