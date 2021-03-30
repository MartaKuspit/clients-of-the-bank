package my.project.product.mortgage;

import my.project.client.Client;
import my.project.client.ClientRepository;
import my.project.product.loan.Loan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class MortgageController {
    private MortgageRepository mortgageRepository;
    private ClientRepository clientRepository;

    public MortgageController(MortgageRepository mortgageRepository, ClientRepository clientRepository) {
        this.mortgageRepository = mortgageRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("mortgages/{clientId}")
    public List<Mortgage> getAllForClient (@PathVariable long clientId){
        Client client = clientRepository.findById(clientId).get();
        return client.getMortgages();
    }
    @PostMapping("mortgage/new-mortgage/{clientId}")
    public void addNewAccount(@RequestBody Mortgage mortgage, @PathVariable long clientId){
        mortgageRepository.save(mortgage);
        Client client = clientRepository.findById(clientId).get();
        client.getMortgages().add(mortgage);
        clientRepository.save(client);
    }
}
