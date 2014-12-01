package restserver.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Indexed
public class Professor extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String nome;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 30, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String numeroRegistro;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 100, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String email;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 20, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String foneComercial;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 20, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String foneCelular;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String sites;

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public void setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }
}
