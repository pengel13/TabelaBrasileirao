package main;

public class Partida {
	private Time timeCasa;
	private Time timeVisitante;
	private int golsCasa, golsVisitante;
	public Time getTimeCasa() {
		return timeCasa;
	}
	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}
	public Time getTimeVisitante() {
		return timeVisitante;
	}
	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}
	public int getGolsCasa() {
		return golsCasa;
	}
	public void setGolsCasa(int golsCasa) {
		this.golsCasa = golsCasa;
	}
	public int getGolsVisitante() {
		return golsVisitante;
	}
	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}
}
