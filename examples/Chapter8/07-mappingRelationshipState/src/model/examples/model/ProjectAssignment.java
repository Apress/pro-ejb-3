package examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMP_PROJECT")
@IdClass(ProjectAssignmentId.class)
public class ProjectAssignment {
    @Id
    @Column(name="EMP_ID", insertable=false, updatable=false)
    private int empId;
    @Id
    @Column(name="PROJECT_ID", insertable=false, updatable=false)
    private int projectId;

    @ManyToOne
    @JoinColumn(name="EMP_ID")
    Employee employee;
    @ManyToOne
    @JoinColumn(name="PROJECT_ID")
    Project project;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", updatable=false)
    private Date startDate;

    public ProjectAssignment() {}
    public ProjectAssignment(Employee emp, Project proj) {
        this.empId = emp.getId();
        this.employee = emp;
        this.projectId = proj.getId();
        this.project = proj;
    }
    
    public int getEmpId() {
        return empId;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public int getProjectId() {
        return projectId;
    }
    
    public Project getProject() {
        return project;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

