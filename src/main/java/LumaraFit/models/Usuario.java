package LumaraFit.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String curso;
    private String rol;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
