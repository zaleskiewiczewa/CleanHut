package pl.coderslab.repository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Week;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository

public class WeekRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Week saveWeek(Week week) {
        if (week.getId() == null) {
            entityManager.persist(week);
        } else {
            entityManager.merge(week);
        }
        return week;

    }

    public Week readWeek(Long id){
        return entityManager.find(Week.class, id);
    }

    public Week updateWeek (Week week){
        entityManager.merge(week);
        return week;
    }

    public void removeWeek(Long id) {
        Week week = entityManager.find(Week.class, id);
        entityManager.remove(entityManager.contains(week) ? week : entityManager.merge(week));

    }

    public List<Week> findAll() {
        Query query = entityManager.createQuery("Select t from Week t");
        return query.getResultList();
    }

    public Week findById(Long id) {
        return entityManager.find(Week.class, id);
    }

}





