package LumaraFit.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "exercise")
public class Exercise {
    @Id
    private String id;
    private String name;
    private String description;
    private String muscleGroup;
    private String videoUrl;
    private String difficultyLevel;
}
