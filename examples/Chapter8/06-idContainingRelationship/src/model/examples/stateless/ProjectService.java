package examples.stateless;

import java.util.Collection;

import examples.model.Department;
import examples.model.Project;

public interface ProjectService {
    public Project createProject(String name, int deptId);
    public Collection<Project> findAllProjects();
    public Collection<Department> findAllDepartments();
}
