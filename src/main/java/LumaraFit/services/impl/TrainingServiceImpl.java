package LumaraFit.services.impl;

import LumaraFit.models.Exercise;
import LumaraFit.models.PhysicalProfile;
import LumaraFit.repositories.ExerciseRepository;
import LumaraFit.repositories.PhysicalProfileRepository;
import LumaraFit.services.interfaz.IAnthropometryService;
import LumaraFit.services.interfaz.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingServiceImpl implements ITrainingService {

    @Autowired
    private PhysicalProfileRepository physicalProfileRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private IAnthropometryService anthropometryService;

    @Override
    public PhysicalProfile savePhysicalAssessment(PhysicalProfile profile) {
        // 1. Calculamos el somatotipo y las puntuaciones Carter usando el servicio especializado
        PhysicalProfile analyzedProfile = anthropometryService.processAssessment(profile);

        // 2. Establecemos la fecha de la evaluación
        analyzedProfile.setAssessmentDate(LocalDateTime.now());

        // 3. Guardamos en MongoDB
        return physicalProfileRepository.save(analyzedProfile);
    }

    @Override
    public List<PhysicalProfile> getUserProgressHistory(String userId) {
        // Obtenemos todos los registros del usuario para que React pueda hacer una gráfica de evolución
        return physicalProfileRepository.findByUserId(userId);
    }

    @Override
    public List<Exercise> getRecommendedExercises(String somatotype) {
        /* Lógica de recomendación:
           Aquí podrías mapear el somatotipo a grupos musculares o dificultades.
           Por ejemplo, si es ENDOMORPH, podrías priorizar ejercicios de alta intensidad.
        */
        if ("ECTOMORPH".equalsIgnoreCase(somatotype)) {
            // Ejemplo: Los ectomorfos suelen necesitar ejercicios compuestos pesados
            return exerciseRepository.findByDifficultyLevel("HARD");
        } else if ("ENDOMORPH".equalsIgnoreCase(somatotype)) {
            // Ejemplo: Los endomorfos pueden beneficiarse de circuitos
            return exerciseRepository.findByDifficultyLevel("MEDIUM");
        } else {
            // Mesomorfos: Todo terreno
            return exerciseRepository.findAll();
        }
    }
}