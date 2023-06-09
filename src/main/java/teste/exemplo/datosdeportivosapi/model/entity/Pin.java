package teste.exemplo.datosdeportivosapi.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "pins")
@Entity(name = "pins")
@NoArgsConstructor
@AllArgsConstructor
public class Pin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longitude;

    private String latitude;

    private String description;

}
