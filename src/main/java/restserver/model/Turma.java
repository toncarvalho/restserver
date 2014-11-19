package restserver.model;

import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
public class Turma extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 3, max = 200, message = ValidationMessage.SIZE)
    private String periodoTurma;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Date inicioAnoLetivo;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Date finalAnoLetivo;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Curso curso;


    @OneToMany
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "turma")
    private List<DisciplinasTurmaProfessor> disciplinasTurmaProfessorList ;

    @Enumerated
    private Status status;

    public String getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(String periodoTurma) {
        this.periodoTurma = periodoTurma;
    }

    public Date getInicioAnoLetivo() {
        return inicioAnoLetivo;
    }

    public void setInicioAnoLetivo(Date inicioAnoLetivo) {
        this.inicioAnoLetivo = inicioAnoLetivo;
    }

    public Date getFinalAnoLetivo() {
        return finalAnoLetivo;
    }

    public void setFinalAnoLetivo(Date finalAnoLetivo) {
        this.finalAnoLetivo = finalAnoLetivo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<DisciplinasTurmaProfessor> getDisciplinasTurmaProfessorList() {
        return disciplinasTurmaProfessorList;
    }

    public void setDisciplinasTurmaProfessorList(List<DisciplinasTurmaProfessor> disciplinasTurmaProfessorList) {
        this.disciplinasTurmaProfessorList = disciplinasTurmaProfessorList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
