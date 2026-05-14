package LumaraFit.services.interfaz;

import LumaraFit.models.PerfilFisico;

public interface IAntropometriaService {

    PerfilFisico procesarEvaluacion(PerfilFisico perfil);
    double[] calcularPuntuacionesHeathCarter(double peso, double altura, double porcentajeGrasa);
    String determinarCategoriaSomatotipo(double[] puntuaciones);}
