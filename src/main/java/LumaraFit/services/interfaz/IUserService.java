package LumaraFit.services.interfaz;

import LumaraFit.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User registerUser(User user);
    Optional<User> findByEmail(String email);
    User updateUser(String id, User user);
    List<User> getAllStudents();
    void deleteUser(String id);
}
