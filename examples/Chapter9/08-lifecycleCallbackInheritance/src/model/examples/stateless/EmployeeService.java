package examples.stateless;

import java.util.Collection;

import examples.model.Employee;
import examples.model.EmployeeType;

public interface EmployeeService {
    public Employee createEmployee(int id, String name, EmployeeType type);
    public void removeEmployee(int id);
    public Employee changeEmployeeName(int id, String newName);
    public Collection<Employee> findAllEmployees();
}
