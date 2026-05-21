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
                perfil.getAltura()
        );
        perfil.setPuntuacionCarter(puntuaciones);
        String categoria = determinarCategoriaSomatotipo(puntuaciones);
        perfil.setSomatotipo(categoria);

        return perfil;
    }

    @Override
    public double[] calcularPuntuacionesHeathCarter(double peso, double altura) {
        double[] puntuaciones = new double[3];
        double alturaEnMetros = altura / 100;
        double imc = peso / (alturaEnMetros * alturaEnMetros);
        double hwr = altura / Math.pow(peso, 1.0 / 3.0);


        puntuaciones[0] = 0.0025 * Math.pow(imc, 2.2);
        if (puntuaciones[0] < 0.5) puntuaciones[0] = 0.5;

        puntuaciones[1] = (0.32 * imc) - 2.5;
        if (puntuaciones[1] < 0.5) puntuaciones[1] = 0.5;

        if (hwr >= 40.75) {
            puntuaciones[2] = (0.732 * hwr) - 28.58;
        } else if (hwr > 38.25) {
            puntuaciones[2] = (0.463 * hwr) - 17.63;
        } else {
            puntuaciones[2] = 0.1;
        }

        if (imc >= 28.0 && puntuaciones[0] <= puntuaciones[1]) {
            puntuaciones[0] = puntuaciones[1] + 1.5;
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

        double maximo = Math.max(endo, Math.max(meso, ecto));

        if (maximo == endo) {
            return "ENDOMORFO";
        } else if (maximo == meso) {
            return "MESOMORFO";
        } else {
            return "ECTOMORFO";
        }
    }

}