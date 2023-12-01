package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.entities.Partida;
import main.entities.Rodada;
import main.entities.Time;

class TestRodada {
	private Rodada rodada1, rodada2, rodada3;
	private Time timeCasa, timeVisitante;

	@BeforeEach
	void setUp() {
		rodada1 = new Rodada(1);
		rodada2 = new Rodada(2);
		rodada3 = new Rodada(3);

		timeCasa = new Time("Grêmio");
		timeVisitante = new Time("Fluminense");
	}

	@Test
	public void testAddPartida() {
		Partida partida = new Partida(timeCasa, timeVisitante, 2, 1);

		assertTrue(rodada1.addPartida(partida));
		assertEquals(1, rodada1.getListaRodada().size());
		assertEquals(partida, rodada1.getListaRodada().get(0));
	}

	@Test
	public void testGetListaRodada() {
		assertNotNull(rodada2.getListaRodada());
		assertEquals(0, rodada2.getListaRodada().size());
	}

	@Test
	public void testGetNumeroRodada() {
		assertEquals(3, rodada3.getNumeroRodada());
	}

}
