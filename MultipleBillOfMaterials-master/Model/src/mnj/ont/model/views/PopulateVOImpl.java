
package mnj.ont.model.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class PopulateService {

    @PersistenceContext
    private EntityManager entityManager;

    public PopulateService() {
    }

    @Transactional(readOnly = true)
    public List<Object> executeQueryForCollection(String queryString, Object... params) {
        Query query = entityManager.createQuery(queryString);
        setParameters(query, params);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public boolean hasNextForCollection(String queryString, Object... params) {
        List<Object> results = executeQueryForCollection(queryString, params);
        return !results.isEmpty();
    }

    @Transactional(readOnly = true)
    public Object createRowFromResultSet(String queryString, Object... params) {
        List<Object> results = executeQueryForCollection(queryString, params);
        return results.isEmpty() ? null : results.get(0);
    }

    @Transactional(readOnly = true)
    public long getQueryHitCount(String queryString, Object... params) {
        Query query = entityManager.createQuery("SELECT COUNT(o) FROM (" + queryString + ") o");
        setParameters(query, params);
        return (long) query.getSingleResult();
    }

    private void setParameters(Query query, Object... params) {
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
    }
}
