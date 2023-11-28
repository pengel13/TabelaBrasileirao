package main.application;

import java.util.Scanner;

import main.entities.Partida;
import main.entities.Rodada;
import main.entities.Tabela;
import main.entities.Time;
import main.services.LeitorJsonService;

public class Main {

	private static Tabela tabelaPronta = new Tabela();
	private static Tabela tabelaNova = new Tabela();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		menu();

		in.close();
	}

	public static void menu() {
		System.out.println("...TABELA BRASILEIRÃO (10 TIMES)...");
		System.out.println();
		System.out.println(
				"Qual ação deseja fazer:\n 1 - Configurar uma tabela desde o início\n 2 - Ver tabela pronta com simulação\n 3 - Inserir times e pontuações através de arquivo JSON");
		int opcao = in.nextInt();

		switch (opcao) {
		case 1:
			montarTabela();
			break;
		case 2:
			System.out.println();
			System.out.println("...Simulando jogos...");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			configuraTimes();
			menuDeSimulacaoDePartidas();
			tabelaPronta.verTabela();
			break;
		case 3:
			arquivoJsonMenu();
		}

	}

	public static void arquivoJsonMenu() {
		System.out.println(
				"Digite o caminho para o arquivo: (Caso não tenha, pressione enter que carregaremos um de exemplo) ");
		in.nextLine();
		String path = in.nextLine();

		if (path.isEmpty()) {
			path = "./resources/times.json";
		}

		imprimirTimes(path);
	}

	public static void montarTabela() {
		System.out.println("Quantos times quer adicionar");
		int opcao = in.nextInt();

		for (int i = 0; i < opcao; i++) {
			System.out.println("Time " + i + ": ");
			String nomeDoTime = in.nextLine();

			Time time = new Time(nomeDoTime);

			tabelaNova.addTime(time);

		}
	}

	public static void configuraTimes() {
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

		tabelaPronta.addTime(time1);
		tabelaPronta.addTime(time2);
		tabelaPronta.addTime(time3);
		tabelaPronta.addTime(time4);
		tabelaPronta.addTime(time5);
		tabelaPronta.addTime(time6);
		tabelaPronta.addTime(time7);
		tabelaPronta.addTime(time8);
		tabelaPronta.addTime(time9);
		tabelaPronta.addTime(time10);
	}

	public static void menuDeSimulacaoDePartidas() {
		int numeroRodada = 0;

		for (int i = 0; i < 10; i++) {
			Rodada rodada = new Rodada(++numeroRodada);
			Time timeCasa = tabelaPronta.retornaTimeDaTabela(i);

			for (int j = 1; j <= 5; j++) {
				Time timeVisitante = tabelaPronta.retornaTimeDaTabela((i + j) % 10);

				Partida partida = simulaPartida(timeCasa, timeVisitante);
				rodada.addPartida(partida);

				tabelaPronta.registraPartida(partida);
				Tabela.incrementaRodadasJogadasNoCampeonato();
			}

			timeCasa.incrementaRodadasJogadas();

			tabelaPronta.adicionaRodadaNaLista(rodada);

			System.out.println();
			System.out.println("Lista de partidas do " + timeCasa.getNome() + " em casa:");
			System.out.println(rodada.getListasDePartidasPorTime());
			System.out.println();
		}

	}

	public static Partida simulaPartida(Time timeCasa, Time timeVisitante) {

		int golsCasa = (int) (Math.random() * 5);
		int golsVisitante = (int) (Math.random() * 5);

		return new Partida(timeCasa, timeVisitante, golsCasa, golsVisitante);
	}

	public static void imprimirTimes(String path) {
		LeitorJsonService lerJson = new LeitorJsonService();
		for (Time time : lerJson.lerListaDeTimes(path)) {
			System.out.println("Time: " + time + "\n");

		}
	}
}
