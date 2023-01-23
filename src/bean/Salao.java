package bean;

import java.util.ArrayList;

public class Salao {
	//Atributos
	protected String nome;
	protected double preço;
	protected int quant_pessoas;
	protected int num_cadastro;
	protected String bairro;
	protected String cep;
	protected String rua;
	protected int num;
	protected String data;
	protected String hora;
	protected String tel;
	/*------------------------------------------------------------------------------------------------*/
	
	//construtor
	
	public Salao(String nome, double preço, int quant_pessoas, int num_cadastro, String bairro, String cep,
			String rua, int num, String data, String hora) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.quant_pessoas = quant_pessoas;
		this.num_cadastro = num_cadastro;
		this.bairro = bairro;
		this.cep = cep;
		this.rua = rua;
		this.num = num;
		this.data = data;
		this.hora = hora;
	}
	
	//construtor para insert
	public Salao(int num_cadastro, String tel) {
		super();
		this.num_cadastro = num_cadastro;
		this.tel = tel;
	}

	//construtor vazio
	public Salao() {
		super();
	}
	
	//construtor teste
	public Salao(int num_cadastro) {
		super();
		this.num_cadastro = num_cadastro;
	}
	
	//Construtor sem hora
	public Salao(String nome, double preço, int quant_pessoas, int num_cadastro, String bairro, String cep, String rua,
			String data) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.quant_pessoas = quant_pessoas;
		this.num_cadastro = num_cadastro;
		this.bairro = bairro;
		this.cep = cep;
		this.rua = rua;
		this.data = data;
	}
	
	//Construtor sem data e hora
	public Salao(String nome, double preço, int quant_pessoas, int num_cadastro, String bairro, String cep, String rua,
			int num) {
		super();
		this.nome = nome;
		this.preço = preço;
		this.quant_pessoas = quant_pessoas;
		this.num_cadastro = num_cadastro;
		this.bairro = bairro;
		this.cep = cep;
		this.rua = rua;
		this.num = num;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//toString
	@Override
	public String toString() {
		return "Salao [nome=" + nome + ", preço=" + preço + ", quant_pessoas=" + quant_pessoas + ", num_cadastro="
				+ num_cadastro + ", bairro=" + bairro + ", cep=" + cep + ", rua=" + rua + ", num=" + num + ", data="
				+ data + ", hora=" + hora + "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	//gets and setters 
	public String getNome() {
		return nome;
	}

	public double getPreço() {
		return preço;
	}

	public int getQuant_pessoas() {
		return quant_pessoas;
	}

	public int getNum_cadastro() {
		return num_cadastro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public int getNum() {
		return num;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreço(double preço) {
		this.preço = preço;
	}

	public void setQuant_pessoas(int quant_pessoas) {
		this.quant_pessoas = quant_pessoas;
	}

	public void setNum_cadastro(int num_cadastro) {
		this.num_cadastro = num_cadastro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	/*------------------------------------------------------------------------------------------------*/
	
	//metodos
	
}
