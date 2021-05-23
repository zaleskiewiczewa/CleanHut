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

    public Space findById(Long id) {
        return entityManager.find(Space.class, id);
    }

}
