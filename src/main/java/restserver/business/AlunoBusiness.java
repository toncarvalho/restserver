package restserver.business;

import restserver.model.Aluno;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class AlunoBusiness extends CRUDBase<Aluno> {
    @Override
    public Aluno novo() {
        return null;
    }
}
