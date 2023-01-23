package principal;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Cerimonialista;
import bean.Cliente;
import bean.Encontro;
import bean.Fisica;
import bean.Juridica;
import bean.ListaDeDesejos;
import bean.Salao;
import dao.CerimonialistaDao;
import dao.ClienteDao;
import dao.EncontroDao;
import dao.FisicaDao;
import dao.JuridicaDao;
import dao.ListaDeDesejosDao;
import dao.SalaoDao;


public class Teste {
	public static void main(String[] args) {
		//Cliente
			//Criação
				Cliente c = new Cliente("lucas","a","b", 8990, "1993-07-29", "d","e", "f", 7,"a");
				ClienteDao adao = new ClienteDao();
			//Insert
				adao.inserir(c);
			//Update
			//Remove
			//GetLista
			//Verifica
				System.out.println(adao.verificaCliente(1001));
			//Verifica2
				System.out.println(adao.getClie());
			//Verifica3
				System.out.println(adao.getClie2());
				/*
		//Fisica
				//Criação
				Fisica f = new Fisica("30",1001);
				FisicaDao adao10 = new FisicaDao();
				//Insert
				adao10.inserir(f);
				//Update
				//Remove
				//GetLista
				//Verifica
				
		
		
		//Salão
			//Criação
				Salao s = new Salao("moreira",300,23,5010,"aneilandio","456","rua floral",11);
				Salao se = new Salao("raffa",500,24,503,"rog","789"," rua desfloral",504);
				int numm = 988;
				Salao teste = new Salao(999);
				SalaoDao adao2 = new SalaoDao();
			//Insert
			//Update
			//Remove
			//GetLista
			//Verifica
				System.out.println(adao2.getLista());
				System.out.println(adao2.verificaSalao(589));
			*/
				
		
		//ListaDeDesejos
			//Criação
				ListaDeDesejos l = new ListaDeDesejos(566,5,"feia",30,"grande","carne",800, 4568,"2011-11-23","161541");
				ListaDeDesejosDao adao3 = new ListaDeDesejosDao();
				System.out.println(adao3.verificaLista(1));
			//Insert
			//Update
			//Remove
			//GetLista
			//Verifica
				
				
		//Cerimonialista
			//Criação
				Cerimonialista ca = new Cerimonialista(350,"maria@gmail.com","289667","Maria");
				CerimonialistaDao adao4 = new CerimonialistaDao();
				System.out.println(adao4.getCeri());
			//Insert
			//Update
			//Remove
			//GetLista
			//Verifica
					
	}
}
