package lk.ijse.dep12.jpa.relationship.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private final static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dep-12");
        return emf;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
