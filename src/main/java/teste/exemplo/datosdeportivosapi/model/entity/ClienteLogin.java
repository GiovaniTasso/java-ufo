package teste.exemplo.datosdeportivosapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteLogin {

    private String email;
    private String senha;

}
