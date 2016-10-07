package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.Department;
import examples.model.Project;

@Stateless
public class ProjectServiceBean implements ProjectService {
    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;

    public Project createProject(String name, int deptId) {
        Project proj = new Project(findDepartment(deptId));
        proj.setName(name);
        em.persist(proj);
        
        return proj;
    }

    public Department findDepartment(int id) {
        return em.find(Department.class, id);
    }
    
    public Collection<Project> findAllProjects() {
        Query query = em.createQuery("SELECT p FROM Project p");
        return (Collection<Project>) query.getResultList();
    }
    
    public Collection<Department> findAllDepartments() {
        Query query = em.createQuery("SELECT d FROM Department d");
        return (Collection<Department>) query.getResultList();
    }
}
