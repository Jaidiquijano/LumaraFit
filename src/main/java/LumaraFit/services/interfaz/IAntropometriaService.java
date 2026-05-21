package LumaraFit.services.interfaz;

import LumaraFit.models.PerfilFisico;

public interface IAntropometriaService {

    PerfilFisico procesarEvaluacion(PerfilFisico perfil);
    double[] calcularPuntuacionesHeathCarter(double peso, double altura);
    String determinarCategoriaSomatotipo(double[] puntuaciones);}
