package bean;

import java.sql.Date;
import java.util.ArrayList;

public class Juridica extends Cliente{
	//Atributos
	protected String CNPJ;
	/*------------------------------------------------------------------------------------------------*/

	//Construtor
	public Juridica(String nome, String email, String rg, int codigo, String data_nasc, String cep, String rua,
			String bairro, int num, String cNPJ) {
		super(nome, email, rg, codigo, data_nasc, cep, rua, bairro, num);
		CNPJ = cNPJ;
	}
	
	//Construtor cnpj + codigo
	public Juridica(String cNPJ, int codigo) {
		super(codigo);
		CNPJ = cNPJ;
		
	}
	/*------------------------------------------------------------------------------------------------*/

	//toString
	@Override
	public String toString() {
		return "Juridica [CNPJ=" + CNPJ + ", nome=" + nome + ", email=" + email + ", tel=" + tel + ", rg=" + rg
				+ ", codigo=" + codigo + ", data_nasc=" + data_nasc + ", cep=" + cep + ", rua=" + rua + ", bairro="
				+ bairro + ", num=" + num + "]";
	}
	/*------------------------------------------------------------------------------------------------*/

	//Gets and setters
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	//metodos

}
