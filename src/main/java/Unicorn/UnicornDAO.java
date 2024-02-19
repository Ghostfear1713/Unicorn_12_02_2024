package Unicorn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UnicornDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    //Creates a Unicorn in our database
    public Unicorn save(Unicorn unicorn){
        //The entitymanagerfactory creates instances of EntityManagers which is used
        //to interact with our database
        EntityManager em = emf.createEntityManager();
        //This allows us to create a database operation and is needed if we want something
        //from the DB
        em.getTransaction().begin();
        em.persist(unicorn);
        em.getTransaction().commit();
        em.close();
        return unicorn;
    }

    public Unicorn update(Unicorn unicorn){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Unicorn updatedUnicorn = em.merge(unicorn);
        em.getTransaction().commit();
        em.close();
        return updatedUnicorn;
    }

    public Unicorn findUnicornById(int id){
        EntityManager em = emf.createEntityManager();
        //The find method is used to search a specifc Unicorn entity in the db with a given ID.
        //We pass the Unicorn.class to specify that it's a Unicorn object we're interested in
        Unicorn foundUnicorn = em.find(Unicorn.class, id);
        em.close();
        return foundUnicorn;
    }

    List<Unicorn> getAllUnicorns(){
        EntityManager em = emf.createEntityManager();
        try{
            //We used TypedQuery to execute a JPQL query and select all Unicorn entities "u" from the DB
            TypedQuery<Unicorn> query = em.createQuery("SELECT u FROM Unicorn u", Unicorn.class);
            //We make a new list that will have all the retrieved unicorns
            List<Unicorn> listOfFoundUnicorns = query.getResultList();
            for(Unicorn u: listOfFoundUnicorns){
                System.out.println(u);
            }
            return listOfFoundUnicorns;
        } //finally block is used in exception handling to execute code
        // that must be run regardless of whether an exception occurs or not.
        //If we don't close it explicitly, it may lead to resource leaks and potential performance issues which we want to prevent.
        finally {
            em.close();
        }
    }

    public void deleteUnicorn(int id){
        EntityManager em = emf.createEntityManager();
        Unicorn unicornToDelete = findUnicornById(id);
        em.getTransaction().begin();
        if(unicornToDelete != null){
            System.out.println("You have deleted unicorn ID " + id + ": \n" + unicornToDelete);
            em.remove(unicornToDelete);
        } else {
            System.out.println("The id you provided doesn't match with the DB - Make sure you have provided a correct ID");
        }
        em.getTransaction().commit();
        em.close();
    }



}
