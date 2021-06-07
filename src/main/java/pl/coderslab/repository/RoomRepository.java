package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Room;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository

public class RoomRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Room saveRoom(Room room) {
        if (room.getId() == null) {
            entityManager.persist(room);
        } else {
            entityManager.merge(room);
        }
        return room;

    }

    public Room readRoom(Long id){
        return entityManager.find(Room.class, id);
    }

    public Room updateRoom (Room room){
        entityManager.merge(room);
        return room;
    }

    public void removeRoom(Long id) {
        Room room = entityManager.find(Room.class, id);
        entityManager.remove(entityManager.contains(room) ? room : entityManager.merge(room));

    }

    public List<Room> findAll() {
        Query query = entityManager.createQuery("Select t from Room t");
        return query.getResultList();
    }

    public Room findById(Long id) {
        return entityManager.find(Room.class, id);
    }

}
