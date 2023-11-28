package main.entities;

public class Rodada {
	private int numeroRodada;
	private Partida partida1, partida2, partida3, partida4, partida5;

	public Rodada() {

	}

	public Rodada(int numeroRodada, Partida partida1, Partida partida2, Partida partida3, Partida partida4,
			Partida partida5) {
		this.numeroRodada = numeroRodada;
		this.partida1 = partida1;
		this.partida2 = partida2;
		this.partida3 = partida3;
		this.partida4 = partida4;
		this.partida5 = partida5;

	}

	public int getNumeroRodada() {
		return numeroRodada;
	}

	public void setNumeroRodada(int numeroRodada) {
		this.numeroRodada = numeroRodada;
	}

	public Partida getPartida1() {
		return partida1;
	}

	public void setPartida1(Partida partida1) {
		this.partida1 = partida1;
	}

	public Partida getPartida2() {
		return partida2;
	}

	public void setPartida2(Partida partida2) {
		this.partida2 = partida2;
	}

	public Partida getPartida3() {
		return partida3;
	}

	public void setPartida3(Partida partida3) {
		this.partida3 = partida3;
	}

	public Partida getPartida4() {
		return partida4;
	}

	public void setPartida4(Partida partida4) {
		this.partida4 = partida4;
	}

	public Partida getPartida5() {
		return partida5;
	}

	public void setPartida5(Partida partida5) {
		this.partida5 = partida5;
	}
}
