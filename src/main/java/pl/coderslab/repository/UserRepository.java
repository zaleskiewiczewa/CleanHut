package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Data;
import pl.coderslab.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Transactional
@Repository

public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public User saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;

    }

    public User readUser(Long id){
        return entityManager.find(User.class, id);
    }

    public User updateUser (User user){
        entityManager.merge(user);
        return user;
    }

    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    public List<User> findAll() {
        Query query = entityManager.createQuery("Select t from User t");
        return query.getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

}


