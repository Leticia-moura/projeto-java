package model;

public abstract class Usuario {

	private int tipo;
	private String senha;
	private String login;
	
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
	this.tipo = tipo;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub

	}

	
	
	@Override
	public String toString() {
		return "Usuario [tipo=" + tipo + ", senha=" + senha + ", login=" + login + ", getTipo()=" + getTipo()
				+ ", getSenha()=" + getSenha() + ", getLogin()=" + getLogin() + "]";
	}

	public Usuario(String senha, String login,int tipo) {
		super();
		this.senha = senha;
		this.login = login;
		this.tipo= tipo;
	}


	public  void mostrar() {
	
		System.out.println("\n\nUsuário:\n");
	
		System.out.println("Login: " + this.login);
		System.out.println("Senha: " + this.senha);

	}

	public boolean validarLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

}
