package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Service;
import pl.coderslab.entity.Space;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional

public class ServiceRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void saveService(Service service) {
        entityManager.persist(service);
    }

    public Service findById(Long id) {
        return entityManager.find(Service.class, id);
    }

}
