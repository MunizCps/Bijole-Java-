package bean;

import java.sql.Date;
import java.util.ArrayList;

public class Fisica extends Cliente {
	//Atributos
	protected String CPF;
	/*------------------------------------------------------------------------------------------------*/
	
	//construtor
	public Fisica(String nome, String email, String rg, int codigo, String data_nasc, String cep, String rua,
			String bairro, int num, String cPF) {
		super(nome, email, rg, codigo, data_nasc, cep, rua, bairro, num);
		CPF = cPF;
	}
	
	//Construtor cpf + codigo
	public Fisica(String cPF, int codigo) {
		super(codigo);
		CPF = cPF;
	}
	/*------------------------------------------------------------------------------------------------*/

	//To String
	@Override
	public String toString() {
		return "Fisica [CPF=" + CPF + ", nome=" + nome + ", email=" + email + ", tel=" + tel + ", rg=" + rg
				+ ", codigo=" + codigo + ", data_nasc=" + data_nasc + ", cep=" + cep + ", rua=" + rua + ", bairro="
				+ bairro + ", num=" + num + "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	//Gets and setters
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	//Metodos
	
}
