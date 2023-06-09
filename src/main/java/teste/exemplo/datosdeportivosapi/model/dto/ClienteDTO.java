package teste.exemplo.datosdeportivosapi.model.dto;

import jakarta.persistence.Id;
import teste.exemplo.datosdeportivosapi.model.entity.Cliente;

import lombok.Data;

@Data
public class ClienteDTO {

    @Id
    private Long id;
    private String nome;
    private String senha;
    private String email;


    public ClienteDTO(){

    }
    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.senha = cliente.getSenha();
        this.email = cliente.getEmail();

    }
}
