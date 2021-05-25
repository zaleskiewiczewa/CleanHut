package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Space;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional

public class SpaceRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void saveSpace(Space space) {
        entityManager.persist(space);
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

    public Space findById(Long id) {
        return entityManager.find(Space.class, id);
    }

}
