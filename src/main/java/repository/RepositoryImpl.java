package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RepositoryImpl<T,ID> implements Repository<T,ID> {
    private Class<T> entityclass;
    @PersistenceContext
    protected EntityManager em;

    public RepositoryImpl(Class<T> entityclass, EntityManager em) {
        this.entityclass = entityclass;
        this.em = em;
    }

    @Override
    public T findById(ID id) {
        return em.find(entityclass, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityclass.getSimpleName() + " e", entityclass).getResultList();
    }

    @Override
    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
}
