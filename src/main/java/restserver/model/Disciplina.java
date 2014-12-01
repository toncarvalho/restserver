package restserver.model;


import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Indexed
public class Disciplina extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String nome;


    @NotNull(message = ValidationMessage.NOT_NULL)
    @Max(value = 160, message = ValidationMessage.MAX_LIMIT)
    @Field(index = Index.YES, store = Store.YES)
    private Double cargaHoraria;

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
