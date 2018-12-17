package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import model.*;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
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

	private static Cliente clienteGlobal = null;
	private static Funcionario funcionarioGlobal = null;
	private static final int login = 1;
	private static final int cadastrar_usuario = 2;
	private static final int buscar_usuario = 3;
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

	}

	public void ajuda() {
		System.out.println(ajuda.getTexto());
	}

	public void mostrarMenu() {

		System.out.println("=================================================");
		System.out.println(" InfoNote - Se não é Info não vendemos. "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));

		if (logado == true) {
			System.out.println("Seja bem vindo, " + clienteGlobal.getNomeInvertido());
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

		clienteGlobal = ClienteDAO.buscarPorLoginSenha(login, senha);

		if (clienteGlobal != null) {
			logado = clienteGlobal.validarLogin(login, senha);
		} else {
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
		funcionarioGlobal = FuncionarioDAO.buscarPorLoginSenha(login, senha);

		if (funcionarioGlobal != null) {
			logado = funcionarioGlobal.validarLogin(login, senha);
		}else {
			if (logado) {
				System.out.println("Login efetuado com sucesso.");

			} else {
				System.out.println("Login ou senha inválido.");
				efetuarLogin();
			}
		}
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
		int tipo = 0;
		String numeroPedido = teclado.lerTexto("numeroPedido");
		String dataEmissao = teclado.lerTexto("dataEmissao: ");
		String formaDePagamento = teclado.lerTexto("formaDePagamento : ");
		double valorTotal = teclado.lerDouble(2500);
		String situacao = teclado.lerTexto("situacao: ");

		usuario = UsuarioDAO.inserir(login, senha, tipo);
		user1 = ClienteDAO.inserir(login, senha, tipo, codigoCliente, nome, email, telefone);
		Endereco endereco = EnderecoDAO.inserir(logradouro, numero, complemento, bairro, cidade, estado, cep,
				codigoCliente);

		// Endereco enderecos = new Endereco ( logradouro, numero, complemento, bairro,
		// cidade,estado, cep);
		// Pedido pedidos = new Pedido (numeroPedido,
		// dataEmissao,formaDePagamento,valorTotal,situacao, enderecos);
		// Cliente user1 = new Cliente (senha, login, tipo, nome, email, telefone,
		// enderecos, pedidos,codigoCliente);
		clienteGlobal = user1;

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
		int tipo = 2;
		user2 = new Funcionario(senha, login, tipo, matricula);
		funcionarioGlobal = user2;
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
		// TODO Auto-generated method stub
		
	}

	private void mostrarNotebooks() {
		// TODO Auto-generated method stub
		
	}

	private void editarNotebook() {
		// TODO Auto-generated method stub
		
	}

	private void excluirNotebook() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {

		InfoNote info = new InfoNote();
		int opcao = sair;
		do {
			info.mostrarMenu();
			opcao = teclado.lerInt("Digite sua opção: ");

			switch (opcao) {
			case login:

				int tipoLogin = teclado
						.lerInt("Qual seu tipo de Usuário?: " + "\n" + "1-Cliente" + " \n" + "2-Funcionário");
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
