package br.com.tardeli.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public final class EntityManagerProvider {
    private static final EntityManagerProvider INSTANCE = new EntityManagerProvider();
    
    private final EntityManagerFactory factory;

    private EntityManagerProvider() {
        this.factory = Persistence.createEntityManagerFactory("atividade");
    }
    
      public static EntityManagerProvider getInstance() {
        return INSTANCE;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager createManager() {
        return factory.createEntityManager();
    }
    
}
