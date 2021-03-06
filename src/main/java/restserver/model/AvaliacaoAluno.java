package restserver.model;


import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Indexed
public class AvaliacaoAluno extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Field(index = Index.YES, store = Store.YES)
    private Date dataAvaliacao;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Field(index = Index.YES, store = Store.YES)
    @Size(min = 3, max = 100, message = ValidationMessage.SIZE)
    private String descricao;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Aluno aluno;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Field(index = Index.YES, store = Store.YES)
    private Double nota;

    @ManyToOne
    private DiarioDeClasse diarioDeClasse;


    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public DiarioDeClasse getDiarioDeClasse() {
        return diarioDeClasse;
    }

    public void setDiarioDeClasse(DiarioDeClasse diarioDeClasse) {
        this.diarioDeClasse = diarioDeClasse;
    }
}
