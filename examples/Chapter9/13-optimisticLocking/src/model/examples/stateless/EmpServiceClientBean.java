package examples.stateless;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import examples.model.ChangeCollisionException;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EmpServiceClientBean implements EmpServiceClient {
    @EJB protected EmployeeService empSvc;

    public void adjustVacation(int id, int days) {
        try { 
            empSvc.deductEmployeeVacation(id, days);
        } catch (ChangeCollisionException ccEx) {
            System.out.println("Collision with other change - Retrying..."); 
            empSvc.deductEmployeeVacation(id, days);
        }
    }

    public void adjustVacationOptLock(int id, int days) {
        try { 
            empSvc.deductEmployeeVacationOptLock(id, days);
        } catch (ChangeCollisionException ccEx) {
            System.out.println("Collision with other change - Retrying..."); 
            empSvc.deductEmployeeVacation(id, days);
        }
    }

}