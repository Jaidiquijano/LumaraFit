package LumaraFit.repositories;

import LumaraFit.models.PerfilFisico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PhysicalProfileRepository extends MongoRepository<PerfilFisico,String> {
    // Encuentra todos los perfiles de un usuario (para ver su evolución)
    List<PerfilFisico> findByUserId(String userId);

    // Obtiene el último perfil registrado de un usuario específico
    Optional<PerfilFisico> findFirstByUserIdOrderByAssessmentDateDesc(String userId);

}
