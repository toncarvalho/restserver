package restserver.model;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import restserver.helper.ValidationMessage;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Indexed
public class Turma extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Size(min = 2, max = 200, message = ValidationMessage.SIZE)
    @Field(index = Index.YES, store = Store.YES)
    private String periodoTurma;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Field(index = Index.YES, store = Store.YES)
    private Date inicioAnoLetivo;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @Field(index = Index.YES, store = Store.YES)
    private Date finalAnoLetivo;


    @ManyToOne
    private Curso curso;


    @OneToMany
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
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
