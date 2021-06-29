package hotel;

public class Quarto {	
	String nomeHospede;
	Boolean status;// False: Disponivel  True: Alugado
	String tipo;
	int preco;
	
	
	public Quarto(String nomeHospede, Boolean status, String tipo, int preco) {
		super();
		this.nomeHospede = nomeHospede;
		this.status = status;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public Quarto() {
		super();
		this.nomeHospede = "";
		this.status = false;
		this.tipo = "";
		this.preco = 0;
	}


	public String getNomeHospede() {
		return nomeHospede;
	}


	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getPreco() {
		return preco;
	}


	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	

}
