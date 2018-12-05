package model;

public class Funcionario extends Usuario {

	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Funcionario() {
		super();
	}

	public Funcionario(String senha, String login, int tipo,String matricula) {
		super(senha, login, tipo);
		this.matricula = matricula;
	}


}
