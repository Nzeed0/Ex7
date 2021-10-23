package HWEx7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PartTimeDBController {
    
    public static void insertParttimeEmployee(ParttimeEmployee ptEm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(ptEm);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateParttimeEmployee(ParttimeEmployee ptEm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        ParttimeEmployee fromDb = em.find(ParttimeEmployee.class, ptEm.getId());
        fromDb.setName(ptEm.getName());
        fromDb.setHoursWork(ptEm.getHoursWork());
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
    
    public static ParttimeEmployee findParttimeEmployee(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        ParttimeEmployee ptEm = em.find(ParttimeEmployee.class, id);
        em.close();
        return ptEm;
    }
    
    public static void removeParttimeEmployee(ParttimeEmployee ptEm) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HWEx7PU");
        EntityManager em = emf.createEntityManager();
        ParttimeEmployee fromDb = em.find(ParttimeEmployee.class, ptEm.getId());
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
