package LumaraFit.models;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "physicalProfile")
public class PhysicalProfile {
    @Id
    private String id;
    private String userId;

    // Antropometría (Anthropometry)
    private double weight;
    private double height;
    private double bodyFatPercentage;
    private double armCircumference;
    private double waistCircumference;

    // Somatotype Result
    private String somatotype; // ECTOMORPH, MESOMORPH, ENDOMORPH
    private double[] carterScore;

    private LocalDateTime assessmentDate;
}
