package examples.model;

import java.util.Date;
import java.util.Collection;

public abstract class Employee {
    private int id;
    private String name;
    private Date startDate;
    private Address address;
    private ParkingSpace parkingSpace;
    private Employee manager;
    private Department department;
    private Collection<Project> projects;
    private Collection<Employee> directs;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public Address getAddress() {
        return address;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public Employee getManager() {
        return manager;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public Collection<Project> getProjects() {
        return projects;
    }
    
    public void addProject(Project project) {
        if (!getProjects().contains(project)) {
            getProjects().add(project);
        }
        if (!project.getEmployees().contains(this)) {
            project.getEmployees().add(this);
        }
    }

    public String toString() {
        return "Employee id: " + getId() + " name: " + getName();
    }
}
