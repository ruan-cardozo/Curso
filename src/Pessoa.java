public class Pessoa {
	private  String nome;
	private String endereco;
	private String email;
	private String telefone;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pessoa pessoa)) return false;

		if (getNome() != null ? !getNome().equals(pessoa.getNome()) : pessoa.getNome() != null) return false;
		if (getEndereco() != null ? !getEndereco().equals(pessoa.getEndereco()) : pessoa.getEndereco() != null)
			return false;
		if (getEmail() != null ? !getEmail().equals(pessoa.getEmail()) : pessoa.getEmail() != null) return false;
		return getTelefone() != null ? getTelefone().equals(pessoa.getTelefone()) : pessoa.getTelefone() == null;
	}

	@Override
	public int hashCode() {
		int result = getNome() != null ? getNome().hashCode() : 0;
		result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		result = 31 * result + (getTelefone() != null ? getTelefone().hashCode() : 0);
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}