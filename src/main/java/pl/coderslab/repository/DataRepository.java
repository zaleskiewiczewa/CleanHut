package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Data;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository

public class DataRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Data saveData(Data data) {
        if (data.getId() == null) {
            entityManager.persist(data);
        } else {
            entityManager.merge(data);
        }
        return data;

    }

    public Data readData(Long id){
        return entityManager.find(Data.class, id);
    }

    public Data updateData (Data data){
        entityManager.merge(data);
        return data;
    }

    public void removeData(Long id) {
        Data data = entityManager.find(Data.class, id);
        entityManager.remove(entityManager.contains(data) ? data : entityManager.merge(data));
    }

    public List<Data> findAll() {
        Query query = entityManager.createQuery("Select t from Data t");
        return query.getResultList();
    }

    public Data findById(Long id) {
        return entityManager.find(Data.class, id);
    }
}


