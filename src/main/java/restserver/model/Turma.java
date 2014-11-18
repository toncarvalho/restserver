package restserver.model;

import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Turma extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    private String periodoTurma;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Curso curso;


    private List<Aluno> alunos;

}
