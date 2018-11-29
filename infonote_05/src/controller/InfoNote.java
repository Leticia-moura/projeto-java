package controller;

import model.*;
import util.teclado;


public class InfoNote {

	
		Usuario user;
		
		Notebook[] notebooks= new Notebook[10];
		
		Pedido pedido;
		
		boolean logado = false;

	
public InfoNote() {
	notebooks[0] = new Notebook(1, "Negativo N22BR",
			"CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB",6 ,1200.00,
			"img\\n22br.jpg","19/05/2011");
	notebooks[1] = new Notebook(2, "Negativo N22BR",
			"CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB",4 ,1200.00,
			"img\\n22br.jpg","19/05/2011");
	notebooks[2] = new Notebook(3, "Negativo N22BR",
			"CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB",10 ,1200.00,
			"img\\n22br.jpg","19/05/2011");
	notebooks[3] = new Notebook(4, "Negativo N22BR",
			"CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB",25,1200.00,
			"img\\n22br.jpg","19/05/2011");
	notebooks[4] = new Notebook(5, "Negativo N22BR",
			"CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB",61,1200.00,
			"img\\n22br.jpg","19/05/2011");
	
}		
		
public void mostrarMenu() {
	
	System.out.println("=================================================");
	System.out.println(" InfoNote - Se não é Info não vendemos. ");
	System.out.println("=================================================");
	System.out.println("1 - Login");
	System.out.println("2 - Cadastrar Cliente");
	System.out.println("3 - Buscar Notebook");
	System.out.println("4 - Inserir Notebook no carrinho");
	System.out.println("5 - Remover Notebook no carrinho");
	System.out.println("6 - Ver Carrinho");
	System.out.println("7 - Efetuar Compra");
	System.out.println("8 - Sair");

	
}

public void efetuarLogin () {
	 String login, senha;
	 login = teclado.lerTexto("Digite o login: "); 
	 senha = teclado.lerTexto("Digite a senha: ");
	 
	 if (login.equals("admin") && senha.equals("1234")) {
		 System.out.println("Login efetuado com sucesso.");
		 logado = true;
	 }else {
		 System.out.println("Login ou senha inválido.");
		 efetuarLogin();
	 
	 }
}
public void cadastrarUsuario(){

	System.out.println("=================================================");
	System.out.println(" InfoNote - Cadastro de Usuários. ");
	System.out.println("=================================================");

	int matricula = teclado.lerInt("Matrícula: ");
	String login = teclado.lerTexto("Login: ");
	String senha = teclado.lerTexto("Senha: ");
	String nome = teclado.lerTexto("Nome: ");
	String email = teclado.lerTexto("E-mail: ");
	String telefone = teclado.lerTexto("Telefone: ");
	user = new Usuario(senha, login, nome, email, telefone,  matricula);

	System.out.println("=================================================");
	System.out.println(" Usuário Cadastrado Com Sucesso. ");
	System.out.println("=================================================");
	System.out.println(user);
}
public void buscarNotebook() {

	for (int i = 0; i < notebooks.length; i++){

		if(notebooks[i] != null){

			System.out.println(notebooks[i].getNumeroNote()+"-----"+

					notebooks[i].getModelo());
}
     }
             }

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

public static void main(String[] args) {
		// TODO Auto-generated method stub
  
	InfoNote info = new InfoNote();
	int opcao = 8 ;
	do {
	info.mostrarMenu();
	opcao = teclado.lerInt("Digite sua opção: ");
	
	switch (opcao) {
	case 1 :
		info.efetuarLogin();
		break;
	case 2 :
		info.cadastrarUsuario();
		break;
	case 3:
		info.buscarNotebook();
		break;
	case 4:
		info.manterCarrinho();
		break;	
	case 5:
		info.manterCarrinho();
		break;
	case 6:
		info.manterCarrinho();
		break;
	case 7:
		if (!info.logado) {
			System.out.println("Efetue login para efetuar compra.");
				break;
		}else {
			info.efetuarCompra();
			break;
		}
	case 8:
		System.out.println("Saída do Sistema");
		break;
		
		default:
			System.out.println("Opção inválida!");
	}
	
}while(opcao!=8);
	
	teclado.lerTexto("Pressione uma tecla para continuar...");


	}

}
