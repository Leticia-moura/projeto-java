package model;

public class Usuario {
	
	String senha;
	String login;
	String nome;
	String email;
	String telefone;
	
int matricula;
	public int getMatricula() {
	return matricula;
}

public void setMatricula(int matricula) {
	this.matricula = matricula;
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

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
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

	public Usuario() {
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public String toString() {
		return "Usuario [senha=" + senha + ", login=" + login + ", nome=" + nome + ", email=" + email + ", telefone="
				+ telefone + ", matricula=" + matricula + "]";
	}

	public Usuario(String senha, String login, String nome, String email, String telefone, int matricula) {
		super();
		this.senha = senha;
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.matricula = matricula;
	}
	public void mostrar (){
		//Mostrar usuário
		System.out.println("\n\nUsuário:\n");
		System.out.println("Matrícula: " + this.matricula);
		System.out.println("Login: " + this.login);
		System.out.println("Senha: " + this.senha);
		System.out.println("Nome: " + this.nome);
		System.out.println("E-mail: " + this.email);
		System.out.println("Telefone: " + this.telefone);
	}
	
}
