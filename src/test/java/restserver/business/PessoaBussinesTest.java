package restserver.business;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import restserver.model.Pessoa;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class PessoaBussinesTest extends TestBase {

    @Inject
    private PessoaBusiness business;


    @Test
    public void test() {


        Pessoa pessoa = new Pessoa();

        pessoa.setNome("teste com pessoas");
        pessoa.setEmail("teste@gmail.com");

        Long idNovaPessoa = business.save(pessoa);

        assertNotNull(" nova pessoa nula", idNovaPessoa);


    }
}
