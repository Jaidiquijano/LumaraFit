package LumaraFit.services.impl;

import LumaraFit.dto.request.PerfilFisicoRequest;
import LumaraFit.dto.response.EjercicioResponse;
import LumaraFit.dto.response.PerfilFisicoResponse;
import LumaraFit.mapper.EjercicioMapper;
import LumaraFit.mapper.PerfilFisicoMapper;
import LumaraFit.models.Ejercicio;
import LumaraFit.models.PerfilFisico;
import LumaraFit.repositories.EjercicioRepository;
import LumaraFit.repositories.PerfilFisicoRepository;
import LumaraFit.services.interfaz.IAntropometriaService;
import LumaraFit.services.interfaz.IEntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrenamientoServiceImpl implements IEntrenamientoService {

    @Autowired
    private PerfilFisicoRepository perfilRepository;

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Autowired
    private IAntropometriaService antropometriaService;

    @Override
    public PerfilFisicoResponse guardarEvaluacionFisica(PerfilFisicoRequest datosPerfil) {

        PerfilFisico perfil = PerfilFisicoMapper.toEntity(datosPerfil);
        perfil = antropometriaService.procesarEvaluacion(perfil);
        perfil.setFechaEvaluacion(LocalDateTime.now());
        PerfilFisico guardado = perfilRepository.save(perfil);
        return PerfilFisicoMapper.toResponse(guardado);
    }

    @Override
    public List<PerfilFisicoResponse> obtenerHistorialProgreso(String usuarioId) {

        return perfilRepository.findByUsuarioId(usuarioId).stream()
                .map(PerfilFisicoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EjercicioResponse> obtenerEjerciciosRecomendados(String somatotipo) {
        List<Ejercicio> ejercicios;


        if ("ECTOMORFO".equalsIgnoreCase(somatotipo)) {
            ejercicios = ejercicioRepository.findByNivelDificultad("ALTA");
        } else if ("ENDOMORFO".equalsIgnoreCase(somatotipo)) {
            ejercicios = ejercicioRepository.findByNivelDificultad("MEDIA");
        } else {
            ejercicios = ejercicioRepository.findAll();
        }


        return ejercicios.stream()
                .map(EjercicioMapper::toResponse)
                .collect(Collectors.toList());
    }
}