package examples.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Department {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy="department")
    @MapKey(name="name")
    private Map<String, Employee> employees;

    public Department() {
        employees = new HashMap<String, Employee>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String deptName) {
        this.name = deptName;
    }
    
    public void addEmployee(Employee employee) {
        if (!getEmployees().containsKey(employee.getName())) {
            getEmployees().put(employee.getName(), employee);
            if (employee.getDepartment() != null) {
                employee.getDepartment().getEmployees().remove(employee.getName());
            }
            employee.setDepartment(this);
        }
    }
    
    public Map<String,Employee> getEmployees() {
        return employees;
    }

    public String toString() {
        return "Department id: " + getId() + 
               ", name: " + getName();
    }
}
