package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.LancamentoDiario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class LancamentoDiarioBusiness implements ICrudBasic<LancamentoDiario> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public LancamentoDiario create() {

        LancamentoDiario entidade = new LancamentoDiario();


        return entidade;
    }

    @Override
    public Long save(final LancamentoDiario resource) {

        return crudManager.save(resource);
    }

    @Override
    public LancamentoDiario read(final Long id) {
        return crudManager.read(LancamentoDiario.class, id);
    }

    @Override
    public void update(final Long id, final LancamentoDiario resource) {

        crudManager.update(LancamentoDiario.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(LancamentoDiario.class, id);
    }
}
