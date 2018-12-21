package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import model.*;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import model.DAO.NotebookDAO;
import model.DAO.UsuarioDAO;
import util.*;


public class InfoNote {

	Usuario usuario;
	Cliente user1;
	Funcionario user2;
	Notebook[] notebooks = new Notebook[10];
	Pedido pedido;
	boolean logado = false;
	Configurador config;
	Ajuda ajuda;


	private static final int login = 1;
	private static final int cadastrar_usuario = 2;
	private static final int buscar_notebook = 3;
	private static final int inserir_notebook = 4;
	private static final int remover_notebook = 5;
	private static final int ver_carrinho = 6;
	private static final int efetuar_compra = 7;
	private static final int ajuda1 = 8;
	private static final int AREA_ADMINISTRATIVA = 9;
	private static final int sair = 10;

	public InfoNote() {

		config = new Configurador();
		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
		ajuda = new Ajuda(config.getArquivoAjuda());

		notebooks[0] = new Notebook( "1","Negativo N22BR", "CPU Intel Core 2 Duo, Memória 2 GB, HD 250 GB", 6, 1200.00,
				"img\\n22br.jpg", "19/05/2011");
		notebooks[1] = new Notebook("2", "Bell B55BR", "CPU Intel I3, Memória 4 GB, HD 500 GB", 3, 1800.00,
				"img\\b55br.jpg", "20/05/2011");
		notebooks[2] = new Notebook("3", "Pompaq P41BR", "CPU Intel I3, Memória 3 GB, HD 320 GB", 1, 1600.00,
				"img\\p41br.jpg", "21/05/2011");
		notebooks[3] = new Notebook("4", "CCF CR71CH", "CPU Intel Dual Core, Memória 2 GB, HD 160 GB", 5, 1100.00,
				"img\\cr71ch.jpg", "10/06/2011");
		notebooks[4] = new Notebook( "5","BradescoTech BD22BR", "CPU AMD Phenon II, Memória 4 GB, HD 500 GB", 2, 1900.00,
				"img\\bd22br.jpg", "10/06/2011");
	}

	
	

	public void mostrarMenu() {

		System.out.println("=================================================");
		System.out.println(" InfoNote - Se não é Info não vendemos. "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));

		if (logado == true) {
			System.out.println("Seja bem vindo, " + user1.getNomeInvertido());
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
		System.out.println("9 - Área Administrativa");
		System.out.println("10 - Sair");

	}

	public void efetuarLogin() {
		String login, senha;
		login = teclado.lerTexto("Digite o login: ");
		senha = teclado.lerTexto("Digite a senha: ");

		user1 = ClienteDAO.buscarPorLoginSenha(login, senha);

		if (user1 != null) {
			logado = user1.validarLogin(login, senha);
		}else {
				if (logado) {
		
					System.out.println("Login efetuado com sucesso.");
			
			} else {
				System.out.println("Login ou senha inválido.");
				int opcao2 = 3;
				
				do {
					System.out.println("Digite:");
					System.out.println("1 - Para efetuar Login");
					System.out.println("2 - Para cadastrar-se");
					System.out.println("3 - Para sair do sistema");
					opcao2 = teclado.lerInt("");
					switch (opcao2) {
					case 1:
						efetuarLogin();
						break;
					case 2:
						cadastrarUsuarioCliente();
						break;
					case 3:
						System.out.println("Obrigado e volte sempre!");
						break;
					default:
						System.out.println("Opção inválida");
					}
				} while (!logado);
			}
		}
	}
	

	public void efetuarLoginadm() {
		String login, senha;
		login = teclado.lerTexto("Digite o login: ");
		senha = teclado.lerTexto("Digite a senha: ");
		user2 = FuncionarioDAO.buscarPorLoginSenha(login, senha);

		if (user2 != null) {
			logado = user2.validarLogin(login, senha);
		}else {
			if (logado) {
				System.out.println("Login efetuado com sucesso.");

			} else {
				System.out.println("Login ou senha inválido.");
				efetuarLogin();
			}
		}
	}

	
	public void ajuda() {
		System.out.println(ajuda.getTexto());
	}
	
	
	public void cadastrarUsuarioCliente() {

		System.out.println("=================================================");
		System.out.println(" InfoNote - Cadastro de Usuários. ");
		System.out.println("=================================================");

		String login = teclado.lerTexto("Login: ");
		String senha = teclado.lerTexto("Senha: ");
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}
		int tipo = 0;
		String nome = teclado.lerTexto("Nome: ");
		String email = teclado.lerTexto("E-mail: ");
		String telefone = teclado.lerTexto("Telefone: ");
		String codigoCliente = teclado.lerTexto("codigoCliente: ");
		String logradouro = teclado.lerTexto("logradouro: ");
		String numero = teclado.lerTexto("numero: ");
		String complemento = teclado.lerTexto("complemento: ");
		String bairro = teclado.lerTexto("bairro: ");
		String cidade = teclado.lerTexto("cidade: ");
		String estado = teclado.lerTexto("estado: ");
		String cep = teclado.lerTexto("cep: ");
		
		usuario = UsuarioDAO.inserir(login, senha, tipo);
		user1 = ClienteDAO.inserir(login, senha, tipo, codigoCliente, nome, email, telefone);
		Endereco endereco = EnderecoDAO.inserir(logradouro, numero, complemento, bairro, cidade, estado, cep,
				codigoCliente);
		

		System.out.println("=================================================");
		System.out.println(" Usuário Cadastrado Com Sucesso. ");
		System.out.println("=================================================");
		System.out.println(user1);
		System.out.println(endereco);
	}

	public void cadastrarUsuarioFuncionario() {

		System.out.println("=================================================");
		System.out.println(" InfoNote - Cadastro de Usuários. ");
		System.out.println("=================================================");

		String matricula = teclado.lerTexto("Matrícula: ");
		String login = teclado.lerTexto("Login: ");
		String senha = teclado.lerTexto("Senha: ");
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}
		int tipo = 1;
		user2 = new Funcionario(senha, login, tipo, matricula);
		System.out.println("=================================================");
		System.out.println(" Usuário Cadastrado Com Sucesso. ");
		System.out.println("=================================================");
		System.out.println(user2);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public void buscarNotebook() {

		for (int i = 0; i < notebooks.length; i++) {

			if (notebooks[i] != null) {

				System.out.println(notebooks[i].getNumeroNote() + "-----" +

						notebooks[i].getModelo());
			}
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public void inserirNotebook() {

		String numeroNote = teclado.lerTexto("Informe o número do notebook para compra: ");

		if (pedido == null) {
			pedido = new Pedido();
		}

		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getNumeroNote())) {
				aux = notebooks[i];
			}
		}

		if (aux == null) {
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
	public void areaAdministrativa(){
		InfoNote info = new InfoNote();
		efetuarLoginadm();
		System.out.println("Opções Administrativas\n");
		System.out.println("1 - Cadastrar Notebook");
		System.out.println("2 - Mostrar Notebooks");
		System.out.println("3 - Editar Notebook");
		System.out.println("4 - Excluir Notebook");
		System.out.println("5 - Sair");
		int opcao = 5;
		do {
		opcao = teclado.lerInt("Digite sua opção: ");
		switch (opcao) {
		case 1:
		info.cadastrarNotebook();
		break;
		case 2:
		info.mostrarNotebooks();
		break;
		case 3:
		info.editarNotebook();
		break;
		case 4:
		info.excluirNotebook();
		break;
		case 5:
		System.out.println("Saída do Sistema");
		break;
		default:
		System.out.println("Opção inválida!");
		}
		teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != 5);
		}


	private void cadastrarNotebook() {
		System.out.println("====================================");
		System.out.println(" Cadastro de Notebook ");
		System.out.println("====================================");
		String serialNote = teclado.lerTexto("SeriaNote: ");
		String modelo = teclado.lerTexto("Modelo: ");
		String descricao = teclado.lerTexto("Descricao: ");
		int estoque = teclado.lerInt("Estoque: ");
		double precoUnitario = teclado.lerDouble("Preço Unitário: ");
		String figura = teclado.lerTexto("Figura: ");
		String dataCadastro = teclado.lerTexto("Data de Cadastro: ");
		
		Notebook notebook = NotebookDAO.inserir( serialNote,  modelo, descricao,  estoque,  precoUnitario, figura,
				 dataCadastro );
		System.out.println(notebook);
		
	}

	private void mostrarNotebooks() {
		Notebook[] notebook = NotebookDAO.buscarTodos();
		for (int i = 0; i < notebook.length; i++) {
			if (notebook[i] != null) {
				System.out.println(notebook[i].getSerialNote() + "-----"
						+ notebook[i].getModelo() + "-----" + notebook[i].getDescricao() + "-----"
						+ notebook[i].getEstoque() + "-----" + notebook[i].getPrecoUnitario()	);
			}
		}
		
	}

	private void editarNotebook() {
		// TODO Auto-generated method stub
		
	}

	private void excluirNotebook() {
		System.out.println("====================================");
		System.out.println(" Excluir de Notebook ");
		System.out.println("====================================");
		String serialNote = teclado.lerTexto("Informe o SeriaNote do Notebook a ser excluido: ");
		
		Notebook notebook = NotebookDAO.excluir(serialNote);
		
	}

	public static void main(String[] args) {

		InfoNote info = new InfoNote();
		int opcao = sair;
		do {
			info.mostrarMenu();
			opcao = teclado.lerInt("Digite sua opção: ");

			switch (opcao) {
			case login:

				int tipoLogin = teclado.lerInt("Qual seu tipo de Usuário?: " + "\n" + "1-Cliente" + " \n" + "2-Funcionário");
				if (tipoLogin == 1) {
					info.efetuarLogin();
					break;
				} else {
					info.efetuarLoginadm();
					break;
				}

			case cadastrar_usuario:
				int tipoCad = teclado
						.lerInt("Qual seu tipo de Usuário?: " + "\n" + "1-Cliente" + " \n" + "2-Funcionário");

				if (tipoCad == 1) {
					info.cadastrarUsuarioCliente();
					break;
				} // else {
				// info.cadastrarUsuarioFuncionario();
				// break;
				// }

			case buscar_notebook:
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
				} else {
					info.efetuarCompra();
					break;
				}
			case ajuda1:
				info.ajuda();
				break;
			case AREA_ADMINISTRATIVA:
				info.areaAdministrativa();
				break;
				
			case sair:
				System.out.println("Saída do Sistema");
				break;

			default:
				System.out.println("Opção inválida!");
			}
			teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != sair);

	}

}
