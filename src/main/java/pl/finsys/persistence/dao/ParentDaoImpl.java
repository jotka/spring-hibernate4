package pl.finsys.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.finsys.persistence.model.Parent;

@Repository
public class ParentDaoImpl extends AbstractDao<Parent> implements ParentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ParentDaoImpl() {
        super();

        setClazz(Parent.class);
    }

}
