package kdg.superteam.userservice.dom.dto;

import kdg.superteam.userservice.dom.Address;

public class ExtraGebruikerDTO extends AccountDTO {
    private Address facturationAddress;
    private String VAT;
    private String company;

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
