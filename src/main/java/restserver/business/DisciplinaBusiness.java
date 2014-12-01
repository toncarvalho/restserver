package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Disciplina;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class DisciplinaBusiness implements ICrudBasic<Disciplina> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public Disciplina create() {

        Disciplina entidade = new Disciplina();
        entidade.setNome("teste1");

        return entidade;
    }

    @Override
    public Long save(final Disciplina resource) {

        return crudManager.save(resource);
    }

    @Override
    public Disciplina read(final Long id) {
        return crudManager.read(Disciplina.class, id);
    }

    @Override
    public void update(final Long id, final Disciplina resource) {

        crudManager.update(Disciplina.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(Disciplina.class, id);
    }
}
