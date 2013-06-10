package pl.finsys.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.finsys.persistence.dao.DaoOperations;
import pl.finsys.persistence.dao.ParentDao;
import pl.finsys.persistence.model.Parent;

@Service
public class ParentServiceImpl extends AbstractService<Parent> implements ParentService {

    @Autowired
    private ParentDao dao;

    public ParentServiceImpl() {
        super();
    }

    // API

    @Override
    protected DaoOperations<Parent> getDao() {
        return dao;
    }

}
