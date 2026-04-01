package LumaraFit.repositories;

import LumaraFit.models.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExerciseRepository extends MongoRepository<Exercise,String> {
    // Filtra ejercicios por grupo muscular (ej. "Chest", "Legs")
    List<Exercise> findByMuscleGroup(String muscleGroup);

    // Filtra por nivel de dificultad
    List<Exercise> findByDifficultyLevel(String difficultyLevel);
}
