package pl.finsys.persistence.service;

import pl.finsys.persistence.model.Child;
import pl.finsys.persistence.model.Parent;
import pl.finsys.spring.PersistenceConfig;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public class ParentServicePersistenceIntegrationTest {

    @Autowired
    private ParentService service;

    @Autowired
    private ChildService childService;

    @Autowired
    private SessionFactory sessionFactory;

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenNoExceptions() {
        //
    }

    @Test
    public final void whenOneToOneEntitiesAreCreated_thenNoExceptions() {
        final Child childEntity = new Child();
        childService.create(childEntity);

        final Parent parentEntity = new Parent(childEntity);
        service.create(parentEntity);

        System.out.println("Child = " + childService.findOne(childEntity.getId()));
        System.out.println("Child - parent = " + childService.findOne(childEntity.getId()).getParent());

        System.out.println("Parent = " + service.findOne(parentEntity.getId()));
        System.out.println("Parent - child = " + service.findOne(parentEntity.getId()).getChild());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public final void whenChildIsDeletedWhileParentStillHasForeignKeyToIt_thenDataException() {
        final Child childEntity = new Child();
        childService.create(childEntity);

        final Parent parentEntity = new Parent(childEntity);
        service.create(parentEntity);

        childService.delete(childEntity);
    }

    @Test
    public final void whenChildIsDeletedAfterTheParent_thenNoExceptions() {
        final Child childEntity = new Child();
        childService.create(childEntity);

        final Parent parentEntity = new Parent(childEntity);
        service.create(parentEntity);

        service.delete(parentEntity);
        childService.delete(childEntity);
    }

}
