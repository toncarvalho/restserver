package restserver.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import restserver.helper.ValidationMessage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Indexed
public class LancamentoDiario extends ModelBase {


    @NotNull(message = ValidationMessage.NOT_NULL)
    @Field(index = Index.YES, store = Store.YES)
    private Date data;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 10, max = 200, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String descricaoDeAtividades;

    @ManyToOne
    private DiarioDeClasse diarioDeClasse;

    @OneToMany(mappedBy = "lancamentoDiario", cascade = CascadeType.ALL)
    private List<FrequenciaAluno> frequenciaAlunoList;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricaoDeAtividades() {
        return descricaoDeAtividades;
    }

    public void setDescricaoDeAtividades(String descricaoDeAtividades) {
        this.descricaoDeAtividades = descricaoDeAtividades;
    }

    public List<FrequenciaAluno> getFrequenciaAlunoList() {
        return frequenciaAlunoList;
    }

    public void setFrequenciaAlunoList(List<FrequenciaAluno> frequenciaAlunoList) {
        this.frequenciaAlunoList = frequenciaAlunoList;
    }

    public DiarioDeClasse getDiarioDeClasse() {
        return diarioDeClasse;
    }

    public void setDiarioDeClasse(DiarioDeClasse diarioDeClasse) {
        this.diarioDeClasse = diarioDeClasse;
    }
}
