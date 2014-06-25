package restserver.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Pessoa;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class PessoaBusiness {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    public Pessoa create() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste1");

        return pessoa;
    }

    public Long save(final Pessoa resource) {

        return crudManager.save(resource);
    }

    public Pessoa read(final Long id) {
        return crudManager.read(Pessoa.class, id);
    }

    public void update(final Long id, final Pessoa resource) {

        crudManager.update(Pessoa.class, resource);
    }

    public void delete(final Long id) {
        crudManager.delete(Pessoa.class, id);
    }
}
