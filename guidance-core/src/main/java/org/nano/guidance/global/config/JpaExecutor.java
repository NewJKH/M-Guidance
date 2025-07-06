package org.nano.guidance.global.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.function.Function;

public class JpaExecutor {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("persistence-unit");

    public static void execute(TransactionLogic logic) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic.run(em);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Transaction failed", e);
        } finally {
            em.close();
        }
    }

    public static void shutdown() {
        emf.close();
    }

    public interface TransactionLogic {
        void run(EntityManager em);
    }

    public static <T> T query(Function<EntityManager, T> logic) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            T result = logic.apply(em);
            tx.commit();
            return result;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Query failed", e);
        } finally {
            em.close();
        }
    }
}
