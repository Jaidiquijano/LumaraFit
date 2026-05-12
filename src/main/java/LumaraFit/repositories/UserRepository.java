package LumaraFit.repositories;

import LumaraFit.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Usuario,String> {


    // Busca un usuario por email para el proceso de autenticación
    Optional<Usuario> findByEmail(String email);

    // Verifica si un email ya está registrado
    Boolean existsByEmail(String email);
}
