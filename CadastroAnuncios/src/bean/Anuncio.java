package bean;

public class Anuncio {
	Integer id;
	String nomeAnuncio;
	String cliente;
	String dataInicio;
	String dataTermino;
	Double investimento;
	
	public Anuncio(String na, String cl, String di, String dt, double inv){
		nomeAnuncio = na;
		cliente = cl;
		dataInicio = di;
		dataTermino = dt;
		investimento = inv;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public Anuncio() {
		
	}

	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Double getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Double investimento) {
		this.investimento = investimento;
	}

	
}

