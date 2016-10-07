package examples.model;

import java.util.ResourceBundle;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    private long salary;
    transient private String translatedName;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String toString() {
        if (translatedName == null) {
            translatedName = 
                ResourceBundle.getBundle("EmpResources").getString("Employee");
        }
        return translatedName + " id: " + getId() + " name: " + getName() + " salary: " + getSalary();
    }
}
