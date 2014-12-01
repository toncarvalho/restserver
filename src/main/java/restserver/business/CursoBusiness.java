package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Curso;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class CursoBusiness implements ICrudBasic<Curso> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public Curso create() {

        Curso entidade = new Curso();
        entidade.setNome("teste1");

        return entidade;
    }

    @Override
    public Long save(final Curso resource) {

        return crudManager.save(resource);
    }

    @Override
    public Curso read(final Long id) {
        return crudManager.read(Curso.class, id);
    }

    @Override
    public void update(final Long id, final Curso resource) {

        crudManager.update(Curso.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(Curso.class, id);
    }
}
