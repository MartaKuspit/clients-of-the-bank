package my.project.product.loan;

import my.project.client.Client;
import my.project.client.ClientRepository;
import my.project.product.deposit.Deposit;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("loan/new-loan/{clientId}")
    public void addNewAccount(@RequestBody Loan loan, @PathVariable long clientId){
        loanRepository.save(loan);
        Client client = clientRepository.findById(clientId).get();
        client.getLoans().add(loan);
        clientRepository.save(client);
    }
}
