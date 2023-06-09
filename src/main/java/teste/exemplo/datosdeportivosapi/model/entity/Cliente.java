package teste.exemplo.datosdeportivosapi.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Table(name = "cliente")
@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;


    }

