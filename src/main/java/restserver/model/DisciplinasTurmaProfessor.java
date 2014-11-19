package restserver.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class DisciplinasTurmaProfessor extends ModelBase {

    @ManyToOne(optional = false)
    private Turma turma;

    @ManyToOne(optional = false)
    private Disciplina disciplina;

    @ManyToOne(optional = false)
    private Professor professor;

    @OneToMany(mappedBy = "disciplinasTurmaProfessor")
    private List<FrequenciaDisciplinaTurma> frequenciaDisciplinaTurmaList;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<FrequenciaDisciplinaTurma> getFrequenciaDisciplinaTurmaList() {
        return frequenciaDisciplinaTurmaList;
    }

    public void setFrequenciaDisciplinaTurmaList(List<FrequenciaDisciplinaTurma> frequenciaDisciplinaTurmaList) {
        this.frequenciaDisciplinaTurmaList = frequenciaDisciplinaTurmaList;
    }
}
