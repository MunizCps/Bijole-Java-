package bean;

public class Encontro {
	//Atributos
	protected String data;
	protected String hora;
	protected int codigoclie;  
	protected int protocoloceri;
	


	protected int numcadastro;
	protected String senha;
	
	/*------------------------------------------------------------------------------------------------*/
	//Construtor cliente
	
	
	
	
	//construtor 2
	public Encontro(String data, String hora, int codigoclie, int protocoloceri, int numcadastro) {
		super();
		this.data = data;
		this.hora = hora;
		this.codigoclie = codigoclie;
		this.protocoloceri = protocoloceri;
		this.numcadastro = numcadastro;
	}
	
	
	public Encontro(String data, String hora, int codigoclie, int protocoloceri) {
		super();
		this.data = data;
		this.hora = hora;
		this.codigoclie = codigoclie;
		this.protocoloceri = protocoloceri;
	}
	
	
	public Encontro(int numcadastro,int protocoloceri, String data, String hora) {
		super();
		this.data = data;
		this.hora = hora;
		this.protocoloceri = protocoloceri;
		this.numcadastro = numcadastro;
	}
	
	
	public Encontro(int protocoloceri) {
		super();
		this.protocoloceri = protocoloceri;
	}


	//construtor
	public Encontro(String data, String hora) {
		super();
		this.data = data;
		this.hora = hora;
	}
	
	//construtor vazio
	public Encontro() {
		super();
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//toString
	@Override
	public String toString() {
		return "Encontro [data=" + data + ", hora=" + hora + ", codigoclie=" + codigoclie + ", protocoloceri="
				+ protocoloceri + ", numcadastro=" + numcadastro + ", senha=" + senha + "]";
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//gets and setters
	public String getData() {
		return data;
	}

	

	public String getHora() {
		return hora;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}


	public int getCodigoclie() {
		return codigoclie;
	}


	public int getProtocoloceri() {
		return protocoloceri;
	}

	public void setCodigoclie(int codigoclie) {
		this.codigoclie = codigoclie;
	}


	public void setProtocoloceri(int protocoloceri) {
		this.protocoloceri = protocoloceri;
	}


	public int getNumcadastro() {
		return numcadastro;
	}


	public void setNumcadastro(int numcadastro) {
		this.numcadastro = numcadastro;
	}
	
	//metodos
	
}
