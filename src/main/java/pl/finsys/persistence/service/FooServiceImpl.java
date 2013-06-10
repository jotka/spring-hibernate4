package pl.finsys.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.finsys.persistence.dao.DaoOperations;
import pl.finsys.persistence.dao.FooDao;
import pl.finsys.persistence.model.Foo;

@Service
public class FooServiceImpl extends AbstractService<Foo> implements FooService {

    @Autowired
    private FooDao dao;

    public FooServiceImpl() {
        super();
    }

    // API

    @Override
    protected DaoOperations<Foo> getDao() {
        return dao;
    }

}
