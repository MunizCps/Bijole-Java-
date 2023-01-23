package bean;

public class ListaDeDesejos {
	//Atributos
	protected int id; 
	protected int quant_pessoas;
	protected String tipo_Decora�ao;
	protected double or�amento;
	protected String tamanho_salao ;
	protected String cardapio_buffet;
	protected int codigoclie;
	protected int protocoloceri;
	protected String data;
	protected String hora;
	/*------------------------------------------------------------------------------------------------*/

	//construtor
	public ListaDeDesejos(int id, int quant_pessoas, String tipo_Decora�ao, double or�amento, String tamanho_salao,
			String cardapio_buffet) {
		super();
		this.id = id;
		this.quant_pessoas = quant_pessoas;
		this.tipo_Decora�ao = tipo_Decora�ao;
		this.or�amento = or�amento;
		this.tamanho_salao = tamanho_salao;
		this.cardapio_buffet = cardapio_buffet;
	}

	//construtor vazio
	public ListaDeDesejos() {
		super();
	}
	
	//construtor 2
		public ListaDeDesejos(int id, int quant_pessoas, String tipo_Decora�ao, double or�amento, String tamanho_salao,
				String cardapio_buffet, int codigoclie, int protocoloceri, String data, String hora) {
			super();
			this.id = id;
			this.quant_pessoas = quant_pessoas;
			this.tipo_Decora�ao = tipo_Decora�ao;
			this.or�amento = or�amento;
			this.tamanho_salao = tamanho_salao;
			this.cardapio_buffet = cardapio_buffet;
			this.codigoclie = codigoclie;
			this.protocoloceri = protocoloceri;
			this.data = data;
			this.hora = hora;
		}
	/*------------------------------------------------------------------------------------------------*/
	
	//toString
	@Override
	public String toString() {
		return "ListaDeDesejos [id=" + id + ", quant_pessoas=" + quant_pessoas + ", tipo_Decora�ao=" + tipo_Decora�ao
				+ ", or�amento=" + or�amento + ", tamanho_salao=" + tamanho_salao + ", cardapio_buffet="
				+ cardapio_buffet + ", codigoclie=" + codigoclie + ", protocoloceri=" + protocoloceri + ", data=" + data
				+ ", hora=" + hora + "]";
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//gets and setters
	public int getId() {
		return id;
	}

	public int getQuant_pessoas() {
		return quant_pessoas;
	}

	public String getTipo_Decora�ao() {
		return tipo_Decora�ao;
	}

	public double getOr�amento() {
		return or�amento;
	}

	public String getTamanho_salao() {
		return tamanho_salao;
	}

	public String getCardapio_buffet() {
		return cardapio_buffet;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuant_pessoas(int quant_pessoas) {
		this.quant_pessoas = quant_pessoas;
	}

	public void setTipo_Decora�ao(String tipo_Decora�ao) {
		this.tipo_Decora�ao = tipo_Decora�ao;
	}

	public void setOr�amento(double or�amento) {
		this.or�amento = or�amento;
	}

	public void setTamanho_salao(String tamanho_salao) {
		this.tamanho_salao = tamanho_salao;
	}

	public void setCardapio_buffet(String cardapio_buffet) {
		this.cardapio_buffet = cardapio_buffet;
	}

	public int getCodigoclie() {
		return codigoclie;
	}

	public int getProtocoloceri() {
		return protocoloceri;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public void setCodigoclie(int codigoclie) {
		this.codigoclie = codigoclie;
	}

	public void setProtocoloceri(int protocoloceri) {
		this.protocoloceri = protocoloceri;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	/*------------------------------------------------------------------------------------------------*/

	//metodos
	
}
