package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Pessoa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class PessoaBusiness implements ICrudBasic<Pessoa> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public Pessoa create() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste1");

        return pessoa;
    }

    @Override
    public Long save(final Pessoa resource) {

        return crudManager.save(resource);
    }

    @Override
    public Pessoa read(final Long id) {
        return crudManager.read(Pessoa.class, id);
    }

    @Override
    public void update(final Long id, final Pessoa resource) {

        crudManager.update(Pessoa.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(Pessoa.class, id);
    }
}
