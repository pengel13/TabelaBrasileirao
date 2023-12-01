package main.entities;

/**
 * Representa a tabela do campeonato
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import main.comparators.NumeroDePontosComparator;
import main.comparators.NumeroDeVitoriasComparator;
import main.comparators.SaldoDeGolsComparator;

public class Tabela {
	private PriorityQueue<Time> tabela;
	private List<Time> listaDeRodadas = new ArrayList<Time>(); // Lista de rodadas do campeonato
	private Comparator<Time> numeroDePontosComparator, numeroDeVitoriasComparator, saldoDeGolsComparator;

	/*
	 * Instanciação dos comparators e da tabela, estabelencendo a ordem de
	 * comparação desejada na PriorityQueue
	 */
	public Tabela() {
		numeroDePontosComparator = new NumeroDePontosComparator();
		numeroDeVitoriasComparator = new NumeroDeVitoriasComparator();
		saldoDeGolsComparator = new SaldoDeGolsComparator();
		tabela = new PriorityQueue<Time>(10, numeroDePontosComparator.thenComparing(numeroDeVitoriasComparator)
				.thenComparing(saldoDeGolsComparator));
	}

	/**
     * Exibe a tabela formatada
     */
	public void verTabela() {
		List<Time> listaDeTimes = new ArrayList<>(tabela);

		List<Time> listaOrdenada = formatarTabela(listaDeTimes);

		for (Time time : listaOrdenada) {
			System.out.printf("%-20s | %-15s | %-10d | %-10d | %-10d | %-15d | %-15d | %-15d | %-18.2f | %-20d%n",
					time.getNome(), time.getPontuacao(), time.getVitorias(), time.getEmpates(), time.getDerrotas(),
					time.getSaldoGols(), time.getGolsMarcados(), time.getGolsSofridos(),
					time.getPercentualAproveitamento(), time.getRodadasJogadas() - 1);
		}

		System.out.println();
	}
	
	 /**
     * Exibe uma lista de times formatada como uma tabela
     *
     * @param listaDeTimes Lista de times a ser formatada
     */
	public void printarListaComFormatoDeTabela(List<Time> listaDeTimes) {

		List<Time> listaOrdenada = formatarTabela(listaDeTimes);

		for (Time time : listaOrdenada) {
			System.out.printf("%-20s | %-15s | %-10d | %-10d | %-10d | %-15d | %-15d | %-15d | %-18.2f | %-20d%n",
					time.getNome(), time.getPontuacao(), time.getVitorias(), time.getEmpates(), time.getDerrotas(),
					time.getSaldoGols(), time.getGolsMarcados(), time.getGolsSofridos(),
					time.getPercentualAproveitamento(), time.getRodadasJogadas());
		}

		System.out.println();
	}

	/**
     * Formata uma lista de times como uma tabela.
     *
     * @param listaDeTimes Lista de times a ser formatada.
     * @return Lista de times formatada.
     */
	private List<Time> formatarTabela(List<Time> listaDeTimes) {
		Collections.sort(listaDeTimes, numeroDePontosComparator.thenComparing(numeroDeVitoriasComparator)
				.thenComparing(saldoDeGolsComparator));

		System.out.printf("%-20s | %-15s | %-10s | %-10s | %-10s | %-10s | %-15s | %-15s | %-15s | %-20s%n", "Time",
				"Pontuação", "Vitórias", "Empates", "Derrotas", "Saldo de Gols  ", "Gols Marcados", "Gols Sofridos",
				"Aproveitamento   ", "Partidas Jogadas");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		return listaDeTimes;
	}

	public boolean addTime(Time time) {
		tabela.add(time);

		return true;

	}

	/**
	 * Transforma PriorityQueue em ArrayList para retornar um index desejado
	 * 
	 * @param index Index relacionado ao time que deseja retornar
	 * @return Time da lista
	 */
	public Time retornaTimeDaTabela(int index) {
		List<Time> listaDeTimes = new ArrayList<>();

		for (Time time : tabela) {
			listaDeTimes.add(time);
		}

		if (index >= 0 && index < listaDeTimes.size()) {
			return listaDeTimes.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Retorna uma ArrayList dos times
	 * 
	 * @return Lista de times
	 */
	public List<Time> retornaListaDeTimes() {
		return new ArrayList<>(tabela);
	}
	
	/**
	 * Retorna o primeiro time da PriorityQueue
	 * 
	 * @return Primeiro time da tabela
	 */
	public Time primeiroTimeDaTabela() {
		PriorityQueue<Time> tabelaTeste = tabela;

		Time time = tabelaTeste.peek();

		tabelaTeste.remove();

		return time;
	}

	public PriorityQueue<Time> getTabelaPriorityQueue() {
		return tabela;
	}

	
	/**
	 * Registra uma partida na tabela adicionando na Queue
	 * 
	 * @param partida Partida para adicionar na tabela
	 * @return true REgistro feito com sucesso
	 */
	public boolean registraPartida(Partida partida) {

		if (tabela.contains(partida.getTimeCasa()) && tabela.contains(partida.getTimeVisitante())) {

			partida.defineVencedor();
			return true;
		} else {
			return false;
		}
	}

	public boolean adicionaRodadaNaLista(Rodada rodada) {
		this.listaDeRodadas.add(null);

		return true;
	}

}
