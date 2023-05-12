public class ExececaoDeAlunoNaoMatriculadoNoCurso extends Exception {
	public ExececaoDeAlunoNaoMatriculadoNoCurso(Aluno aluno, Curso curso) {
		super("O aluno [" + aluno.getNome() + "]" + " não está matriculado no curso " + curso.getNome() + ".");
	}
}
