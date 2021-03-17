package my.project.address;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("https://angular-clients-of-the-bank.herokuapp.com/")
@RestController
@RequestMapping("address")
public class AddressController {
    private AddressRepository addressRepository;
    private ClientRepository clientRepository;


    public AddressController(AddressRepository addressRepository, ClientRepository clientRepository) {
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
    }
    @GetMapping("{id}")
    public Address getById(@PathVariable long id){
        return addressRepository.findById(id).orElse(null);
    }
    @PostMapping("{clientId}")
    public Address addAddressToClient(@Validated @RequestBody Address address, @PathVariable long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        List<Address> addressList = client.getAddresses();
        addressList.add(address);
        clientRepository.save(client);
        return address;
    }


    @PostMapping
    public Address addAddress(@Validated @RequestBody Address address) {
        return addressRepository.save(address);

    }


    @PutMapping("addressToChange/{id}")
    public void edit(@Validated @RequestBody Address address, @PathVariable long id) {
        addressRepository.save(address);
    }

    @DeleteMapping("{addressId}/{clientId}")
    public void deleteClientAddress (@PathVariable long addressId, @PathVariable long clientId){
        Client client = clientRepository.findById(clientId).get();
        Address addressToRemove = client.getAddresses().stream().filter(address -> address.getId() == addressId).findFirst().get();
        client.getAddresses().remove(addressToRemove);
        clientRepository.save(client);

    }


}
