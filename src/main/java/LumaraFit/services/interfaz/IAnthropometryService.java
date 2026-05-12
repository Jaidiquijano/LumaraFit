package LumaraFit.services.interfaz;

import LumaraFit.models.PerfilFisico;

public interface IAnthropometryService {
    // Procesa las medidas y devuelve el perfil con el somatotipo asignado
    PerfilFisico processAssessment(PerfilFisico profile);

    // Calcula los puntos específicos de la fórmula Heath-Carter
    double[] calculateHeathCarterScores(double weight, double height, double fatPercentage);

    // Determina la categoría final (ECTOMORPH, etc.)
    String determineSomatotypeCategory(double[] scores);
}
