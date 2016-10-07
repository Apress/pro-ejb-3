package examples.stateless;

import java.util.Collection;
import java.util.List;

import examples.model.Employee;
import examples.model.SalaryReport;

public interface EmployeeService {
    public SalaryReport generateDepartmentsSalaryReport(List<Integer> deptIds);
    public void changeEmployeeDepartment(int deptId, int empId);
    public Collection<Employee> findAllEmployees();
}
