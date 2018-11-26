package model;

public class ItemDePedido {
	int qtde;
	double subtotal;

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
}
