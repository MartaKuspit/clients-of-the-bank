package my.project.seeking;

import my.project.client.Client;
import my.project.client.ClientRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
public class SeekingController {

    private ClientRepository clientRepository;
    public SeekingController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("seeking/{seekword}")
    public List<Client> getAll(@PathVariable String seekword){
        List<Client> clientList = clientRepository.findAll();
        if (seekword.contains("kon")){
            List<Client> clientListWithAccounts = clientList.stream()
                    .filter(client -> client.getAccounts().size() != 0).collect(Collectors.toList());
            return clientListWithAccounts;
        }
        else if (seekword.contains("dep") || seekword.contains("lok")){
            List<Client> clientListWithDeposits = clientList.stream()
                    .filter(client -> client.getDeposits().size() != 0).collect(Collectors.toList());
            return clientListWithDeposits;
        }
        else if (seekword.contains("poz") || seekword.contains("poż") || seekword.contains("kre")){
            List<Client> clientListWithLoans = clientList.stream()
                    .filter(client -> client.getLoans().size() != 0)
                    .collect(Collectors.toList());
            return clientListWithLoans;
        }
        else if (seekword.contains("hip")){
            List<Client> clientListWithMortgages = clientList.stream()
                    .filter(client -> client.getMortgages().size() != 0).collect(Collectors.toList());
            return clientListWithMortgages;
        }else
            return null;


    }
}
