package restserver.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import restserver.helper.ValidationMessage;

/**
 * Entidade Pessoa.
 */
@Entity
@Indexed
public class Pessoa extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 30, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String nome;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 30, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
}
