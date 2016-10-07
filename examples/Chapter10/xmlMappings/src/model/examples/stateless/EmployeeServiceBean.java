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

    public Collection<Employee> findAllEmployees() {
        Query query = em.createNamedQuery("Employee.findAll");
        return (Collection<Employee>) query.getResultList();
    }
}
