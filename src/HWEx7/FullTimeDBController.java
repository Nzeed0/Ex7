package HWEx7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FullTimeDBController {
    
    public static void insertFulltimeEmployee(FulltimeEmployee FtEm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(FtEm);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateFulltimeEmployee(FulltimeEmployee FtEm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, FtEm.getId());
        fromDb.setName(FtEm.getName());
        fromDb.setSalary(FtEm.getSalary());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static FulltimeEmployee findFulltimeEmployeeById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee FtEm = em.find(FulltimeEmployee.class, id);
        em.close();
        return FtEm;
    }
    
    public static void removeFulltimeEmployee(FulltimeEmployee FtEm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, FtEm.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
}
