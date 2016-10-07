package examples.stateless;

import java.util.Collection;

import examples.model.Employee;

public interface EmployeeService {
    public Employee createEmployee(int id, String name, int vacation);
    public void deductEmployeeVacation(int id, int days);
    public void deductEmployeeVacationOptLock(int id, int days);
    public void adjustEmployeeSalary(int id, long salary);
    public Collection<Employee> findAllEmployees();
}
