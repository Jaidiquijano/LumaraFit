package LumaraFit.repositories;

import LumaraFit.dto.response.UsuarioResponse;
import LumaraFit.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {

    Optional<Usuario> findByEmail(String email);

    Boolean existsByEmail(String email);

}
