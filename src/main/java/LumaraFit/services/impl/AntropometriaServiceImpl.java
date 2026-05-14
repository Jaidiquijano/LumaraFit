package LumaraFit.services.impl;

import LumaraFit.models.PerfilFisico;
import LumaraFit.services.interfaz.IAntropometriaService;
import org.springframework.stereotype.Service;

@Service
public class AntropometriaServiceImpl implements IAntropometriaService {

    @Override
    public PerfilFisico procesarEvaluacion(PerfilFisico perfil) {

        double[] puntuaciones = calcularPuntuacionesHeathCarter(
                perfil.getPeso(),
                perfil.getAltura(),
                perfil.getPorcentajeGrasaCorporal()
        );
        perfil.setPuntuacionCarter(puntuaciones);
        String categoria = determinarCategoriaSomatotipo(puntuaciones);
        perfil.setSomatotipo(categoria);

        return perfil;
    }

    @Override
    public double[] calcularPuntuacionesHeathCarter(double peso, double altura, double porcentajeGrasa) {
        double[] puntuaciones = new double[3];

        // --- 1. ENDOMORFIA ---
        puntuaciones[0] = (porcentajeGrasa * 0.145) - 0.5;

        // --- 2. MESOMORFIA ---
        double alturaEnMetros = altura / 100;
        puntuaciones[1] = (0.85 * (peso / altura)) + 4.0;

        // --- 3. ECTOMORFIA ---
        // Se usa el Índice Ponderal (HWR)
        double hwr = altura / Math.pow(peso, 1.0/3.0);

        if (hwr >= 40.75) {
            puntuaciones[2] = (0.732 * hwr) - 28.58;
        } else if (hwr > 38.25) {
            puntuaciones[2] = (0.463 * hwr) - 17.63;
        } else {
            puntuaciones[2] = 0.1; // Valor mínimo
        }

        for (int i = 0; i < 3; i++) {
            puntuaciones[i] = Math.round(puntuaciones[i] * 10.0) / 10.0;
        }

        return puntuaciones;
    }

    @Override
    public String determinarCategoriaSomatotipo(double[] puntuaciones) {
        double endo = puntuaciones[0];
        double meso = puntuaciones[1];
        double ecto = puntuaciones[2];

        // Lógica para determinar el componente dominante
        if (endo > meso && endo > ecto) {
            return "ENDOMORFO";
        } else if (meso > endo && meso > ecto) {
            return "MESOMORFO";
        } else {
            return "ECTOMORFO";
        }
    }
}