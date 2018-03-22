package kdg.superteam.userservice.dom;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class ExtraGebruiker extends Account implements Serializable{
    private Address facturationAddress;
    private String VAT;
    private String company;

    public ExtraGebruiker(String name, String firstName, String email, String avatar, Address address, Address facturationAddress, String VAT, String company) {
        super(name, firstName, email, avatar, address);
        this.facturationAddress = facturationAddress;
        this.VAT = VAT;
        this.company = company;
    }

    public Address getFacturationAddress() {
        return facturationAddress;
    }

    public void setFacturationAddress(Address facturationAddress) {
        this.facturationAddress = facturationAddress;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
