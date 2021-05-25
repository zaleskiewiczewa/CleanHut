package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Data;
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


    public Data findById(Long id) {
        return entityManager.find(Data.class, id);
    }

}