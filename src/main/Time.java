package main;

public class Time {

	private String nome;
	private int rodadasJogadas, pontuacao, golsMarcados, golsSofridos;

	public Time() {

	}

	public Time(String nome, int rodadasJogadas, int pontuacao, int golsMarcados, int golsSofridos) {
		this.nome = nome;
		this.rodadasJogadas = rodadasJogadas;
		this.pontuacao = pontuacao;
		this.golsMarcados = golsMarcados;
		this.golsSofridos = golsSofridos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRodadasJogadas() {
		return rodadasJogadas;
	}

	public void setRodadasJogadas(int rodadasJogadas) {
		this.rodadasJogadas = rodadasJogadas;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getGolsMarcados() {
		return golsMarcados;
	}

	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public int getSaldoGols() {
		return golsMarcados - golsSofridos;
	}

}
