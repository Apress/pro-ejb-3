package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.Employee;
import examples.model.EmployeeId;
import examples.model.Project;

@Stateless
public class EmployeeServiceBean implements EmployeeService {
    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;

    public Employee createEmployee(String country, int id, 
            String name, long salary) {
        Employee emp = new Employee();
        emp.setCountry(country);
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        
        return emp;
    }

    public void setEmployeeManager(String country, int id, String mgrCountry, int mgrId) {
        Employee emp = findEmployee(country, id);
        Employee mgr = findEmployee(mgrCountry, mgrId);
        emp.setManager(mgr);
        mgr.getDirects().add(emp);
    }

    public void addEmployeeProject(String country, int id, int projId) {
        Employee emp = findEmployee(country, id);
        Project proj = em.find(Project.class, projId);
        emp.getProjects().add(proj);
        proj.getEmployees().add(emp);
    }

    public Employee findEmployee(String country, int id) {
        return em.find(Employee.class, new EmployeeId(country, id));
    }

    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (Collection<Employee>) query.getResultList();
    }

    public Collection<Project> findAllProjects() {
        Query query = em.createQuery("SELECT p FROM Project p");
        return (Collection<Project>) query.getResultList();
    }
}
