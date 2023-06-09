package teste.exemplo.datosdeportivosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.exemplo.datosdeportivosapi.model.dto.ClienteDTO;
import teste.exemplo.datosdeportivosapi.model.entity.Cliente;
import teste.exemplo.datosdeportivosapi.model.entity.ClienteLogin;
import teste.exemplo.datosdeportivosapi.model.entity.Pin;
import teste.exemplo.datosdeportivosapi.model.form.ClienteForm;
import teste.exemplo.datosdeportivosapi.model.form.PinForm;
import teste.exemplo.datosdeportivosapi.repository.ClienteRepository;
import teste.exemplo.datosdeportivosapi.repository.PinRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    PinRepository pinRepository;

    public ClienteDTO createCliente(ClienteForm form) {
        if (clienteRepository.existsByEmail(form.getEmail())) {
            throw new EmailAlreadyExistsException("O email já está cadastrado.");
        }
        Cliente cliente = convertToRequest(form);
        cliente = clienteRepository.save(cliente);
        return convertToResponse(cliente);
    }

    public Pin createPin(PinForm pinForm){
        Pin pin = new Pin();
        pin.setLatitude(pinForm.getLatitude());
        pin.setLongitude(pinForm.getLongitude());
        pin.setDescription(pinForm.getDescription());
        return pinRepository.save(pin);
    }

    public List<ClienteDTO> findAllCliente() {
        List<Cliente> all = clienteRepository.findAll();
        return convertListToResponse(all);

    }

    public ClienteDTO findClienteById(Long id){
        Optional<Cliente> optional = clienteRepository.findById(id);
        return optional.map(this::convertToResponse).orElse(null);
    }

    public Optional<Pin> findPinById(Long id) {
        Optional<Pin> optional = pinRepository.findById(id);
        return optional;
    }

    public List<Pin> findAllPins(){
        List<Pin> pins = pinRepository.GetAllPins();
        return pins;
    }

    public void deleteById(Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }
    }


    private Cliente convertToRequest(ClienteForm form) {
        Cliente cliente = new Cliente();
        cliente.setId(form.getId());
        cliente.setNome(form.getNome());
        cliente.setEmail(form.getEmail());
        cliente.setSenha(form.getSenha());
        return cliente;
    }

    private ClienteDTO convertToResponse(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setSenha(cliente.getSenha());
        return dto;

    }

    private static List<ClienteDTO> convertListToResponse(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }


    private ClienteLogin mapToClienteLogin(Map<String, Object> result) {
        ClienteLogin clienteLogin = new ClienteLogin();
        clienteLogin.setEmail((String) result.get("email"));
        clienteLogin.setSenha((String) result.get("senha"));
        return clienteLogin;
    }

    public boolean autenticar(String email, String senha) {
        Map<String, Object> result = clienteRepository.findByEmail(email);
        ClienteLogin clienteLogin = mapToClienteLogin(result);
        if (clienteLogin != null && clienteLogin.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }



}








