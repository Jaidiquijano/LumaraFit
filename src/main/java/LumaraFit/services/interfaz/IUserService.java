package LumaraFit.services.interfaz;

import LumaraFit.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Usuario registerUser(Usuario user);
    Optional<Usuario> findByEmail(String email);
    Usuario updateUser(String id, Usuario user);
    List<Usuario> getAllStudents();
    void deleteUser(String id);
}
