package main.entities;

import java.util.PriorityQueue;

import main.comparators.NumeroDePontosComparator;
import main.comparators.NumeroDeVitoriasComparator;
import main.comparators.SaldoDeGolsComparator;

public class Tabela {
	private PriorityQueue<Time> tabela;
	private NumeroDePontosComparator numeroDePontosComparator;
	private NumeroDeVitoriasComparator numeroDeVitoriasComparator;
	private SaldoDeGolsComparator saldoDeGolsComparator;

	public Tabela() {
		numeroDePontosComparator = new NumeroDePontosComparator();
		numeroDeVitoriasComparator = new NumeroDeVitoriasComparator();
		saldoDeGolsComparator = new SaldoDeGolsComparator();
		tabela = new PriorityQueue<Time>(10, numeroDePontosComparator.thenComparing(numeroDeVitoriasComparator)
				.thenComparing(saldoDeGolsComparator));
	}

	public void verTabela() {
		System.out.printf("%-20s | %-10s | %-10s | %-15s | %-20s%n", "Time", "Pontuação", "Vitórias", "Saldo de Gols",
				"Rodadas Jogadas");
		System.out.println("-----------------------------------------------------------------------------------");

		while (!tabela.isEmpty()) {
			Time time = tabela.poll();
			System.out.printf("%-20s | %-10d | %-10d | %-15d | %-20d%n", time.getNome(), time.getPontuacao(),
					time.getVitorias(), time.getSaldoGols(), time.getRodadasJogadas());
		}

		System.out.println();
	}

	public boolean addTime(Time time) {
		tabela.add(time);

		return true;

	}

}
