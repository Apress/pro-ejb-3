package examples.stateless;

import java.util.List;

public interface OrgStructure {
    public List findAllEmployees();
    public List findEmployeeWithAddress();
    public List findEmployeeWithAddressColumnAlias();
    public List findEmployeeWithManager();
    public List findDepartmentSummary();
}
