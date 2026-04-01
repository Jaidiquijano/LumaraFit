package LumaraFit.repositories;

import LumaraFit.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {


    // Busca un usuario por email para el proceso de autenticación
    Optional<User> findByEmail(String email);

    // Verifica si un email ya está registrado
    Boolean existsByEmail(String email);
}
