package model;

import java.util.Arrays;

public class Cliente extends Usuario implements IUsuario {
	private String nome;
	private String email;
	private String telefone;
	private Endereco enderecos[] = new Endereco[10];
	 Endereco endereco;
	private Pedido pedidos[] = new Pedido[10];
	private String codigoCliente;
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
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
	public Endereco[] getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}
	public Pedido[] getPedidos() {
		return pedidos;
	}
	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}
	public Cliente () {
		super();
	}
	public Cliente(String senha, String login, int tipo,String nome, String email, String telefone, Endereco[] enderecos, Pedido[] pedidos,
			String codigoCliente) {
		super(senha, login, tipo);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.enderecos = enderecos;
		this.pedidos = pedidos;
		this.codigoCliente = codigoCliente;
		
		inserirEndereco(endereco);
	}
	
	
	public Cliente(String senha, String login, int tipo, String nome2, String email2, String telefone2,
			Endereco enderecos2, Pedido pedidos2, String codigoCliente2) {
		// TODO Auto-generated constructor stub
	}
	public boolean inserirPedido(Pedido pedido){
		for (int i = 0; i < pedidos.length; i++){
		if (pedidos[i] == null){
			pedidos[i] = pedido;
		return true;
	}

		
		
		}
		return false;
		
	}
	public boolean inserirEndereco(Endereco end){
		for (int i = 0; i < enderecos.length; i++){
		if (enderecos[i] == null){
			enderecos[i] = end;
		return true;
	}

		}
		return false;
		
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", enderecos="
				+ Arrays.toString(enderecos) + ", pedidos=" + Arrays.toString(pedidos) + ", codigoCliente="
				+ codigoCliente + "]";
	}
	
	@Override
	 public boolean validarLogin (String login, String senha){
	 if(getLogin().equals(login) && getSenha().equals(senha)){
	 return true;
	 }
	 return false;
	 }

	
	
}
