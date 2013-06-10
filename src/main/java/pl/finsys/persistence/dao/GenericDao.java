package pl.finsys.persistence.dao;

import java.io.Serializable;

public interface GenericDao<T extends Serializable> extends DaoOperations<T> {
}
