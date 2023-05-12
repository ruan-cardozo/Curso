import java.util.List;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		Logger log = Logger.getAnonymousLogger();
		// cria um curso
		Curso curso = new Curso("Engenharia de Software", 4);

		// cria algumas disciplinas e adiciona ao curso
		Disciplina prog1 = new Disciplina("Programação 1");
		Disciplina prog2 = new Disciplina("Programação Orientada a Objetos");
		curso.adicionarDisciplina(prog1);
		curso.adicionarDisciplina(prog2);

		// cria alguns alunos
		Aluno aluno1 = new Aluno("João", 1);
		Aluno aluno2 = new Aluno("Maria", 2);

		curso.adicionarAlunoNoCurso( aluno1 );
		curso.adicionarAlunoNoCurso( aluno2 );

		Matricula solicitarMatricula = new Matricula(aluno1,prog1, 2023, 1);

		// matricula os alunos em algumas disciplinas
		try {
			curso.solicitarMatricula(solicitarMatricula);
		} catch (ExececaoDeAlunoNaoMatriculadoNoCurso e) {
			log.severe(e.getMessage());
		} catch (DisciplinaInexistente e) {
			log.severe(e.getMessage());
		}


		// obtém a lista de alunos matriculados no curso
		List<Aluno> alunosDoCurso = curso.obterAlunosDoCurso();
		System.out.println("Alunos matriculados no curso:");
		for (Aluno aluno : alunosDoCurso) {
			System.out.println(aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
		}

		// obtém a lista de alunos matriculados na disciplina de programação 2
		List<Aluno> alunosMatriculadosProg2 = curso.getAlunosDaDisciplina(prog2);

		// imprime a lista de alunos matriculados na disciplina de programação 2
		System.out.println("\nAlunos matriculados na disciplina de programação 2:");
		for (Aluno aluno : alunosMatriculadosProg2) {
			System.out.println(aluno.getNome() + " - Matrícula: " + aluno.getMatricula());
		}
	}
}