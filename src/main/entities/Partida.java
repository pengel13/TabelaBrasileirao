package main.entities;

import main.exceptions.DomainException;

public class Partida {
	private Time timeCasa;
	private Time timeVisitante;
	private int golsCasa, golsVisitante;

	public Partida() {

	}

	public Partida(Time timeCasa, Time timeVisitante, int golsCasa, int golsVisitante) {
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.golsCasa = validaInt(golsCasa);
		this.golsVisitante = validaInt(golsVisitante);
	}

	public void defineVencedor() {
	    if (golsCasa == golsVisitante) {
	        timeCasa.incrementaEmpates(golsCasa, golsVisitante);
	        timeVisitante.incrementaEmpates(golsVisitante, golsCasa);
	    } else if (golsCasa > golsVisitante) {
	        timeCasa.incrementarVitorias(golsCasa, golsVisitante);
	        timeVisitante.incrementaDerrotas(golsVisitante, golsCasa);
	    } else {
	        timeVisitante.incrementarVitorias(golsVisitante, golsCasa);
	        timeCasa.incrementaDerrotas(golsCasa, golsVisitante);
	    }

	    timeCasa.incrementaRodadasJogadas();
	    timeVisitante.incrementaRodadasJogadas();

	}



	public int validaInt(int valor) {
		try {
			if (valor < 0) {
				throw new DomainException("Insira um valor de gols válido");
			}
			return valor;
		} catch (DomainException e) {
			System.out.println("Error: " + e.getMessage());

			return 0;
		}
	}

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

	@Override
	public String toString() {
		return "Partida: " + timeCasa.getNome() + " " + golsCasa + " x " + golsVisitante + " " + timeVisitante.getNome() + ".\n";
	}
	
}
