package my.project.product.account;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin("https://angular-clients-of-the-bank.herokuapp.com/")
@RestController
public class AccountController {
    private AccountRepository accountRepository;
    private ClientRepository clientRepository;

    public AccountController(AccountRepository accountRepository, ClientRepository clientRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
    }
    @GetMapping("accounts/{clientId}")
    public List<Account> getAllforClient(@PathVariable long clientId) {
        Client client = clientRepository.findById(clientId).get();
        return client.getAccounts();
    }
    @GetMapping("accounts")
    public List<Account> getAll(){
        return accountRepository.findAll();
    }
}
