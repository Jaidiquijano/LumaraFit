package LumaraFit.services.interfaz;

import LumaraFit.models.Exercise;
import LumaraFit.models.PhysicalProfile;

import java.util.List;

public interface ITrainingService {
    PhysicalProfile savePhysicalAssessment(PhysicalProfile profile);

    // Obtiene el historial de progresos de un alumno
    List<PhysicalProfile> getUserProgressHistory(String userId);

    // Sugiere ejercicios basados en el somatotipo actual
    List<Exercise> getRecommendedExercises(String somatotype);
}
