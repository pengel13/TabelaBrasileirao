package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.entities.Partida;
import main.entities.Time;

class TestPartida {

	@Test
	void testDefineVencedorCasaVitoria() {
		Time timeCasa = new Time("Atlético MG");
		Time timeVisitante = new Time("Brasil De Pelotas");
		Partida partida = new Partida(timeCasa, timeVisitante, 2, 1);

		partida.defineVencedor();

		assertEquals(3, timeCasa.getPontuacao());
		assertEquals(1, timeCasa.getVitorias());
		assertEquals(0, timeCasa.getEmpates());
		assertEquals(0, timeCasa.getDerrotas());

		assertEquals(0, timeVisitante.getPontuacao());
		assertEquals(0, timeVisitante.getVitorias());
		assertEquals(0, timeVisitante.getEmpates());
		assertEquals(1, timeVisitante.getDerrotas());
	}

	@Test
	void testDefineVencedorEmpate() {
		Time timeCasa = new Time("Coritiba");
		Time timeVisitante = new Time("Botafogo");
		Partida partida = new Partida(timeCasa, timeVisitante, 1, 1);

		partida.defineVencedor();

		assertEquals(1, timeCasa.getPontuacao());
		assertEquals(0, timeCasa.getVitorias());
		assertEquals(1, timeCasa.getEmpates());
		assertEquals(0, timeCasa.getDerrotas());

		assertEquals(1, timeVisitante.getPontuacao());
		assertEquals(0, timeVisitante.getVitorias());
		assertEquals(1, timeVisitante.getEmpates());
		assertEquals(0, timeVisitante.getDerrotas());
	}

	@Test
	void testDefineVencedorVisitanteVitoria() {
		Time timeCasa = new Time("Grêmio");
		Time timeVisitante = new Time("Fluminense");
		Partida partida = new Partida(timeCasa, timeVisitante, 1, 2);

		partida.defineVencedor();

		assertEquals(0, timeCasa.getPontuacao());
		assertEquals(0, timeCasa.getVitorias());
		assertEquals(0, timeCasa.getEmpates());
		assertEquals(1, timeCasa.getDerrotas());

		assertEquals(3, timeVisitante.getPontuacao());
		assertEquals(1, timeVisitante.getVitorias());
		assertEquals(0, timeVisitante.getEmpates());
		assertEquals(0, timeVisitante.getDerrotas());
	}

	@Test
	void testValidaInt() {
		Partida partida = new Partida();

		assertEquals(3, partida.validaInt(3));
		assertEquals(0, partida.validaInt(-1));
	}

}
