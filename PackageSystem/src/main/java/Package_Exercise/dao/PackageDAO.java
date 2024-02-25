package Package_Exercise.dao;

import Package_Exercise.config.HibernateConfig;
import Package_Exercise.model.Package;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PackageDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Package createPackage(Package p){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        System.out.println("Your package " + p + "has now been added to the Database");
        return p;
    }

    public void deletePackage(int id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Package p = em.find(Package.class, id);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        System.out.println("Your package " + p + "has now been removed from the Database");
    }

    public Package updatePackage(Package p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Package updatedPackage = em.merge(p);
        em.getTransaction().commit();
        em.close();
        System.out.println("Your package " + p + "has now been updated in the Database");
        return updatedPackage;
    }

    public Package findPackage(int id){
        EntityManager em = emf.createEntityManager();
        Package p = em.find(Package.class, id);
        em.close();
        return p;
    }

    public void getAllPackages() {
        EntityManager em = emf.createEntityManager();
        em.createQuery("SELECT p FROM Package p", Package.class).getResultList().forEach(System.out::println);
    }

    public Package findByTrackingNumber(String trackingNumber){
        EntityManager em = emf.createEntityManager();
        // SELECT p FROM Package p WHERE p.trackingNumber = :trackingNumber is the JPQL query that is being used here to find the package by tracking number
        // The :trackingNumber is a placeholder for the actual tracking number we want to find.
        Package p = em.createQuery("SELECT p FROM Package p WHERE p.trackingNumber = :trackingNummer", Package.class)
                //:trackingNummer = Is the same as a parameter (a placeholder) This is being set to be the trackingNumber in our method parameter
                .setParameter("trackingNummer", trackingNumber)
                .getSingleResult();
        em.close();
        return p;
    }


















}
