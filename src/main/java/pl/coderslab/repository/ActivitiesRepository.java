package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Activities;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ActivitiesRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Activities saveActivities(Activities activities) {
        if (activities.getId() == null) {
            entityManager.persist(activities);
        } else {
            entityManager.merge(activities);
        }
        return activities;
    }
    public Activities readActivities(Long id){
        return entityManager.find(Activities.class, id);
    }

    public Activities updateActivities (Activities activities){
        entityManager.merge(activities);
        return activities;
    }

    public void removeActivities(Long id) {
        Activities activities = entityManager.find(Activities.class, id);
        entityManager.remove(entityManager.contains(activities) ? activities : entityManager.merge(activities));
    }

    public List<Activities> findAll() {
        Query query = entityManager.createQuery("Select t from Activities t");
        return query.getResultList();
    }

    public Activities findById(Long id) {
        return entityManager.find(Activities.class, id);
    }

}


