package controller;
import model.*;
public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario user= new Usuario();
		user.setNome("Jorge Sousa");
		user.setEmail("jorge@gmail.com");
		user.setTelefone("5555200");
		user.setMatricula(1234);
		user.setLogin("jorge.sousa");
		user.setSenha("5611428");
		System.out.println(user.toString());
		
		System.out.println("   ");
		
		Endereco end= new Endereco();
		end.setEstado("RJ");
		end.setBairro("tijuca");
		end.setCidade("RJ");
		end.setLogradouro("maria amalia");
		end.setNumero("26");
		end.setComplemento("apt 301");
		end.setCep("20510000");
		System.out.println(end.toString());
		
		System.out.println("   ");
		
		Notebook note1= new Notebook();
		note1.setDataCadastro("21/06/2018");
		note1.setDescricao("modelo novo do ano");
		note1.setEstoque(56);
		note1.setFigura("foto_note1");
		note1.setModelo("2018.0");
		note1.setNumeroNote(521647);
		note1.setPrecoUnitario(2500);
		System.out.println(note1.toString());
		
		System.out.println("   ");
				
		Notebook note2= new Notebook();
		note2.setDataCadastro("03/10/2018");
		note2.setDescricao("modelo do ano passado");
		note2.setEstoque(20);
		note2.setFigura("foto_note2");
		note2.setModelo("2017.5");
		note2.setNumeroNote(2654);
		note2.setPrecoUnitario(1400);
		System.out.println(note2.toString());
		
		System.out.println("   ");
		
		Notebook note3= new Notebook();
		note3.setDataCadastro("31/12/2018");
		note3.setDescricao("modelo novo do próximo ano");
		note3.setEstoque(100);
		note3.setFigura("foto_note3");
		note3.setModelo("2019.1");
		note3.setNumeroNote(1518);
		note3.setPrecoUnitario(3800);
		System.out.println(note3.toString());
		
		System.out.println("   ");
		
		Pedido ped= new Pedido();
		ped.setDataEmissao("23/11/2018");
		ped.setFormaDePagamento("boleto");
		ped.setNumero(588);
		ped.setSituacao("situacao");
		ped.setValorTotal(2789);
		System.out.println(ped.toString());
		
		System.out.println("   ");
		
		ItemDePedido Idp1 = new ItemDePedido ();
		Idp1.setQtde(2);
		Idp1.setSubtotal(22.98);
		System.out.println(Idp1.toString());
		
		System.out.println("   ");
		
		ItemDePedido Idp2 = new ItemDePedido ();
		Idp1.setQtde(1);
		Idp1.setSubtotal(98.75);
		System.out.println(Idp2.toString());
		
		System.out.println("   ");
		
	}

}
