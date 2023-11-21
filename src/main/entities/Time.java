package main.entities;

public class Time {

	private String nome;
	private int rodadasJogadas, pontuacao, vitorias, golsMarcados, golsSofridos;

	public Time() {

	}

	public Time(String nome, int pontuacao, int vitorias) {
		this.nome = nome;
		this.rodadasJogadas = 0;
		this.pontuacao = pontuacao;
		this.golsMarcados = 0;
		this.golsSofridos = 0;
		this.vitorias = vitorias;
	}

	public Time(String nome) {
		this.nome = nome;
		this.rodadasJogadas = 0;
		this.pontuacao = 0;
		this.golsMarcados = 0;
		this.golsSofridos = 0;
		this.vitorias = 0;
	}
	
	public int incrementarVitorias() {
        this.vitorias++;
        
        return this.vitorias;
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

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getSaldoGols() {
		return golsMarcados - golsSofridos;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + ", rodadasJogadas=" + rodadasJogadas + ", pontuacao=" + pontuacao + ", vitorias="
				+ vitorias + ", golsMarcados=" + golsMarcados + ", golsSofridos=" + golsSofridos + "]";
	}
	
	

}
