package examples.stateless;

import examples.model.Uniform;

public interface EmployeeManagement {
    public Uniform getUniform(int id);
    public void addUniform(int id, Uniform uniform);
}
