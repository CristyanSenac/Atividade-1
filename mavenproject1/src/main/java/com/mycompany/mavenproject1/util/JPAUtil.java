package com.mycompany.mavenproject1.util;

  import jakarta.persistence.EntityManager;
  import jakarta.persistence.EntityManagerFactory;
  import jakarta.persistence.Persistence;

  /**
 *
 * @author Cristyan
 * Classe para códigos úteis
 * Utilizada para realizar a conexão com o banco de dados usando JPA
 */
  public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "atividade3";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    public static EntityManager getEntityManager(){
            if(fabrica == null || !fabrica.isOpen())
                fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            if(em == null || !em.isOpen()) //cria se em nulo ou se o entity manager foi fechado
                em = fabrica.createEntityManager();

            return em;
    }
    
    public static void closeEtityManager(){
            if(em.isOpen() && em != null){
                em.close();
                fabrica.close();
            }
  }
  }      
