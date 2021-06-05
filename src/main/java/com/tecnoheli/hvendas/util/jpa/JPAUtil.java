package com.tecnoheli.hvendas.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("HVENDAS_PU");
    }

    public static EntityManager abreConexao() {
        return factory.createEntityManager();
    }

    public static void fechaFabricaDeConexao() {
        factory.close();
    }
}
