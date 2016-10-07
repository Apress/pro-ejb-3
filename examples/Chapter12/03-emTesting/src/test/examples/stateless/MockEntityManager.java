package examples.stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;

public class MockEntityManager implements EntityManager {
    public void persist(Object arg0) {
    }
    
    public <T> T merge(T arg0) {
        return null;
    }

    public void remove(Object arg0) {
    }

    public <T> T find(Class<T> arg0, Object arg1) {
        return null;
    }

    public <T> T getReference(Class<T> arg0, Object arg1) {
        return null;
    }

    public void flush() {
    }

    public void refresh(Object arg0) {
    }

    public boolean contains(Object arg0) {
        return false;
    }

    public Query createQuery(String arg0) {
        return null;
    }

    public Query createNamedQuery(String arg0) {
        return null;
    }

    public Query createNativeQuery(String arg0) {
        return null;
    }

    public Query createNativeQuery(String arg0, Class arg1) {
        return null;
    }

    public Query createNativeQuery(String arg0, String arg1) {
        return null;
    }

    public void close() {
    }

    public boolean isOpen() {
        return false;
    }

    public void lock(Object arg0, LockModeType arg1) {
    }

    public void clear() {
    }

    public Object getDelegate() {
        return null;
    }

    public EntityTransaction getTransaction() {
        return null;
    }

    public FlushModeType getFlushMode() {
        return null;
    }

    public void setFlushMode(FlushModeType arg0) {
    }

    public void joinTransaction() {
    }
}
