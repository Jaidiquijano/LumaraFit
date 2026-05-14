package LumaraFit.services.interfaz;

import LumaraFit.dto.request.UsuarioRequest;
import LumaraFit.dto.response.UsuarioResponse;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    UsuarioResponse registrarUsuario(UsuarioRequest datosRegistro);
    Optional<UsuarioResponse> buscarPorEmail(String email);
    UsuarioResponse actualizarUsuario(String id, UsuarioRequest datosActualizados);
    List<UsuarioResponse> obtenerTodosLosEstudiantes();
    void eliminarUsuario(String id);
    Optional<UsuarioResponse> obtenerUsuarioId(String id);
}
