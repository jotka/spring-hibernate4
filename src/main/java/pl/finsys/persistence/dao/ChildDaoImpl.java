package pl.finsys.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.finsys.persistence.model.Child;

@Repository
public class ChildDaoImpl extends AbstractDao<Child> implements ChildDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ChildDaoImpl() {
        super();

        setClazz(Child.class);
    }
}
