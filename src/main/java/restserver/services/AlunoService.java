package restserver.services;

import restserver.business.AlunoBusiness;
import restserver.model.Aluno;

import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * implementação de webservice , rest para  a entidade pessoa
 */
@Path("/aluno")
@RequestScoped
@LocalBean
public class AlunoService implements ICrudRest<Aluno> {

    @Inject
    private AlunoBusiness business;

    @Override
    public Aluno create() {
        return business.create();
    }

    @Override
    public Long save(final Aluno resource) {
        return business.save(resource);
    }

    @Override
    public Aluno read(final Long id) {
        return business.read(id);
    }

    @Override
    public void update(final Long id, final Aluno resource) {

        business.update(id, resource);

    }

    @Override
    public void delete(final Long id) {
        business.delete(id);

    }


}
