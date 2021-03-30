package my.project.product.account;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("http://localhost:4200")
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

    @PostMapping("account/new-account/{clientId}")
    public void addNewAccount(@RequestBody Account account, @PathVariable long clientId){
        accountRepository.save(account);
        Client client = clientRepository.findById(clientId).get();
        client.getAccounts().add(account);
        clientRepository.save(client);
    }
}
