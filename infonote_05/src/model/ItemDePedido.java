package model;

public class ItemDePedido {
	private int qtde;
	private double subtotal;

	private Notebook notebook;
	
	
	
	public Notebook getNotebook() {
		return notebook;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public ItemDePedido() {
		// TODO Auto-generated constructor stub
	}

		

	public ItemDePedido(int qtde, double subtotal, Notebook notebook) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
		this.notebook = notebook;
	}

	@Override
	public String toString() {
		return "ItemDePedido [qtde=" + qtde + ", subtotal=" + subtotal + "]";
	}
	public void mostrar(){
		//Mostrar usuário
		System.out.println("\n\nItem de pedido:\n");
		System.out.println("qtde: " +this.qtde  );
		System.out.println("subtotal: " +this.subtotal );
	
	}
}
