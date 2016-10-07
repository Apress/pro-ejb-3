package examples.model;

import java.io.Serializable;

public class ProjectId implements Serializable {
    private int deptId;
    private String name;

    public ProjectId() {}
    public ProjectId(int deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return deptId;
    }

    public boolean equals(Object o) {
        return ((o instanceof ProjectId) && 
                name.equals(((ProjectId) o).getName()) && 
                deptId == ((ProjectId) o).getId());

    }

    public int hashCode() {
        return name.hashCode() + deptId;
    }
}