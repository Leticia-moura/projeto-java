package model;

public class ItemDePedido {
	private int qtde;
	private double subtotal;

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

	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
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
