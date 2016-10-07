package examples.stateless;

import java.util.Collection;

import examples.model.Employee;
import examples.model.Project;

public interface EmployeeService {
    public Employee createEmployee(String country, int id, 
                                   String name, long salary);
    public void setEmployeeManager(String country, int id, String mgrCountry, int mgrId);
    public void addEmployeeProject(String country, int id, int projId);
    public Collection<Employee> findAllEmployees();
    public Collection<Project> findAllProjects();
}
