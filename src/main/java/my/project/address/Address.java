package my.project.address;

import org.springframework.context.MessageSource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String street;
    @NotEmpty
    @Size(max = 3)
    private String streetNumber;
    @Size(max = 4)
    private String flatNumber;
    @NotEmpty
    private String city;
    @NotEmpty
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$" ,message = "niepoprawny format")
    private String zip;



    public void setId(Long id) {
        this.id = id;
    }


    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }
}

