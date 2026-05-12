package LumaraFit.services.interfaz;

import LumaraFit.models.Ejercicio;
import LumaraFit.models.PerfilFisico;

import java.util.List;

public interface ITrainingService {
    PerfilFisico savePhysicalAssessment(PerfilFisico profile);

    // Obtiene el historial de progresos de un alumno
    List<PerfilFisico> getUserProgressHistory(String userId);

    // Sugiere ejercicios basados en el somatotipo actual
    List<Ejercicio> getRecommendedExercises(String somatotype);
}
