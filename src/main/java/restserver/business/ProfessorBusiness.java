package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Professor;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class ProfessorBusiness implements ICrudBasic<Professor> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public Professor create() {

        Professor entidade = new Professor();
        entidade.setNome("teste1");

        return entidade;
    }

    @Override
    public Long save(final Professor resource) {

        return crudManager.save(resource);
    }

    @Override
    public Professor read(final Long id) {
        return crudManager.read(Professor.class, id);
    }

    @Override
    public void update(final Long id, final Professor resource) {

        crudManager.update(Professor.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(Professor.class, id);
    }
}
