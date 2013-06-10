package pl.finsys.persistence.service;

import org.springframework.transaction.annotation.Transactional;
import pl.finsys.persistence.dao.DaoOperations;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class AbstractService<T extends Serializable> implements DaoOperations<T> {

    @Override
    public T findOne(final long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }

    protected abstract DaoOperations<T> getDao();

}
