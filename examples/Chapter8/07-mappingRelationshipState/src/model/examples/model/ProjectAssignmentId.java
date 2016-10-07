package examples.model;

import java.io.Serializable;

public class ProjectAssignmentId implements Serializable {
    private int empId;
    private int projectId;
    
    public ProjectAssignmentId() {}
    public ProjectAssignmentId(int empId, int projectId) {
      this.empId = empId;
      this.projectId = projectId;
    }
    
    public int getEmpId() {
        return empId;
    }
    
    public int getProjectId() {
        return projectId;
    }
    
    public boolean equals(Object o) { 
        return ((o instanceof ProjectAssignmentId) && 
                empId == ((ProjectAssignmentId)o).getEmpId() &&
                projectId == ((ProjectAssignmentId) o).getProjectId());
    }

    public int hashCode() { 
        return empId + projectId; 
    }
}
