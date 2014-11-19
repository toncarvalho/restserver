package restserver.model;


import restserver.helper.ValidationMessage;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class DiarioDeClasse extends ModelBase {

    @NotNull(message = ValidationMessage.NOT_NULL)
    @ManyToOne
    private Turma turma;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @ManyToOne
    private Professor professor;

    @NotNull(message = ValidationMessage.NOT_NULL)
    @ManyToOne
    private Disciplina disciplina;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Date inicioVigencia;

    @NotNull(message = ValidationMessage.NOT_NULL)
    private Date finalVigencia;


    @OneToMany(mappedBy = "diarioDeClasse")
    private List<LancamentoDiario> lancamentosDiario;


    @OneToMany(mappedBy = "diarioDeClasse")
    private List<AvaliacaoAluno> avaliacoes;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFinalVigencia() {
        return finalVigencia;
    }

    public void setFinalVigencia(Date finalVigencia) {
        this.finalVigencia = finalVigencia;
    }

    public List<LancamentoDiario> getLancamentosDiario() {
        return lancamentosDiario;
    }

    public void setLancamentosDiario(List<LancamentoDiario> lancamentosDiario) {
        this.lancamentosDiario = lancamentosDiario;
    }

    public List<AvaliacaoAluno> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoAluno> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
