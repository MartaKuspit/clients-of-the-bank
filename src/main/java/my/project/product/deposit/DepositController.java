package my.project.product.deposit;

import my.project.client.Client;
import my.project.client.ClientRepository;
import my.project.product.account.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class DepositController {
    private DepositRepository depositRepository;
    private ClientRepository clientRepository;

    public DepositController(DepositRepository depositRepository, ClientRepository clientRepository) {
        this.depositRepository = depositRepository;
        this.clientRepository = clientRepository;
    }
    @GetMapping("deposits/{clientId}")
    public List<Deposit> getAllforClient (@PathVariable long clientId){
        Client client = clientRepository.findById(clientId).get();
        return client.getDeposits();
    }
    @PostMapping("deposit/new-deposit/{clientId}")
    public void addNewAccount(@RequestBody Deposit deposit, @PathVariable long clientId){
        depositRepository.save(deposit);
        Client client = clientRepository.findById(clientId).get();
        client.getDeposits().add(deposit);
        clientRepository.save(client);
    }
}
