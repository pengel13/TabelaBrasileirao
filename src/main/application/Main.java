package main.application;

import java.util.Scanner;

import main.entities.Partida;
import main.entities.Tabela;
import main.entities.Time;
import main.services.LeitorJsonService;

public class Main {

	private static Tabela tabela = new Tabela();

	public static void main(String[] args) {
		menu(tabela);
		tabela.verTabela();
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

		for (Time timeCasa : tabela.retornaListaDeTimes()) {
			for (Time timeVisitante : tabela.retornaListaDeTimes()) {
				if (timeCasa != timeVisitante) {

					if (timeCasa.getRodadasJogadas() < 17 && timeVisitante.getRodadasJogadas() < 17) {
						Partida partida1 = simulaPartida(timeCasa, timeVisitante);
						Partida partida2 = simulaPartida(timeVisitante, timeCasa);

						tabela.registraPartida(partida1);
						tabela.registraPartida(partida2);
					}

				}
			}
		}

		for (Time time : tabela.retornaListaDeTimes()) {
			time.incrementaRodadasJogadas();
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

		}
	}
}
