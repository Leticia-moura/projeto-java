package model;

public class Notebook {
	int numeroNote;
	String modelo;
	String descricao;
	int estoque;
	double precoUnitario;
	String figura;
	String dataCadastro;
	

	public int getNumeroNote() {
		return numeroNote;
	}


	public void setNumeroNote(int numeroNote) {
		this.numeroNote = numeroNote;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public double getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


	public String getFigura() {
		return figura;
	}


	public void setFigura(String figura) {
		this.figura = figura;
	}


	public String getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public Notebook() {
		// TODO Auto-generated constructor stub
	}


	public Notebook(int numeroNote, String modelo, String descricao, int estoque, double precoUnitario, String figura,
			String dataCadastro) {
		super();
		this.numeroNote = numeroNote;
		this.modelo = modelo;
		this.descricao = descricao;
		this.estoque = estoque;
		this.precoUnitario = precoUnitario;
		this.figura = figura;
		this.dataCadastro = dataCadastro;
	}


	@Override
	public String toString() {
		return "Notebook [numeroNote=" + numeroNote + ", modelo=" + modelo + ", descricao=" + descricao + ", estoque="
				+ estoque + ", precoUnitario=" + precoUnitario + ", figura=" + figura + ", dataCadastro=" + dataCadastro
				+ "]";
	}
	public void mostrar(){
	System.out.println("\n\nNotebook:\n");
	System.out.println("figura: " + this.figura);
	System.out.println("descricao: " + this.descricao);
	System.out.println("modelo: " +this.modelo );
	System.out.println("precoUnitario: " + this.precoUnitario);
	System.out.println("numeroNote: " + this.numeroNote);
	System.out.println("estoque: " + this.estoque);
	System.out.println("dataCadastro: " + this.dataCadastro);
	 
	}
}
