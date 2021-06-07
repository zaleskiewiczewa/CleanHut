package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Cleaning;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository

public class CleaningRepository {


    @PersistenceContext
    EntityManager entityManager;

    public Cleaning saveCleaning(Cleaning cleaning) {
        if (cleaning.getId() == null) {
            entityManager.persist(cleaning);
        } else {
            entityManager.merge(cleaning);
        }
        return cleaning;

    }

    public Cleaning readCleaning(Long id){
        return entityManager.find(Cleaning.class, id);
    }

    public Cleaning updateCleaning (Cleaning cleaning){
        entityManager.merge(cleaning);
        return cleaning;
    }

    public void removeCleaning(Long id) {
        Cleaning cleaning = entityManager.find(Cleaning.class, id);
        entityManager.remove(entityManager.contains(cleaning) ? cleaning : entityManager.merge(cleaning));

    }

    public List<Cleaning> findAll() {
        Query query = entityManager.createQuery("Select t from Cleaning t");
        return query.getResultList();
    }

    public Cleaning findById(Long id) {
        return entityManager.find(Cleaning.class, id);
    }

}


