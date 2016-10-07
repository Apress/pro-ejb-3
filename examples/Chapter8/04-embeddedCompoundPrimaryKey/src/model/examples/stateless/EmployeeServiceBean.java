package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.Employee;

@Stateless
public class EmployeeServiceBean implements EmployeeService {
    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;

    public Employee createEmployee(String country, int id, 
                                   String name, long salary) {
        Employee emp = new Employee(country, id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        
        return emp;
    }

    public Employee findEmployee(String country, int id) {
        return (Employee)
            em.createQuery("SELECT e " + 
                           "FROM Employee e " +
                           "WHERE e.id.country = ?1 AND e.id.id = ?2")
              .setParameter(1, country)
              .setParameter(2, id)
              .getSingleResult();
    }


    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (Collection<Employee>) query.getResultList();
    }
}
