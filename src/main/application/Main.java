package main.application;

import java.util.Scanner;

import main.entities.Tabela;
import main.entities.Time;

public class Main {

	private static Tabela tabela = new Tabela();

	public static void main(String[] args) {
		menu(tabela);
		tabela.verTabela();
	}

	public static void menu(Tabela tabela) {
		Scanner in = new Scanner(System.in);

		tabela.addTime(new Time("Grêmio"));
		tabela.addTime(new Time("Fluminense"));
		tabela.addTime(new Time("Atlético MG"));
		tabela.addTime(new Time("São Paulo"));
		tabela.addTime(new Time("Palmeiras"));
		tabela.addTime(new Time("Coritiba"));
		tabela.addTime(new Time("Bragantino"));
		tabela.addTime(new Time("Botafogo"));
		tabela.addTime(new Time("Juventude"));
		tabela.addTime(new Time("Brasil de Pelotas"));

	}
}
