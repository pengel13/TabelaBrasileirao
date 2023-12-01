package main.entities;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
	private int numeroRodada;
	private List<Partida> listaRodada;

	public Rodada() {

	}

	public Rodada(int numeroRodada) {
		this.numeroRodada = numeroRodada;
		listaRodada = new ArrayList<Partida>();

		Tabela.incrementaRodadasJogadasNoCampeonato();

	}

	public boolean addPartida(Partida partida) {
		this.listaRodada.add(partida);

		return true;
	}

	public List<Partida> getListaRodada() {
		return listaRodada;
	}

	public int getNumeroRodada() {
		return numeroRodada;
	}

	public void setNumeroRodada(int numeroRodada) {
		this.numeroRodada = numeroRodada;
	}
	@Override
	public String toString() {
		return "Rodada [numeroRodada=" + numeroRodada + ", listaRodada=" + listaRodada + "]";
	}

}
