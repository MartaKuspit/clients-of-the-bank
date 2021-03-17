package my.project.product.mortgage;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("https://angular-clients-of-the-bank.herokuapp.com/")
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
}
