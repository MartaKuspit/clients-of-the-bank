package my.project.client;

import my.project.address.Address;
import my.project.address.AddressRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("client")
public class ClientController {
    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/clients-list")
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping("find-client/find-client-byId/{id}")
    public Client getById(@PathVariable Long id) {
       return clientRepository.findById(id).orElse(null);
    }

    @GetMapping("find-client/find-client-byPesel/{pesel}")
    public Client getById(@PathVariable String pesel) {
        return clientRepository.findByPesel(pesel);
    }

    @PostMapping("/client-create")
    public Client create(@Validated @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("find-client/find-client-byId/{id}")
    public void delete(@PathVariable long id) {
        clientRepository.deleteById(id);
    }

    @PutMapping("/edit-client/{id}")
    public void edit(@RequestBody Client client, @PathVariable long id) {

        Client oldclient = clientRepository.findById(id).get();
        oldclient.setId(oldclient.getId());
        oldclient.setFirstName(client.getFirstName());
        oldclient.setLastName(client.getLastName());
        oldclient.setPesel(client.getPesel());
        clientRepository.save(oldclient);
    }


}
