package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Service;
import pl.coderslab.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional

public class ServiceRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void saveService(Service service) {
        entityManager.persist(service);
    }

    public Service readService(Long id){
        return entityManager.find(Service.class, id);
    }

    public Service updateService (Service service){
        entityManager.merge(service);
        return service;
    }

    public void removeService(Long id) {
        Service service = entityManager.find(Service.class, id);
        entityManager.remove(entityManager.contains(service) ? service : entityManager.merge(service));
    }

    public List<Service> findAll() {
        Query query = entityManager.createQuery("Select t from Service t");
        return query.getResultList();
    }

    public Service findById(Long id) {
        return entityManager.find(Service.class, id);
    }

}
