package restserver.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class FrequenciaAluno extends ModelBase {

    @ManyToOne
    private Aluno aluno;

    private Boolean presente;

    @ManyToOne
    private LancamentoDiario lancamentoDiario;


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public LancamentoDiario getLancamentoDiario() {
        return lancamentoDiario;
    }

    public void setLancamentoDiario(LancamentoDiario lancamentoDiario) {
        this.lancamentoDiario = lancamentoDiario;
    }
}
