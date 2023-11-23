package main.application;

import java.util.Scanner;

import main.entities.Tabela;
import main.entities.Time;
import main.services.LerJsonService;

public class Main {

	private static Tabela tabela = new Tabela();

	public static void main(String[] args) {
		menu(tabela);
		tabela.verTabela(); //printa a tabela oficial formatada 
	}

	public static void menu(Tabela tabela) {
		LerJsonService lerJson = new LerJsonService();
		Scanner in = new Scanner(System.in);

		tabela.addTime(new Time("Grêmio", 40, 12));
		tabela.addTime(new Time("Fluminense", 12, 3));
		tabela.addTime(new Time("Atlético MG", 12, 4));
		tabela.addTime(new Time("São Paulo", 25, 7));
		tabela.addTime(new Time("Palmeiras", 23, 5));
		tabela.addTime(new Time("Coritiba", 34, 8));
		tabela.addTime(new Time("Bragantino", 34, 7));
		tabela.addTime(new Time("Botafogo", 36, 10));
		tabela.addTime(new Time("Juventude", 35, 12));
		tabela.addTime(new Time("Brasil de Pelotas", 40, 10));

		//imprimirTimes(lerJson, "./resources/times.json"); //lista de 10 times exemplo 

	}

	public static void imprimirTimes(LerJsonService lerJson, String path) {
		for (Time time : lerJson.lerListaDeTimes(path)) {
			System.out.println("Time: " + time + "\n");
			
		} //teste pra printar o json -> não está formatado
	}
}
