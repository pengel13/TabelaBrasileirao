package main.entities;

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
	private Comparator<Time> numeroDePontosComparator, numeroDeVitoriasComparator, saldoDeGolsComparator;

	public Tabela() {
		numeroDePontosComparator = new NumeroDePontosComparator();
		numeroDeVitoriasComparator = new NumeroDeVitoriasComparator();
		saldoDeGolsComparator = new SaldoDeGolsComparator();
		tabela = new PriorityQueue<Time>(10, numeroDePontosComparator.thenComparing(numeroDeVitoriasComparator)
				.thenComparing(saldoDeGolsComparator));
	}

	public void verTabela() {
		List<Time> listaOrdenada = new ArrayList<>(tabela);

		Collections.sort(listaOrdenada, numeroDePontosComparator.thenComparing(numeroDeVitoriasComparator)
				.thenComparing(saldoDeGolsComparator));

		System.out.printf("%-20s | %-15s | %-10s | %-10s | %-15s | %-20s%n", "Time", "Pontuação", "Vitórias", "Empates",
				"Saldo de Gols", "Rodadas Jogadas");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------");

		for (Time time : listaOrdenada) {
			System.out.printf("%-20s | %-15s | %-10d | %-10d | %-15d | %-20d%n", time.getNome(), time.getPontuacao(),
					time.getVitorias(), time.getEmpates(), time.getSaldoGols(), time.getRodadasJogadas());
		}

		System.out.println();
	}

	public boolean addTime(Time time) {
		tabela.add(time);

		return true;

	}

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

	public List<Time> retornaListaDeTimes() {
	    return new ArrayList<>(tabela);
	}


	public boolean registraPartida(Partida partida) {

		if (tabela.contains(partida.getTimeCasa()) && tabela.contains(partida.getTimeVisitante())) {

			partida.defineVencedor();
			return true;
		} else {
			return false;
		}
	}
}
