package LumaraFit.repositories;

import LumaraFit.models.PhysicalProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PhysicalProfileRepository extends MongoRepository<PhysicalProfile,String> {
    // Encuentra todos los perfiles de un usuario (para ver su evolución)
    List<PhysicalProfile> findByUserId(String userId);

    // Obtiene el último perfil registrado de un usuario específico
    Optional<PhysicalProfile> findFirstByUserIdOrderByAssessmentDateDesc(String userId);

}
