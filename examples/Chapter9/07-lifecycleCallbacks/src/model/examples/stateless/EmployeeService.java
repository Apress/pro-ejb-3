package examples.stateless;

import java.util.Collection;

import examples.model.Employee;

public interface EmployeeService {
    public Employee createEmployee(int id, String name);
    public void removeEmployee(int id);
    public Employee changeEmployeeName(int id, String newName);
    public Collection<Employee> findAllEmployees();
}
