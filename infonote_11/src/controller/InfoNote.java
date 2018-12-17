package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import model.*;
import util.*;


public class InfoNote {

	
//		
	    Cliente user1;
	    
	   Funcionario user2;
		
		Notebook[] notebooks= new Notebook[10];
		
		Pedido pedido;
		
		boolean logado = false;
		
		Configurador config;
		Ajuda ajuda;


		private static Cliente clienteGlobal=null;
		private static Funcionario funcionarioGlobal=null;
		private static final int login = 1;
		private static final int cadastrar_usuario = 2;
		private static final int buscar_usuario = 3;
		private static final int inserir_notebook = 4;
		private static final int remover_notebook = 5;
		private static final int ver_carrinho = 6;
		private static final int efetuar_compra = 7;
		private static final int ajuda1 = 8;
		private static final int sair = 9;

		
		public InfoNote()  throws Exception{
			
			config = new Configurador();
			Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
			 ajuda = new Ajuda(config.getArquivoAjuda());
	
}	
		public void ajuda(){
			System.out.println(ajuda.getTexto());
			}

		
public void mostrarMenu() {
	
	System.out.println("=================================================");
	System.out.println(" InfoNote - Se não é Info não vendemos. "+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date())
			+ " " + DateFormat.getTimeInstance().format(new Date()));
	
	if (logado == true) {
		System.out.println("Seja bem vindo, "+ clienteGlobal.getNomeInvertido());
	}
	System.out.println("=================================================");
	System.out.println("1 - Login");
	System.out.println("2 - Cadastrar Usuário");
	System.out.println("3 - Buscar Notebook");
	System.out.println("4 - Inserir Notebook no carrinho");
	System.out.println("5 - Remover Notebook no carrinho");
	System.out.println("6 - Ver Carrinho");
	System.out.println("7 - Efetuar Compra");
	System.out.println("8 - Ajuda");
	System.out.println("9 - Sair");

	
}

public void efetuarLoginCliente () {
	 String login, senha;
	 login = teclado.lerTexto("Digite o login: "); 
	 senha = teclado.lerTexto("Digite a senha: ");
	 
	 if (clienteGlobal !=null) {
		 logado = clienteGlobal.validarLogin(login,senha);
		 if(logado) {
		 System.out.println("Login efetuado com sucesso.");
		 
	 }else {
		 System.out.println("Login ou senha inválido.");
		 efetuarLoginCliente();
	 }
	 }
}
public void efetuarLoginFuncionario () {
	 String login, senha;
	 login = teclado.lerTexto("Digite o login: "); 
	 senha = teclado.lerTexto("Digite a senha: ");
	 

	 if (funcionarioGlobal !=null) {
		 logado = funcionarioGlobal.validarLogin(login,senha);
		 if(logado) {
		 System.out.println("Login efetuado com sucesso.");
		 
	 }else {
		 System.out.println("Login ou senha inválido.");
		 efetuarLoginCliente();
	 }
	 }
}
public void cadastrarUsuarioCliente(){

	System.out.println("=================================================");
	System.out.println(" InfoNote - Cadastro de Usuários. ");
	System.out.println("=================================================");

	String login = teclado.lerTexto("Login: ");
	String senha = teclado.lerTexto("Senha: ");
	if (senha.equals("") || senha == null){
		senha = GerarSenha.gerarSenha();
		System.out.println("Senha gerada: " + senha);
		}
	String nome = teclado.lerTexto("Nome: ");
	String email = teclado.lerTexto("E-mail: ");
	String telefone = teclado.lerTexto("Telefone: ");
	String codigoCliente = teclado.lerTexto("codigoCliente: ");
	 String logradouro= teclado.lerTexto("logradouro: ");
	 String numero=teclado.lerTexto("numero: ");
	 String complemento=teclado.lerTexto("complemento: ");
	 String bairro=teclado.lerTexto("bairro: ");
	 String cidade=teclado.lerTexto("cidade: ");
	 String estado=teclado.lerTexto("estado: ");
	 String cep=teclado.lerTexto("cep: ");
	int tipo=1;
	 String numeroPedido = teclado.lerTexto("numeroPedido");
	 String dataEmissao=teclado.lerTexto("dataEmissao: ");
	 String formaDePagamento=teclado.lerTexto("formaDePagamento : ");
	double valorTotal=teclado.lerDouble(2500);
	 String situacao=teclado.lerTexto("situacao: ");
	 
	Endereco enderecos = new Endereco ( logradouro, numero, complemento, bairro, cidade,estado, cep);
	Pedido pedidos = new Pedido (numeroPedido, dataEmissao,formaDePagamento,valorTotal,situacao, enderecos);
	Cliente user1 = new Cliente (senha,  login,  tipo, nome, email,  telefone,  enderecos, pedidos,codigoCliente);
	clienteGlobal = user1;
	
	System.out.println("=================================================");
	System.out.println(" Usuário Cadastrado Com Sucesso. ");
	System.out.println("=================================================");
	System.out.println(user1);
}
public void cadastrarUsuarioFuncionario(){

	System.out.println("=================================================");
	System.out.println(" InfoNote - Cadastro de Usuários. ");
	System.out.println("=================================================");

	String matricula = teclado.lerTexto("Matrícula: ");
	String login = teclado.lerTexto("Login: ");
	String senha = teclado.lerTexto("Senha: ");
	if (senha.equals("") || senha == null){
		senha = GerarSenha.gerarSenha();
		System.out.println("Senha gerada: " + senha);
		}
	int tipo=2;
	user2 = new Funcionario( senha,  login,  tipo, matricula);
	funcionarioGlobal = user2;
	System.out.println("=================================================");
	System.out.println(" Usuário Cadastrado Com Sucesso. ");
	System.out.println("=================================================");
	System.out.println(user2);
}

public void buscarNotebook() {

	for (int i = 0; i < notebooks.length; i++){

		if(notebooks[i] != null){

			System.out.println(notebooks[i].getNumeroNote()+"-----"+

					notebooks[i].getModelo());
}
     }
             }

@SuppressWarnings("unlikely-arg-type")
public void inserirNotebook(){
	
	String numeroNote = teclado.lerTexto("Informe o número do notebook para compra: ");

	if (pedido == null) {
	 pedido = new Pedido();
}

	Notebook aux = null;
	for (int i = 0; i < notebooks.length; i++){
	if (notebooks[i] != null &&
	numeroNote.equals(notebooks[i].getNumeroNote())){
	aux = notebooks[i];
}
}
	
	if (aux == null){
	return;
}
	
	ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);
	
	 pedido.inserirItem(item);
}
public void manterCarrinho() {

	System.out.println("manterCarrinho - Em Construção");
}
public void efetuarCompra() {

	System.out.println("efetuarCompra - Em Construção");
}


public static void main(String[] args) throws Exception{
		
  
	InfoNote info = new InfoNote();
	int opcao =sair ;
	do {
	info.mostrarMenu();
	opcao = teclado.lerInt("Digite sua opção: ");
	
	switch (opcao) {
	case login :
				
		int tipoLogin = teclado.lerInt("Qual seu tipo de Usuário?: "+"\n"+"1-Cliente"+" \n"+"2-Funcionário");
		if(tipoLogin==1){
		info.efetuarLoginCliente();
		break;
		}else {
			info.efetuarLoginFuncionario();
		break;
		}
		
	case cadastrar_usuario:
		int tipoCad = teclado.lerInt("Qual seu tipo de Usuário?: "+"\n"+"1-Cliente"+" \n"+"2-Funcionário");
		
		if(tipoCad==1){
		info.cadastrarUsuarioCliente();
		break;
		}//else {
	//info.cadastrarUsuarioFuncionario();
		//break;
		//}
	
	case buscar_usuario:
		info.buscarNotebook();
		break;
	case inserir_notebook:
		info.manterCarrinho();
		break;	
	case remover_notebook:
		info.manterCarrinho();
		break;
	case ver_carrinho:
		info.manterCarrinho();
		break;
	case efetuar_compra:
		if (!info.logado) {
			System.out.println("Efetue login para efetuar compra.");
				break;
		}else {
			info.efetuarCompra();
			break;
		}
	case ajuda1:
		info.ajuda();
		break;

	case sair:
		System.out.println("Saída do Sistema");
		break;
		
		default:
			System.out.println("Opção inválida!");
	}
	teclado.lerTexto("Pressione uma tecla para continuar...");
           }  while(opcao!= sair);
	

	}

}
