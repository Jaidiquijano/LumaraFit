package LumaraFit.controllers;

import LumaraFit.models.Exercise;
import LumaraFit.models.PhysicalProfile;
import LumaraFit.services.interfaz.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training")
@CrossOrigin(origins = "*")
public class TrainingController {

    @Autowired
    private ITrainingService trainingService;

    // Endpoint para enviar nuevas medidas y obtener el somatotipo
    @PostMapping("/assessment")
    public ResponseEntity<PhysicalProfile> createAssessment(@RequestBody PhysicalProfile profile) {
        return ResponseEntity.ok(trainingService.savePhysicalAssessment(profile));
    }

    // Endpoint para obtener el historial de un alumno
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<PhysicalProfile>> getHistory(@PathVariable String userId) {
        return ResponseEntity.ok(trainingService.getUserProgressHistory(userId));
    }

    // Endpoint para obtener recomendaciones basadas en el somatotipo
    @GetMapping("/recommendations/{somatotype}")
    public ResponseEntity<List<Exercise>> getRecommendations(@PathVariable String somatotype) {
        return ResponseEntity.ok(trainingService.getRecommendedExercises(somatotype));
    }
}