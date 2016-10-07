package examples.stateful;

import examples.model.Employee;

public interface EmployeeEdit {
    public void begin(int id);
    public Employee getEmployee();
    public Employee revertEmployee();
    public void save();
    public void cancel();
}
