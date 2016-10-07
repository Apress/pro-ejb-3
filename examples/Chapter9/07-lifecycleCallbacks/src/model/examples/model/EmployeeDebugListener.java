package examples.model;

import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EmployeeDebugListener {
    @PrePersist
    public void prePersist(Employee emp) {
        System.out.println("EmployeeDebugListener.Persist called on employee id: " + emp.getId());
    }

    @PreUpdate
    public void preUpdate(Employee emp) {
        System.out.println("EmployeeDebugListener.Update called on employee id: " + emp.getId());
}

    @PreRemove
    public void preRemove(Employee emp) {
        System.out.println("EmployeeDebugListener.Remove called on employee id: " + emp.getId());
}

    @PostLoad
    public void postLoad(Employee emp) {
        System.out.println("EmployeeDebugListener.Load called on employee id: " + emp.getId());
}
}

