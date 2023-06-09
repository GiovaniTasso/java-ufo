package teste.exemplo.datosdeportivosapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.exemplo.datosdeportivosapi.model.dto.ClienteDTO;
import teste.exemplo.datosdeportivosapi.model.entity.ClienteLogin;
import teste.exemplo.datosdeportivosapi.model.entity.Pin;
import teste.exemplo.datosdeportivosapi.model.form.ClienteForm;
import teste.exemplo.datosdeportivosapi.model.form.PinForm;
import teste.exemplo.datosdeportivosapi.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ClienteDTO salvar(@RequestBody @Valid ClienteForm clienteForm) {
        return clienteService.createCliente(clienteForm);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ClienteDTO> list() {
        return clienteService.findAllCliente();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/pin")
    public Pin salvarPin(@RequestBody PinForm pinForm){
        return clienteService.createPin(pinForm);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/pins")
    public List<Pin> listarPins(){
        return clienteService.findAllPins();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/pins/{id}")
    public Optional<Pin> listarPinbyId(@PathVariable("id")Long id){
        return clienteService.findPinById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClienteLogin clienteLogin) {
        String email = clienteLogin.getEmail();
        String senha = clienteLogin.getSenha();
        System.out.println(clienteLogin);
        if (clienteService.autenticar(email, senha)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable("id") Long id) {
        return clienteService.findClienteById(id);
    }
}


