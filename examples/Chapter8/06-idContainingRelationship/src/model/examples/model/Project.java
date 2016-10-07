package examples.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@IdClass(ProjectId.class)
public class Project {
    @Id
    @Column(name="DEPT_ID", insertable=false, updatable=false)
    private int deptId;
    @Id private String name;

    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    private Department department;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Date endDate;

    public Project() {}
    public Project(Department dept) {
        this.department = dept;
        this.deptId = dept.getId();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String projectName) {
        this.name = projectName;
    }
    
    public int getDeptId() {
        return deptId;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public String toString() {
        return "Project name: " + getName();
    }
}
