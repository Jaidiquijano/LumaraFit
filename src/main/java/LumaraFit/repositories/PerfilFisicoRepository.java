package LumaraFit.repositories;

import LumaraFit.models.PerfilFisico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PerfilFisicoRepository extends MongoRepository<PerfilFisico,String> {

    List<PerfilFisico> findByUsuarioId(String userId);
    Optional<PerfilFisico> findFirstByUsuarioIdOrderByFechaEvaluacionDesc(String usuarioId);

}
