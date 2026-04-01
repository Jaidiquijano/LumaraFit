package LumaraFit.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "usuarios")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Field(name ="email")
    private String email;
    private String password;
    private String schoolGrade; // Para "Curso"
    private String role; // STUDENT, ADMIN
    private LocalDateTime createdAt;
}
