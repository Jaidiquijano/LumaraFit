package LumaraFit.repositories;

import LumaraFit.models.Ejercicio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EjercicioRepository extends MongoRepository<Ejercicio,String> {

    List<Ejercicio> findByGrupoMuscular(String grupoMuscular);
    List<Ejercicio> findByNivelDificultad(String nivelDificultad);
}
