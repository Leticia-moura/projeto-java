package model;

public class Pedido {
	private int numero;
	private String dataEmissao;
	private String formaDePagamento;
	private double valorTotal;
	private String situacao;

	private Endereco enderecoEntrega;
	private ItemDePedido itens[] = new ItemDePedido[10];;
	
	
	
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}
	

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}


	public ItemDePedido[] getItens() {
		return itens;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(int numero, String dataEmissao, String formaDePagamento, double valorTotal, String situacao) {
		super();
		this.numero = numero;
		this.dataEmissao = dataEmissao;
		this.formaDePagamento = formaDePagamento;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", dataEmissao=" + dataEmissao + ", formaDePagamento=" + formaDePagamento
				+ ", valorTotal=" + valorTotal + ", situacao=" + situacao + "]";
	}
	
	public boolean inserirItem(ItemDePedido item){
		for (int i = 0; i < itens.length; i++){
		if (itens[i] == null){
		itens[i] = item;
		return true;
	}

		}
		return false;
		
	}
	
	public void mostrar() {
		System.out.println("\n\nPedido:\n");
		System.out.println("N�mero: " + this.numero);
		System.out.println("Data da emissao: " + this.dataEmissao);
		System.out.println("Forma de pagamento: " + this.formaDePagamento);
		System.out.println("situacao: " + this.situacao);
		System.out.println("Valor Total: " + this.valorTotal);
		System.out.println("    ");
		System.out.println("\n\nItens do Pedido:\n");
		for (int i= 0;i<itens.length; i++) {
			if(itens[i]  !=null) {
				itens[i].mostrar();
			}
		}

		
	}
}
