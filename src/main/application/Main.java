package main.application;

import java.util.Scanner;

import main.entities.Partida;
import main.entities.Rodada;
import main.entities.Tabela;
import main.entities.Time;
import main.services.EscritorJsonService;
import main.services.LeitorJsonService;

public class Main {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean valida = false;

		do {
			try {
				menu();
				valida = true; // Define true se o menu for concluido
			} catch (RuntimeException e) { // Exceção em tempo de execução
				System.out.println("Mensagem: Digite um valor válido");
				System.out.println("Error: " + e.getMessage());
				in.nextLine();
			}

			System.out.println();

		} while (!valida);

		in.close();
	}

	// menu com as opções
	public static void menu() {
		System.out.println("...TABELA BRASILEIRÃO (10 TIMES)...");
		System.out.println();

		int opcao = 0;

		do {
			System.out.println(
					"Qual ação deseja fazer:\n 1 - Configurar uma tabela desde o início\n 2 - Ver tabela pronta com simulação\n 3 - Inserir times e pontuações através de arquivo JSON\n 0 - Sair");
			opcao = in.nextInt();

			switch (opcao) {
			case 0:
				break;
			case 1:
				montarTabela();
				break;
			case 2:
				Tabela tabelaPronta = new Tabela();
				System.out.println();
				System.out.println("...Simulando jogos...");

				try { // simula carregamento das partidas
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				configuraTimes(tabelaPronta);
				menuDeSimulacaoDePartidas(tabelaPronta);

				break;
			case 3:
				arquivoJsonMenu();
				break;
			}

		} while (opcao != 0);

		System.out.println("Saindo...");
	}

	// Menu para printar o arquivo JSON do usuário
	public static void arquivoJsonMenu() {
		System.out.println(
				"Digite o caminho para o arquivo: (Caso não tenha, pressione enter que carregaremos um de exemplo) ");
		in.nextLine();
		String path = in.nextLine();

		if (path.isEmpty()) {
			path = "./resources/times.json";
			System.out.println("Puxando de '" + path + "'...");

		}

		imprimirTimes(path);
	}

	public static void montarTabela() {
		Tabela tabelaNova = new Tabela();
		System.out.print("Quantos times quer adicionar: ");
		int opcao = in.nextInt();

		in.nextLine(); // Limpa buffer
		for (int i = 0; i < opcao; i++) {
			System.out.print("Time " + (i + 1) + ": ");
			String nomeDoTime = in.nextLine();

			Time time = new Time(nomeDoTime);

			tabelaNova.addTime(time);
		}

		System.out.println("");

		System.out.println("Selecione os placares dessas partidas: (Ex: 2x4)");

		int numeroRodada = 0;

		for (int i = 0; i < tabelaNova.getTabelaPriorityQueue().size(); i++) {
			Rodada rodada = new Rodada(++numeroRodada); // Numero de rodadas = (Numero de times * 2) - 2
			Time timeCasa = tabelaNova.retornaTimeDaTabela(i);

			for (int j = 0; j < tabelaNova.getTabelaPriorityQueue().size(); j++) {
				if (i != j) {
					Time timeVisitante = tabelaNova.retornaTimeDaTabela(j);

					System.out.print(timeCasa.getNome() + " x " + timeVisitante.getNome() + ": ");
					String[] placar = (in.nextLine()).split("x"); // Filtrar o placar removendo o "x"
					int placarCasa = Integer.parseInt(placar[0]);
					int placarVisitante = Integer.parseInt(placar[1]);

					Partida partida = new Partida(timeCasa, timeVisitante, placarCasa, placarVisitante);

					rodada.addPartida(partida);
					tabelaNova.registraPartida(partida);

				}
			}

			tabelaNova.adicionaRodadaNaLista(rodada);
		}

		System.out.println();
		tabelaNova.verTabela();
		System.out.println();

		System.out.println("Deseja salvar a tabela em um arquivo JSON? (Sim/Não)");
		String salvarEmJsonOpcao = in.nextLine();

		EscritorJsonService escritorJson = new EscritorJsonService(tabelaNova.getTabelaPriorityQueue());

		if (salvarEmJsonOpcao.equalsIgnoreCase("Sim")) {
			System.out.println();
			System.out.print("Nome do arquivo: ");
			String nomeDoArquivo = in.nextLine() + ".json";
			escritorJson.escreverTabelaNoJson(nomeDoArquivo);
			System.out.println();
		}

	}

	// Adiciona 10 times na tabela que será usada na simulação
	public static void configuraTimes(Tabela tabelaPronta) {
		tabelaPronta.addTime(new Time("Grêmio"));
		tabelaPronta.addTime(new Time("Fluminense"));
		tabelaPronta.addTime(new Time("Atlético MG"));
		tabelaPronta.addTime(new Time("São Paulo"));
		tabelaPronta.addTime(new Time("Palmeiras"));
		tabelaPronta.addTime(new Time("Coritiba"));
		tabelaPronta.addTime(new Time("Bragantino"));
		tabelaPronta.addTime(new Time("Botafogo"));
		tabelaPronta.addTime(new Time("Juventude"));
		tabelaPronta.addTime(new Time("Brasil de Pelotas"));
	}

	public static void menuDeSimulacaoDePartidas(Tabela tabelaPronta) {
		int numeroRodada = 0;

		/*
		 * Logica com estrutura de repetição para percorrer todos os times cadastrados
		 * na tabela e simular resultados
		 */
		for (int i = 0; i < 10; i++) {
			Rodada rodada = new Rodada(++numeroRodada);
			Time timeCasa = tabelaPronta.retornaTimeDaTabela(i);

			for (int j = 1; j <= 10; j++) {
				Time timeVisitante = tabelaPronta.retornaTimeDaTabela((i + j) % 10); // Percorre por todos os times da
																						// tabela

				if (!timeCasa.equals(timeVisitante)) {
					Partida partida = simulaPartida(timeCasa, timeVisitante);
					rodada.addPartida(partida);

					tabelaPronta.registraPartida(partida); // Registra partida simulada definindo vendedor e atualizando
															// pontos

				}

			}

			tabelaPronta.adicionaRodadaNaLista(rodada);

			System.out.println();
			System.out.println("Lista de partidas do " + timeCasa.getNome() + " em casa:");
			System.out.println(rodada.getListaRodada());
			System.out.println();
		}

		EscritorJsonService escritorJson = new EscritorJsonService(tabelaPronta.getTabelaPriorityQueue());

		System.out.println("Deseja salvar a tabela em um arquivo JSON? (Sim/Não)");
		in.nextLine();
		String salvarEmJsonOpcao = in.nextLine();

		if (salvarEmJsonOpcao.equalsIgnoreCase("Sim")) {
			System.out.println();
			System.out.print("Nome do arquivo: ");
			String nomeDoArquivo = in.nextLine() + ".json";
			escritorJson.escreverTabelaNoJson(nomeDoArquivo);
			System.out.println();
		}

		tabelaPronta.verTabela();

	}

	// Simula a criação de uma partida
	public static Partida simulaPartida(Time timeCasa, Time timeVisitante) {

		int golsCasa = (int) (Math.random() * 5);
		int golsVisitante = (int) (Math.random() * 5);

		return new Partida(timeCasa, timeVisitante, golsCasa, golsVisitante);
	}

	// Método para printar os times de um arquivo JSON recebido como parâmetro
	public static void imprimirTimes(String path) {
		Tabela tabela = new Tabela();
		LeitorJsonService lerJson = new LeitorJsonService();
		tabela.printarListaComFormatoDeTabela(lerJson.lerListaDeTimes(path));
	}
}
