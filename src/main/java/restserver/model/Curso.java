package restserver.model;

import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Curso extends ModelBase {


    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 10, max = 200, message = ValidationMessage.SIZE)
    private String nome;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    private String descricao;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    private String duracao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
