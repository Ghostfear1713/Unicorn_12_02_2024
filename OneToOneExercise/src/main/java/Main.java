import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try{
            EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
            EntityManager em = emf.createEntityManager();


            Person person = new Person("John");
            PersonDetail personDetail = new PersonDetail("Vejlebrovej 9", "Vejle", 7100, 25);
            person.setPersonDetail(personDetail);
            Fee fee = new Fee(100, LocalDate.of(2024, 1, 12));
            Fee fee2 = new Fee(200, LocalDate.of(2024, 2, 12));

            person.addFee(fee);
            person.addFee(fee2);


            em.getTransaction().begin();
            em.persist(person);
            em.persist(personDetail);
            em.persist(fee);
            em.persist(fee2);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e){
            e.printStackTrace();
        }


    }

}
