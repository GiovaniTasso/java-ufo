package teste.exemplo.datosdeportivosapi.service;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String mensagem) {
        super(mensagem);

    }
}
