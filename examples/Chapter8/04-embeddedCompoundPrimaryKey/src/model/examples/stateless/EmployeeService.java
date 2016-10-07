package examples.stateless;

import java.util.Collection;

import examples.model.Employee;

public interface EmployeeService {
    public Employee createEmployee(String country, int id, 
                                   String name, long salary);
    public Employee findEmployee(String country, int id);
    public Collection<Employee> findAllEmployees();
}
