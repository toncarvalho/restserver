package restserver.business;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import restserver.model.*;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(Arquillian.class)
public class TesteGeral extends TestBase {


    @Inject
    private AlunoBusiness alunoBusiness;

    @Inject
    private CursoBusiness cursoBusiness;

    @Inject
    private DisciplinaBusiness disciplinaBusiness;

    @Inject
    private ProfessorBusiness professorBusiness;

    @Inject
    private TurmaBusiness turmaBusiness;

    @Inject
    private DiarioDeClasseBusiness diarioDeClasseBusiness;

    @Inject
    private LancamentoDiarioBusiness lancamentoDiarioBusiness;



    @Test
    public void teste() {

        Aluno jose = new Aluno();

        jose.setNome("José");
        jose.setEmail("jose@gmail.com");
        jose.setFone("44-99999999");
        jose.setFoneComercial("44-99999999");
        jose.setRegistroAcademico("12365789");
        alunoBusiness.save(jose);


        Aluno pedro = new Aluno();
        pedro.setNome("Pedro");
        pedro.setEmail("pedro@gmail.com");
        pedro.setFone("44-88888888");
        pedro.setFoneComercial("44-88888888");
        pedro.setRegistroAcademico("789987789");

        alunoBusiness.save(pedro);


        Aluno andre = new Aluno();
        andre.setNome("Andre");
        andre.setEmail("andre@gmail.com");
        andre.setFone("44-88888888");
        andre.setFoneComercial("44-88888888");
        andre.setRegistroAcademico("789987789");

        alunoBusiness.save(andre);

        /** as linhas acima realizam inserção de vários alunos na base de dados*/

        /** Configurando curso */

        Curso curso = new Curso();
        curso.setNome("Sistemas de informação");
        curso.setDescricao("Curso de informática");
        curso.setDuracao("8 Semestres");

        cursoBusiness.save(curso);

        /**
         * As linha acima definem um curso para a aplicação
         */

        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Estrutura de dados");
        disciplina.setCargaHoraria(80d);

        disciplinaBusiness.save(disciplina);

        /**
         * As linhas acima definem uma disciplina
         */

        Professor professor = new Professor();
        professor.setNome("Girafalles");
        professor.setEmail("girafalles@gmail.com");
        professor.setFoneCelular("44-9999999");
        professor.setNumeroRegistro("789654");
        professor.setFoneComercial("44-9999999");
        professor.setSites("Gerafallesfacebook");


        professorBusiness.save(professor);

        /**
         * As linhas acima definem o registro de um professor na base dedados.
         */


        /**
         * Agora vamos definir uma turma.
         */

        Turma turma = new Turma();
        turma.setCurso(curso);
        try {
            turma.setInicioAnoLetivo(DateFormat.getDateInstance().parse("24/02/2014"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        turma.setFinalAnoLetivo(new Date());
        turma.setStatus(Status.ATIVO);
        turma.setPeriodoTurma("1º");

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(jose);
        alunos.add(pedro);
        alunos.add(andre);
        turma.setAlunos(alunos);


        DisciplinasTurmaProfessor dtp = new DisciplinasTurmaProfessor();
        dtp.setTurma(turma);
        dtp.setDisciplina(disciplina);
        dtp.setProfessor(professor);

        /**
         * adicionando disciplina para a turma.
         */
        List<DisciplinasTurmaProfessor> disciplinasTurma = new ArrayList<>();
        disciplinasTurma.add(dtp);

        turma.setDisciplinasTurmaProfessorList(disciplinasTurma);

        turmaBusiness.save(turma);

        /**
         * Montando o diário de classe
         */


        DiarioDeClasse diarioDeClasse = new DiarioDeClasse();
        diarioDeClasse.setProfessor(professor);
        diarioDeClasse.setDisciplina(disciplina);
        diarioDeClasse.setTurma(turma);
        try {
            diarioDeClasse.setInicioVigencia(DateFormat.getDateInstance().parse("24/02/2014"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        diarioDeClasse.setFinalVigencia(new Date());


        List<LancamentoDiario> lancamentosDiarios = new ArrayList<>();

        LancamentoDiario ld1 = new LancamentoDiario();
        ld1.setData(new Date());
        ld1.setDiarioDeClasse(diarioDeClasse);
        ld1.setDescricaoDeAtividades("Aula Normal");
        List<FrequenciaAluno> frequenciaAlunos = new ArrayList<>();
        frequenciaAlunos.add(new FrequenciaAluno(andre, Boolean.FALSE, ld1));
        frequenciaAlunos.add(new FrequenciaAluno(jose, Boolean.TRUE, ld1));
        frequenciaAlunos.add(new FrequenciaAluno(pedro, Boolean.TRUE, ld1));
        ld1.setFrequenciaAlunoList(frequenciaAlunos);


        diarioDeClasse.setLancamentosDiario(lancamentosDiarios);

        diarioDeClasseBusiness.save(diarioDeClasse);


        lancamentoDiarioBusiness.save(ld1);


    }
}
