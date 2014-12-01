package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.DiarioDeClasse;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class DiarioDeClasseBusiness implements ICrudBasic<DiarioDeClasse> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public DiarioDeClasse create() {

        DiarioDeClasse entidade = new DiarioDeClasse();


        return entidade;
    }

    @Override
    public Long save(final DiarioDeClasse resource) {

        return crudManager.save(resource);
    }

    @Override
    public DiarioDeClasse read(final Long id) {
        return crudManager.read(DiarioDeClasse.class, id);
    }

    @Override
    public void update(final Long id, final DiarioDeClasse resource) {

        crudManager.update(DiarioDeClasse.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(DiarioDeClasse.class, id);
    }
}
