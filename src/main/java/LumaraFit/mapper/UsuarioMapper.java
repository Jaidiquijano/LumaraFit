package LumaraFit.mapper;

import LumaraFit.dto.request.UsuarioRequest;
import LumaraFit.dto.response.UsuarioResponse;
import LumaraFit.models.Usuario;

import java.time.LocalDateTime;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.nombre());
        usuario.setApellido(request.apellido());
        usuario.setEmail(request.email());
        usuario.setPassword(request.password());
        usuario.setCurso(request.curso());
        usuario.setRol(request.rol());
        usuario.setFechaCreacion(LocalDateTime.now());
        return usuario;
    }

    public static UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getCurso(),
                usuario.getRol(),
                usuario.getFechaCreacion()
        );
    }
}
