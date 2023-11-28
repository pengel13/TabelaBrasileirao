package main.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.entities.Partida;
import main.entities.Tabela;
import main.entities.Time;
import main.services.LeitorJsonService;

public class Main {

	private static Tabela tabela = new Tabela();

	public static void main(String[] args) {
		menu(tabela);
		tabela.verTabela(); // printa a tabela oficial formatada
	}

	public static void menu(Tabela tabela) {
		LeitorJsonService lerJson = new LeitorJsonService();
		Scanner in = new Scanner(System.in);

		Time time1 = new Time("Grêmio");
		Time time2 = new Time("Fluminense");
		Time time3 = new Time("Atlético MG");
		Time time4 = new Time("São Paulo");
		Time time5 = new Time("Palmeiras");
		Time time6 = new Time("Coritiba");
		Time time7 = new Time("Bragantino");
		Time time8 = new Time("Botafogo");
		Time time9 = new Time("Juventude");
		Time time10 = new Time("Brasil de Pelotas");

		tabela.addTime(time1);
		tabela.addTime(time2);
		tabela.addTime(time3);
		tabela.addTime(time4);
		tabela.addTime(time5);
		tabela.addTime(time6);
		tabela.addTime(time7);
		tabela.addTime(time8);
		tabela.addTime(time9);
		tabela.addTime(time10);

		for (int i = 0; i < 11; i++) {
			for (int j = i + 1; j < 11; j++) {
				Partida partida = simulaPartida(tabela.retornaTimeDaTabela(i), tabela.retornaTimeDaTabela(j));
				tabela.registraPartida(partida);
			}
		}

	}

	public static Partida simulaPartida(Time timeCasa, Time timeVisitante) {

		int golsCasa = (int) (Math.random() * 5);
		int golsVisitante = (int) (Math.random() * 5);

		return new Partida(timeCasa, timeVisitante, golsCasa, golsVisitante);
	}

	// imprimirTimes(lerJson, "./resources/times.json"); //lista de 10 times exemplo

	public static void imprimirTimes(LeitorJsonService lerJson, String path) {
		for (Time time : lerJson.lerListaDeTimes(path)) {
			System.out.println("Time: " + time + "\n");

		} // teste pra printar o json -> não está formatado
	}
}
