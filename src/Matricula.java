public class Matricula {

	private Aluno aluno;
	private Disciplina disciplina;
	private int ano;
	private int semestre;

	public Matricula(Aluno aluno, Disciplina disciplina, int ano, int semestre) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.ano = ano;
		this.semestre = semestre;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Matricula that)) return false;

		if (getAno() != that.getAno()) return false;
		if (getSemestre() != that.getSemestre()) return false;
		if (getAluno() != null ? !getAluno().equals(that.getAluno()) : that.getAluno() != null) return false;
		return getDisciplina() != null ? getDisciplina().equals(that.getDisciplina()) : that.getDisciplina() == null;
	}

	@Override
	public int hashCode() {
		int result = getAluno() != null ? getAluno().hashCode() : 0;
		result = 31 * result + (getDisciplina() != null ? getDisciplina().hashCode() : 0);
		result = 31 * result + getAno();
		result = 31 * result + getSemestre();
		return result;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public int getAno() {
		return ano;
	}

	public int getSemestre() {
		return semestre;
	}
}