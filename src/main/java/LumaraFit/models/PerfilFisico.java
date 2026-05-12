package LumaraFit.models;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "perfilesFisicos")
public class PerfilFisico {
    @Id
    private String id;
    private String usuarioId;

    // Antropometría
    private double peso;
    private double altura;
    private double porcentajeGrasaCorporal;
    private double circunferenciaBrazo;
    private double circunferenciaCintura;

    private String somatotipo; // ECTOMORFO, MESOMORFO, ENDOMORFO
    private double[] puntuacionCarter;
    private LocalDateTime fechaEvaluacion = LocalDateTime.now();
}
