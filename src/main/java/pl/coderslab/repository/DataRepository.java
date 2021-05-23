package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Data;
import pl.coderslab.entity.Service;
import pl.coderslab.entity.Space;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional

public class DataRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void saveData(Data data) {
        entityManager.persist(data);
    }

    public Data findById(Long id) {
        return entityManager.find(Data.class, id);
    }

}