package LumaraFit.services.impl;

import LumaraFit.models.PhysicalProfile;
import LumaraFit.services.interfaz.IAnthropometryService;
import org.springframework.stereotype.Service;

@Service
public class AnthropometryServiceImpl implements IAnthropometryService {


    @Override
    public PhysicalProfile processAssessment(PhysicalProfile profile) {
        // 1. Calculamos los 3 componentes (Heath-Carter)
        double[] scores = calculateHeathCarterScores(
                profile.getWeight(),
                profile.getHeight(),
                profile.getBodyFatPercentage()
        );

        // 2. Guardamos las puntuaciones en el objeto
        profile.setCarterScore(scores);

        // 3. Determinamos la categoría principal
        String category = determineSomatotypeCategory(scores);
        profile.setSomatotype(category);

        return profile;
    }

    @Override
    public double[] calculateHeathCarterScores(double weight, double height, double fatPercentage) {
        // [0] Endomorfia, [1] Mesomorfia, [2] Ectomorfia
        double[] scores = new double[3];

        // --- 1. ENDOMORFIA (Basado simplificadamente en grasa corporal) ---
        // Fórmula promediada: (Grasa * 0.145) - 0.5
        scores[0] = (fatPercentage * 0.145) - 0.5;

        // --- 2. MESOMORFIA (Robustez músculo-esquelética) ---
        // Relación altura/peso corregida
        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);
        scores[1] = (0.85 * (weight / height)) + 4.0; // Simplificación para el TFG

        // --- 3. ECTOMORFIA (Linealidad) ---
        // Se usa el Índice Ponderal (HWR: Height / cube root of weight)
        double hwr = height / Math.pow(weight, 1.0/3.0);

        if (hwr >= 40.75) {
            scores[2] = (0.732 * hwr) - 28.58;
        } else if (hwr > 38.25) {
            scores[2] = (0.463 * hwr) - 17.63;
        } else {
            scores[2] = 0.1; // Valor mínimo
        }

        // Redondear a 1 decimal para limpieza
        for (int i = 0; i < 3; i++) {
            scores[i] = Math.round(scores[i] * 10.0) / 10.0;
        }

        return scores;
    }

    @Override
    public String determineSomatotypeCategory(double[] scores) {
        double endo = scores[0];
        double meso = scores[1];
        double ecto = scores[2];

        // El componente más alto define la categoría predominante
        if (meso >= endo && meso >= ecto) {
            return "MESOMORPH";
        } else if (endo >= meso && endo >= ecto) {
            return "ENDOMORPH";
        } else {
            return "ECTOMORPH";
        }
    }
}