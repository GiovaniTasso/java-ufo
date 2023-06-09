package teste.exemplo.datosdeportivosapi.model.form;

import lombok.Data;

@Data
public class ClienteForm {
    private Long id;
    private String nome;
    private String email;
    private String senha;


}
