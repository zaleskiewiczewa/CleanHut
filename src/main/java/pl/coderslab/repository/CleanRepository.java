package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Clean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository

public class CleanRepository {


    @PersistenceContext
    EntityManager entityManager;

    public Clean saveClean(Clean clean) {
        if (clean.getId() == null) {
            entityManager.persist(clean);
        } else {
            entityManager.merge(clean);
        }
        return clean;

    }

    public Clean readClean(Long id){
        return entityManager.find(Clean.class, id);
    }

    public Clean updateClean (Clean clean){
        entityManager.merge(clean);
        return clean;
    }

    public void removeClean(Long id) {
        Clean clean = entityManager.find(Clean.class, id);
        entityManager.remove(entityManager.contains(clean) ? clean : entityManager.merge(clean));

    }

    public List<Clean> findAll() {
        Query query = entityManager.createQuery("Select t from Clean t");
        return query.getResultList();
    }

    public Clean findById(Long id) {
        return entityManager.find(Clean.class, id);
    }

}


