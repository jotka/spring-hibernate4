package pl.finsys.persistence.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDaoImpl<T extends Serializable> extends AbstractDao<T> implements GenericDao<T> {
}