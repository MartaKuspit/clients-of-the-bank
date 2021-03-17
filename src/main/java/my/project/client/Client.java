package my.project.client;

import my.project.address.Address;
import my.project.product.account.Account;
import my.project.product.deposit.Deposit;
import my.project.product.loan.Loan;
import my.project.product.mortgage.Mortgage;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @Pattern(regexp = "^[0-9]{11}$", message = "pesel musi składać sie z 11 cyfr")
    @NotEmpty
    @ClientPeselValidator
    private String pesel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> accounts;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Deposit> deposits;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Loan> loans;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Mortgage> mortgages;


    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getPesel() {
        return pesel;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public List<Mortgage> getMortgages() {
        return mortgages;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void setMortgages(List<Mortgage> mortgages) {
        this.mortgages = mortgages;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
