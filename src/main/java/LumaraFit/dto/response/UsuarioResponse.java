package LumaraFit.dto.response;

import java.time.LocalDateTime;

public record UsuarioResponse(
        String id,
        String nombre,
        String apellido,
        String email,
        String curso,
        String rol,
        LocalDateTime fechaCreacion
) {
}
