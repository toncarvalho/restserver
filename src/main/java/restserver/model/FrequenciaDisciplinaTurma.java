package restserver.model;

import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class FrequenciaDisciplinaTurma extends ModelBase {


    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 30, message = ValidationMessage.SIZE)
    private String diaDaSemana;

    @Temporal(TemporalType.TIME)
    @NotNull(message = ValidationMessage.NOT_NULL)
    private Date horarioInicial;

    @Temporal(TemporalType.TIME)
    @NotNull(message = ValidationMessage.NOT_NULL)
    private Date horarioFinal;

    @ManyToOne
    private DisciplinasTurmaProfessor disciplinasTurmaProfessor;

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Date getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(Date horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public Date getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Date horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public DisciplinasTurmaProfessor getDisciplinasTurmaProfessor() {
        return disciplinasTurmaProfessor;
    }

    public void setDisciplinasTurmaProfessor(DisciplinasTurmaProfessor disciplinasTurmaProfessor) {
        this.disciplinasTurmaProfessor = disciplinasTurmaProfessor;
    }
}
