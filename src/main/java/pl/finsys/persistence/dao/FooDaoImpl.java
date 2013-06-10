package pl.finsys.persistence.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.finsys.persistence.model.Foo;

@Repository
public class FooDaoImpl extends AbstractDao<Foo> implements FooDao {

    @Autowired
    private SessionFactory sessionFactory;

    public FooDaoImpl() {
        super();

        setClazz(Foo.class);
    }
}
