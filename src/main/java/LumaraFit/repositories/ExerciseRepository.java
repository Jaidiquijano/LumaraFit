package LumaraFit.repositories;

import LumaraFit.models.Ejercicio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExerciseRepository extends MongoRepository<Ejercicio,String> {
    // Filtra ejercicios por grupo muscular (ej. "Chest", "Legs")
    List<Ejercicio> findByMuscleGroup(String muscleGroup);

    // Filtra por nivel de dificultad
    List<Ejercicio> findByDifficultyLevel(String difficultyLevel);
}
