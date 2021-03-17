package my.project.product.loan;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class LoanController {
    private LoanRepository loanRepository;
    private ClientRepository clientRepository;

    public LoanController(LoanRepository loanRepository, ClientRepository clientRepository) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
    }
    @GetMapping("loans/{clientId}")
    public List<Loan> getAllForClient (@PathVariable long clientId){
        Client client = clientRepository.findById(clientId).get();
        return client.getLoans();
    }
}
