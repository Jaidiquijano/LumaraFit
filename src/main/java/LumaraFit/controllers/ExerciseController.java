package LumaraFit.controllers;

import LumaraFit.models.Ejercicio;
import LumaraFit.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "*")
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @GetMapping
    public ResponseEntity<List<Ejercicio>> getAll() {
        return ResponseEntity.ok(exerciseRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Ejercicio> create(@RequestBody Ejercicio exercise) {
        return ResponseEntity.ok(exerciseRepository.save(exercise));
    }

    @GetMapping("/muscle/{group}")
    public ResponseEntity<List<Ejercicio>> getByMuscle(@PathVariable String group) {
        return ResponseEntity.ok(exerciseRepository.findByMuscleGroup(group));
    }
}