package LumaraFit.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "ejercicios")
public class Ejercicio {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String grupoMuscular;
    private String videoUrl;
    private String nivelDificultad;
}
