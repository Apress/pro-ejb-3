package examples.stateless;

import java.util.Collection;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import examples.model.Employee;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class EmployeeServiceBean implements EmployeeService {
    public static final long REFRESH_THRESHOLD = 3000; // changed threshold to force refresh

    @PersistenceContext(unitName="EmployeeService", 
                        type=PersistenceContextType.EXTENDED)
    private EntityManager em;
    private Employee emp;
    private long loadTime;

    public void loadEmployee (int id) {
        emp = em.find(Employee.class, id);
        if (emp == null)
            throw new IllegalArgumentException("Unknown employee id: " + id);
        loadTime = System.currentTimeMillis(); 
    }

    public Employee getEmployee() {
        return emp;
    }

    public void deductEmployeeVacation(int days) {
        refreshEmployeeIfNeeded();
        emp.setVacationDays(emp.getVacationDays() - days);
    }

    public void adjustEmployeeSalary(long salary) {
        refreshEmployeeIfNeeded();
        emp.setSalary(salary);
    }

    @Remove 
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void finished() {}

    private void refreshEmployeeIfNeeded() {
        if ((System.currentTimeMillis() - loadTime) > REFRESH_THRESHOLD) {
            em.refresh(emp);
            loadTime = System.currentTimeMillis(); 
        }
    }
    
    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (Collection<Employee>) query.getResultList();
    }
}

