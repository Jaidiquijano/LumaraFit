package LumaraFit.controllers;

import LumaraFit.dto.request.PerfilFisicoRequest;
import LumaraFit.dto.response.EjercicioResponse;
import LumaraFit.dto.response.PerfilFisicoResponse;
import LumaraFit.services.interfaz.IEntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenamiento")
@CrossOrigin(origins = "*")
public class EntrenamientoController {

    @Autowired
    private IEntrenamientoService entrenamientoService;

    // Antes: /assessment - Envía medidas y recibe el perfil con somatotipo calculado
    @PostMapping("/evaluacion")
    public ResponseEntity<PerfilFisicoResponse> crearEvaluacion(@RequestBody PerfilFisicoRequest datosPerfil) {
        return ResponseEntity.ok(entrenamientoService.guardarEvaluacionFisica(datosPerfil));
    }

    // Antes: /history/{userId} - Obtiene la evolución del alumno
    @GetMapping("/historial/{usuarioId}")
    public ResponseEntity<List<PerfilFisicoResponse>> obtenerHistorial(@PathVariable String usuarioId) {
        return ResponseEntity.ok(entrenamientoService.obtenerHistorialProgreso(usuarioId));
    }

    // Antes: /recommendations/{somatotype} - Ejercicios sugeridos
    @GetMapping("/recomendaciones/{somatotipo}")
    public ResponseEntity<List<EjercicioResponse>> obtenerRecomendaciones(@PathVariable String somatotipo) {
        return ResponseEntity.ok(entrenamientoService.obtenerEjerciciosRecomendados(somatotipo));
    }
}