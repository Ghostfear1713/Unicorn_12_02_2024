package Package_Exercise.dao;

import Package_Exercise.config.HibernateConfig;
import Package_Exercise.model.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class LocationDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Location createLocation(Location location){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
        em.close();

        System.out.println("Your location " + location + "has now been added to the Database");
        return location;
    }

    public void deleteLocation(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Location location = em.find(Location.class, id);
        em.remove(location);
        em.getTransaction().commit();
        em.close();
    }

    public Location updateLocation(Location location) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Location updatedLocation = em.merge(location);
        em.getTransaction().commit();
        em.close();

        System.out.println("Your location " + location + "has now been updated in the Database");
        return updatedLocation;
    }

    public Location findLocation(int id) {
        EntityManager em = emf.createEntityManager();
        Location location = em.find(Location.class, id);
        em.close();

        return location;
    }

    public void getAllLocations() {
        EntityManager em = emf.createEntityManager();
        em.createQuery("SELECT l FROM Location l", Location.class).getResultList().forEach(System.out::println);
    }















}
