package restserver.services;

import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import restserver.business.PessoaBusiness;
import restserver.model.Pessoa;

/**
 * implementação de webservice , rest para  a entidade pessoa
 */
@Path("/pessoa")
@RequestScoped
@LocalBean
public class PessoaService implements ICrudRest<Pessoa> {

    @Inject
    private PessoaBusiness pessoaBusiness;

    @Override
    public Pessoa create() {
        return pessoaBusiness.create();
    }

    @Override
    public Long save(final Pessoa resource) {
        return pessoaBusiness.save(resource);
    }

    @Override
    public Pessoa read(final Long id) {
        return pessoaBusiness.read(id);
    }

    @Override
    public void update(final Long id, final Pessoa resource) {

        pessoaBusiness.update(id,resource);

    }

    @Override
    public void delete(final Long id) {
        pessoaBusiness.delete(id);

    }


}
