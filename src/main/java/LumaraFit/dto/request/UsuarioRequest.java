package LumaraFit.dto.request;

public record UsuarioRequest(
        String nombre,
        String apellido,
        String email,
        String password,
        String curso,
        String rol
) {
}
