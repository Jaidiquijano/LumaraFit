package LumaraFit.controllers;

import LumaraFit.dto.request.EjercicioRequest;
import LumaraFit.dto.response.EjercicioResponse;
import LumaraFit.mapper.EjercicioMapper;
import LumaraFit.models.Ejercicio;
import LumaraFit.repositories.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ejercicios")
@CrossOrigin(origins = "*")
public class EjercicioController {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    // Obtener todos los ejercicios del catálogo
    @GetMapping
    public ResponseEntity<List<EjercicioResponse>> obtenerTodos() {
        List<EjercicioResponse> ejercicios = ejercicioRepository.findAll().stream()
                .map(EjercicioMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ejercicios);
    }

    // Crear un nuevo ejercicio (útil para el panel de administrador/profesor)
    @PostMapping
    public ResponseEntity<EjercicioResponse> crear(@RequestBody EjercicioRequest datos) {
        Ejercicio ejercicio = EjercicioMapper.toEntity(datos);
        Ejercicio guardado = ejercicioRepository.save(ejercicio);
        return ResponseEntity.ok(EjercicioMapper.toResponse(guardado));
    }

    // Buscar ejercicios por grupo muscular (ej: "Pecho", "Piernas")
    @GetMapping("/musculo/{grupo}")
    public ResponseEntity<List<EjercicioResponse>> obtenerPorMusculo(@PathVariable String grupo) {
        List<EjercicioResponse> ejercicios = ejercicioRepository.findByGrupoMuscular(grupo).stream()
                .map(EjercicioMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ejercicios);
    }
}