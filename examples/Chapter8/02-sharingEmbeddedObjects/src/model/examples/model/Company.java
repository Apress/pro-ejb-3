package examples.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
    @Id private String name;
    @Embedded
    private Address address;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address; 
    }

    public String toString() {
        return "Company name: " + getName() +
               " at " + getAddress();
    }
}
