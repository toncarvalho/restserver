package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.ModelBase;
import restserver.model.Pessoa;

import javax.inject.Inject;

/**
 * Created by ton on 19/11/14.
 */
public abstract class CRUDBase<T extends ModelBase> {



    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    protected  abstract T create();

    public Long save(final T resource) {

        return crudManager.save(resource);
    }

    public T read(final Long id) {
        return crudManager.read(T, id);
    }

    public void update(final Long id, final T resource) {

        crudManager.update(id, resource);
    }

    public void delete(final Long id) {
        crudManager.delete(T, id);
    }
}
