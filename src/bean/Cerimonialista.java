package bean;

public class Cerimonialista {
	//Atributos
	protected int protocolo;
	protected String email;
	protected String cpf;
	protected String nome; 
	protected String tel;
	protected String senha;
	
/*------------------------------------------------------------------------------------------------*/
//Construtores
	
	//Construtor com senha
	public Cerimonialista(int protocolo, String email, String cpf, String nome, String senha) {
		super();
		this.protocolo = protocolo;
		this.email = email;
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
	}
	
	//construtor tel
	public Cerimonialista(int protocolo, String tel) {
		super();
		this.protocolo = protocolo;
		this.tel = tel;
	}

		

		//construtor 
		public Cerimonialista(int protocolo, String email, String cpf, String nome) {
			super();
			this.protocolo = protocolo;
			this.email = email;
			this.cpf = cpf;
			this.nome = nome;
		}
	
	//construtor vazio
	public Cerimonialista() {
		super();
	}
	
	
	
	
	/*------------------------------------------------------------------------------------------------*/
	
	//toString
	@Override
	public String toString() {
		return "Cerimonialista [protocolo=" + protocolo + ", email=" + email + ", cpf=" + cpf + ", nome=" + nome
				+ ", tel=" + tel + ", senha=" + senha + "]";
	}
	
	
	/*------------------------------------------------------------------------------------------------*/
	
	//gets and setters
	public String getNome() {
		return nome;
	}

	

	

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	//metodos
}
