package restserver.business;

import org.jboss.logging.Logger;
import restserver.helper.CRUDManager;
import restserver.model.Turma;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

/**
 * Pessoa <br> Classe de negócio, responsável pela lógica , processamento relacionado ao dominio Pessoa
 */
@Stateless
@LocalBean
public class TurmaBusiness implements ICrudBasic<Turma> {

    @Inject
    private CRUDManager crudManager;

    @Inject
    protected transient Logger logger;

    @Override
    public Turma create() {

        Turma entidade = new Turma();
        entidade.setInicioAnoLetivo(new Date());

        return entidade;
    }

    @Override
    public Long save(final Turma resource) {

        return crudManager.save(resource);
    }

    @Override
    public Turma read(final Long id) {
        return crudManager.read(Turma.class, id);
    }

    @Override
    public void update(final Long id, final Turma resource) {

        crudManager.update(Turma.class, resource);
    }

    @Override
    public void delete(final Long id) {
        crudManager.delete(Turma.class, id);
    }
}
