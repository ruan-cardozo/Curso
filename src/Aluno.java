public class Aluno extends Pessoa {

	private String matricula;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Aluno aluno)) return false;
		if (!super.equals(o)) return false;

		return getMatricula() != null ? getMatricula().equals(aluno.getMatricula()) : aluno.getMatricula() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
		return result;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}