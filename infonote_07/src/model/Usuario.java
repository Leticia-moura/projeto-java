package model;

public abstract class Usuario {

	private int tipo;
	private String senha;
	private String login;
	//private String nome;
	//private String email;
	//private String telefone;
	//private int matricula;
	
	
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
//	private Endereco enderecos[] = new Endereco [10];
//	private Pedido pedidos[] = new Pedido [10];
//
//	public Endereco[] getEnderecos() {
//		return enderecos;
//	}
//public Pedido[] getPedidos() {
//		return pedidos;
//	}
//	public int getMatricula() {
//		return matricula;
//	}
//
//	public void setMatricula(int matricula) {
//		this.matricula = matricula;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(String telefone) {
//		this.telefone = telefone;
//	}

	public Usuario() {
		// TODO Auto-generated constructor stub

	}

	//@Override
//	public String toString() {
//		return "Usuario [senha=" + senha + ", login=" + login + ", nome=" + nome + ", email=" + email + ", telefone="
//				+ telefone + ", matricula=" + matricula + "]";
//	}

//	public Usuario(String senha, String login, String nome, String email, String telefone, int matricula) {
//		super();
//		this.senha = senha;
//		this.login = login;
//		this.nome = nome;
//		this.email = email;
//		this.telefone = telefone;
//		this.matricula = matricula;
//	}
	
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

//	public boolean inserirPedido(Pedido pedido){
//		for (int i = 0; i < pedidos.length; i++){
//		if (pedidos[i] == null){
//			pedidos[i] = pedido;
//		return true;
//	}
//
//		}
//		return false;
//		
//	}
//	public boolean inserirEndereco(Endereco end){
//		for (int i = 0; i < enderecos.length; i++){
//		if (enderecos[i] == null){
//			enderecos[i] = end;
//		return true;
//	}
//
//		}
//		return false;
//		
//	}
	
	public  void mostrar() {
		// Mostrar usuário
		System.out.println("\n\nUsuário:\n");
		//System.out.println("Matrícula: " + this.matricula);
		System.out.println("Login: " + this.login);
		System.out.println("Senha: " + this.senha);
//		System.out.println("Nome: " + this.nome);
//		System.out.println("E-mail: " + this.email);
//		System.out.println("Telefone: " + this.telefone);
	}

}
