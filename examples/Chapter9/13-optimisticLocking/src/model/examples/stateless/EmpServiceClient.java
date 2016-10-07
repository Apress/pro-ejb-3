package examples.stateless;

public interface EmpServiceClient {
    public void adjustVacation(int id, int days);
    public void adjustVacationOptLock(int id, int days);
}
