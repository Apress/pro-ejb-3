package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.ChangeCollisionException;
import examples.model.Employee;

@Stateless
public class EmployeeServiceBean implements EmployeeService {
    @PersistenceContext(unitName="EmployeeService")
    private EntityManager em;

    public Employee createEmployee(int id, String name, int vacation) {
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setVacationDays(vacation);
        em.persist(emp);
        return emp;
    }
    
    public void deductEmployeeVacation(int id, int days) {    
        Employee emp = em.find(Employee.class, id);
        emp.setVacationDays(emp.getVacationDays() - days);
        // ... 
        flushChanges();
    }
    
    public void deductEmployeeVacationOptLock(int id, int days) {    
        Employee emp = em.find(Employee.class, id);
        emp.setVersion(emp.getVersion()-1); // force opt lock
        emp.setVacationDays(emp.getVacationDays() - days);
        // ... 
        flushChanges();
    }

    public void adjustEmployeeSalary(int id, long salary) {
        Employee emp = em.find(Employee.class, id);
        emp.setSalary(salary);
        // ... 
        flushChanges();
    }

    protected void flushChanges() {
        try { 
            em.flush(); 
        } catch (OptimisticLockException optLockEx) {
            throw new ChangeCollisionException();
        }
    } 
    
    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (Collection<Employee>) query.getResultList();
    }
}

