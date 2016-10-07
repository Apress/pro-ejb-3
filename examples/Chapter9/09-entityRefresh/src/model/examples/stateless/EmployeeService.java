package examples.stateless;

import java.util.Collection;

import examples.model.Employee;

public interface EmployeeService {
    public void loadEmployee(int id);
    public Employee getEmployee();
    public void deductEmployeeVacation(int days);
    public void adjustEmployeeSalary(long salary);
    public void finished();
    public Collection<Employee> findAllEmployees();
}
