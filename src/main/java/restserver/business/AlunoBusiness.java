package restserver.business;


import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Aluno;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class AlunoBusiness implements ICrudBasic<Aluno> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;


    public Aluno create() {
        return new Aluno();
    }


    public Long save(Aluno resource) {
        return crudManager.save(resource);
    }


    public Aluno read(Long id) {
        return crudManager.read(Aluno.class, id);
    }


    public void update(Long id, Aluno resource) {


        crudManager.update(Aluno.class, resource);

    }


    public void delete(Long id) {


        crudManager.delete(Aluno.class, id);
    }
}
