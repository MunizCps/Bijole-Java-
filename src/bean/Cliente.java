package bean;

import java.sql.Date;
import java.util.ArrayList;


public class Cliente {
	//Atributos
	protected String nome;
	protected String email;
	protected String rg;
	protected int codigo;
	protected String data_nasc;
	protected String cep;
	protected String rua;
	protected String bairro;
	protected int num;
	protected String cpf;
	protected ArrayList <Cliente> telefones = new ArrayList<>();
	protected String tel;
	protected String senha;
	/*------------------------------------------------------------------------------------------------*/

	
	//Construtor vazio
	public Cliente() {
		
	}
	
	
	//construtor com senha
	public Cliente(String nome, String email, String rg, int codigo, String data_nasc, String cep, String rua,
			String bairro, int num,String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.codigo = codigo;
		this.data_nasc = data_nasc;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.num = num;
		this.senha = senha;
	}



	//Construtor
	public Cliente(String nome, String email, String rg, String data_nasc, String cep, String rua,
			String bairro, int num,int codigo) {
		super();
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.data_nasc = data_nasc;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.num = num;
		this.codigo = codigo;
		
	}
	
	//Construtor
	public Cliente(String nome, String email, String rg, int codigo, String data_nasc, String cep, String rua,
			String bairro, int num) {
		super();
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.codigo = codigo;
		this.data_nasc = data_nasc;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.num = num;
		
	}
	
	//construtor teste
	public Cliente(int codigo) {
		super();
		this.codigo = codigo;
	}

	//Construtor telefone
	public Cliente(int codigo, String tel) {
		super();
		this.codigo = codigo;
		this.tel = tel;
	}

	/*------------------------------------------------------------------------------------------------*/
	//tostring
		@Override
		public String toString() {
			return "Cliente [nome=" + nome + ", email=" + email + ", rg=" + rg + ", codigo=" + codigo + ", data_nasc="
					+ data_nasc + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", num=" + num + ", cpf=" + cpf
					+ ", telefones=" + telefones + ", tel=" + tel + ", senha=" + senha + "]";
		}

	
	/*------------------------------------------------------------------------------------------------*/
	
	//Gets and setters
	public String getNome() {
		return nome;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data) {
		this.data_nasc = data;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setTelefones(ArrayList<Cliente> telefones) {
		this.telefones = telefones;
	}

	//Métodos
	
	public void adicionaTel(Cliente cpf, Cliente tel) {
		if(telefones == null) {
			telefones = new ArrayList<>();
			
		}else {
			telefones.add(tel);
		}
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	/*------------------------------------------------------------------------------------------------*/
	
	//Funções extras que provavelmente não vou usar(Porém vou guardar para caso eu precise)
	
	//Telefone parte da função
	/*while (telefones.size() > 0){
	for(int i =0; i <telefones.size();i++) {
		 Cliente tel = telefones.get(i);
		 System.out.println(telefones);*/
		 
		/*System.out.println(c.getTel);
		stmt=connection.prepareStatement(sql);
		stmt.setString(1,c.getTel());
		stmt.close();
	}
	
}*/
	
	//Gets e setters antigo tel
	/*public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}*/
	
	
	
	
	
}
