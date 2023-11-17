package main.entities;

import java.util.PriorityQueue;

import main.comparators.NumeroDePontosComparator;

public class Tabela {
	private PriorityQueue<Time> tabela;
	private NumeroDePontosComparator numeroDePontosComparator;

	public Tabela() {
		tabela = new PriorityQueue<Time>(10, numeroDePontosComparator);
	}

	public void verTabela() {
		while (tabela.size() != 0) {
			Time time = tabela.remove();
			System.out.println(time.getNome() + "| Pontuacão: " + time.getPontuacao() + "| Gols marcados: "
					+ time.getGolsMarcados() + "| Rodada jogadas: " + time.getRodadasJogadas());
		}

		System.out.println();
	}

	public boolean addTime(Time time) {
		tabela.add(time);

		return true;

	}

}
