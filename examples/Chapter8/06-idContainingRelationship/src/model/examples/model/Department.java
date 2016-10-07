package examples.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy="department")
    private Collection<Project> projects;

    public Department() {
        projects = new ArrayList<Project>();
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
    
    public Collection<Project> getProjects() {
        return projects;
    }

    public String toString() {
        return "Department id: " + getId() + 
               ", name: " + getName();
    }
}
