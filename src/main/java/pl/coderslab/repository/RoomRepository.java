package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.room;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository


public class roomRepository {

    @PersistenceContext
    EntityManager entityManager;

    public room saveroom(room room) {
        if (room.getId() == null) {
            entityManager.persist(room);
        } else {
            entityManager.merge(room);
        }
        return room;

    }

    public room readroom(Long id){
        return entityManager.find(room.class, id);
    }

    public room updateroom (room room){
        entityManager.merge(room);
        return room;
    }

    public void removeroom(Long id) {
        room room = entityManager.find(room.class, id);
        entityManager.remove(entityManager.contains(room) ? room : entityManager.merge(room));

    }

    public List<room> findAll() {
        Query query = entityManager.createQuery("Select t from room t");
        return query.getResultList();
    }

    public room findById(Long id) {
        return entityManager.find(room.class, id);
    }

}
