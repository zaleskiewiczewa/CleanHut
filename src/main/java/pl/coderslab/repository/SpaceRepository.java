package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Space;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository


public class SpaceRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Space saveSpace(Space space) {
        if (space.getId() == null) {
            entityManager.persist(space);
        } else {
            entityManager.merge(space);
        }
        return space;

    }

    public Space readSpace(Long id){
        return entityManager.find(Space.class, id);
    }

    public Space updateSpace (Space space){
        entityManager.merge(space);
        return space;
    }

    public void removeSpace(Long id) {
        Space space = entityManager.find(Space.class, id);
        entityManager.remove(entityManager.contains(space) ? space : entityManager.merge(space));

    }

    public List<Space> findAll() {
        Query query = entityManager.createQuery("Select t from Space t");
        return query.getResultList();
    }

    public Space findById(Long id) {
        return entityManager.find(Space.class, id);
    }

}
