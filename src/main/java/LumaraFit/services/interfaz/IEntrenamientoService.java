package LumaraFit.services.interfaz;

import LumaraFit.dto.request.PerfilFisicoRequest;
import LumaraFit.dto.response.EjercicioResponse;
import LumaraFit.dto.response.PerfilFisicoResponse;
import LumaraFit.models.Ejercicio;
import LumaraFit.models.PerfilFisico;

import java.util.List;

public interface IEntrenamientoService {

    PerfilFisicoResponse guardarEvaluacionFisica(PerfilFisicoRequest datosPerfil);
    List<PerfilFisicoResponse> obtenerHistorialProgreso(String usuarioId);
    List<EjercicioResponse> obtenerEjerciciosRecomendados(String somatotipo);
}
