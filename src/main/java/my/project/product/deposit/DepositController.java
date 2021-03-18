package my.project.product.deposit;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("https://localhost:4200/")
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
}
