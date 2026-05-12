package LumaraFit.services.impl;

import LumaraFit.models.Usuario;
import LumaraFit.repositories.UserRepository;
import LumaraFit.services.interfaz.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Usuario registerUser(Usuario user) {
        // Verificamos si el email ya existe en la base de datos
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        // Seteamos la fecha de creación y el rol por defecto si viene vacío
        user.setCreatedAt(LocalDateTime.now());
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("STUDENT");
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Usuario updateUser(String id, Usuario userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setSchoolGrade(userDetails.getSchoolGrade());
            // No solemos actualizar el email o el password aquí por seguridad
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<Usuario> getAllStudents() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
