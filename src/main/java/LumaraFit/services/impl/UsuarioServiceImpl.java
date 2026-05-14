package LumaraFit.services.impl;

import LumaraFit.dto.request.UsuarioRequest;
import LumaraFit.dto.response.UsuarioResponse;
import LumaraFit.mapper.UsuarioMapper;
import LumaraFit.models.Usuario;
import LumaraFit.repositories.UsuarioRepository;
import LumaraFit.services.interfaz.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse registrarUsuario(UsuarioRequest datosRegistro) {
        if (usuarioRepository.existsByEmail(datosRegistro.email())) {
            throw new RuntimeException("Error: El email ya está registrado");
        }
        Usuario usuario = UsuarioMapper.toEntity(datosRegistro);
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) {
            usuario.setRol("ESTUDIANTE");
        }
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponse(usuarioGuardado);
    }

    @Override
    public Optional<UsuarioResponse> obtenerUsuarioId(String id) {
            return usuarioRepository.findById(id).map(UsuarioMapper::toResponse);
    }


    @Override
    public Optional<UsuarioResponse> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .map(UsuarioMapper::toResponse);
    }

    @Override
    public UsuarioResponse actualizarUsuario(String id, UsuarioRequest datos) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(datos.nombre());
            usuario.setApellido(datos.apellido());
            usuario.setCurso(datos.curso());
            Usuario actualizado = usuarioRepository.save(usuario);
            return UsuarioMapper.toResponse(actualizado);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @Override
    public List<UsuarioResponse> obtenerTodosLosEstudiantes() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarUsuario(String id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("El usuario no existe");
        }
        usuarioRepository.deleteById(id);
    }

}