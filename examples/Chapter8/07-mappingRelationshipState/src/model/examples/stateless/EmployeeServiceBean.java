package examples.stateless;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.Employee;
import examples.model.Project;
import examples.model.ProjectAssignment;

@Stateless
public class EmployeeServiceBean implements EmployeeService {
    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;

    public Employee createEmployee(String country, int id, 
            String name, long salary) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        
        return emp;
    }

    public void addEmployeeProject(int id, int projId) {
        Employee emp = findEmployee(id);
        Project proj = em.find(Project.class, projId);
        ProjectAssignment assign = new ProjectAssignment(emp, proj);
        assign.setStartDate(new Date());
        em.persist(assign);
        emp.getAssignments().add(assign);
        proj.getAssignments().add(assign);
    }

    public Employee findEmployee(int id) {
        return em.find(Employee.class, id);
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
