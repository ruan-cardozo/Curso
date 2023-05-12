import java.util.*;

public class Curso {
	private String nome;
	private int duracao;
	private List<Disciplina> listaDisciplinas = new ArrayList<>();

	private List<Aluno> listaAlunos = new ArrayList<>();

	private List<Matricula> alunosMatriculadosNasDisciplinas = new ArrayList<>();

	public Curso(String curso, int duracao) {
		this.nome = curso;
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Curso curso)) return false;

		if (duracao != curso.duracao) return false;
		if (getNome() != null ? !getNome().equals(curso.getNome()) : curso.getNome() != null) return false;
		return Objects.equals(listaDisciplinas, curso.listaDisciplinas);
	}

	@Override
	public int hashCode() {
		int result = getNome() != null ? getNome().hashCode() : 0;
		result = 31 * result + duracao;
		result = 31 * result + (listaDisciplinas != null ? listaDisciplinas.hashCode() : 0);
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		this.listaDisciplinas.add(disciplina);
	}

	public List<Disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public List<Aluno> obterAlunosDoCurso() {
		return listaAlunos;
	}

	public Map<Aluno, List<Disciplina>> obterDisciplinasPorAluno(int ano, int semestre) {
		Map<Aluno, List<Disciplina>> disciplinasPorAluno = new HashMap<>();
		for (Disciplina disciplina : listaDisciplinas) {

		}
		return disciplinasPorAluno;
	}


	public void solicitarMatricula(Aluno aluno, Disciplina disciplina, int ano, int semestre) {
		Matricula solicitarMatricula = new Matricula(aluno,disciplina, ano, semestre);
		this.solicitarMatricula(solicitarMatricula);
	}

	private final boolean existeEstaDisciplinaNoCursoAtual(Disciplina disciplina) {
		return listaDisciplinas.contains(disciplina);
	}

	public void solicitarMatricula(Matricula solicitacao) {
		Disciplina disciplinaSolicitada = solicitacao.getDisciplina();
		boolean existeDisciplina = existeEstaDisciplinaNoCursoAtual(disciplinaSolicitada);
		if(existeDisciplina) {
			// ok existe a disciplina posso tentar
			Aluno aluno = solicitacao.getAluno();
			boolean alunoDoCurso = existeEsteAlunoNoCursoAtual(aluno);
			if( alunoDoCurso ) {
				// se a disciplina for do curso e o aluno tambem
				this.matricular(solicitacao);
			} else {
				// ops
			}

		} else {
			// ops estao tentando matricular em uma disciplina inexistente
		}

	}

	private void matricular(Matricula solicitacao) {
		// o metodo eh privado e chamado por uma solicitacao
		alunosMatriculadosNasDisciplinas.add(solicitacao);
	}

	private boolean existeEsteAlunoNoCursoAtual(Aluno aluno) {
		return listaAlunos.contains(aluno);
	}

	public void adicionarAlunoNoCurso(Aluno aluno) {
		listaAlunos.add(aluno);
	}

	public List<Disciplina> getDisciplinaPorAluno(Aluno alunoQueVouBuscar) {
		List<Disciplina> disciplinaDoAluno = new ArrayList<>();

		return disciplinaDoAluno;
	}
	public List<Aluno> getAlunosDaDisciplina(Disciplina disciplinaQueQueroProcurar) {
		List<Aluno> alunosDaDisciplina = new ArrayList<>();
		for (Matricula matricula : alunosMatriculadosNasDisciplinas) {
			Disciplina disciplina = matricula.getDisciplina();
			if( disciplina.equals(disciplinaQueQueroProcurar) )
				alunosDaDisciplina.add(matricula.getAluno());
		}
		return alunosDaDisciplina;
	}
}