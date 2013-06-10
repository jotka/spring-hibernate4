package pl.finsys.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.finsys.persistence.dao.ChildDao;
import pl.finsys.persistence.dao.DaoOperations;
import pl.finsys.persistence.model.Child;

@Service
public class ChildServiceImpl extends AbstractService<Child> implements ChildService {

    @Autowired
    private ChildDao dao;

    public ChildServiceImpl() {
        super();
    }

    // API

    @Override
    protected DaoOperations<Child> getDao() {
        return dao;
    }

}
