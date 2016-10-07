package examples.stateless;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import examples.model.Employee;
import examples.model.Uniform;

@Stateful
public class EmployeeManagementBean implements EmployeeManagement {
    @PersistenceContext(unitName="EmployeeService",
                        type=PersistenceContextType.EXTENDED)
    private EntityManager em;

    public Uniform getUniform(int id) {
        return em.find(Uniform.class, id);
    }

    public void addUniform(int id, Uniform uniform) {
        Employee emp = em.find(Employee.class, id);
        em.lock(emp, LockModeType.WRITE); // comment out to show overwriting of data
        emp.addUniform(uniform);
        uniform.setEmployee(emp);
    }
}
