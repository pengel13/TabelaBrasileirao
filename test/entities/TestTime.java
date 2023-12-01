package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.entities.Time;

class TestTime {

	private Time time1, time2, time3, time4;

	@BeforeEach
	void setUp() {
		time1 = new Time("Grêmio");
		time2 = new Time("Fluminense");
		time3 = new Time("Coritiba");
		time4 = new Time("Botafogo");
	}

	@Test
	void testIncrementaEmpates() {

		time2.incrementaEmpates(1, 1);

		assertEquals(1, time2.getEmpates());
		assertEquals(1, time2.getPontuacao());
	}

	@Test
	void testIncrementarVitorias() {

		time3.incrementarVitorias(2, 1);

		assertEquals(1, time3.getVitorias());
		assertEquals(3, time3.getPontuacao());
	}

	@Test
	void testIncrementaDerrotas() {

		time4.incrementaDerrotas(0, 3);

		assertEquals(1, time4.getDerrotas());
		assertEquals(0, time4.getGolsMarcados());
		assertEquals(3, time4.getGolsSofridos());
	}

	@Test
	void testGetSaldoDeGols() {
		time1.setGolsMarcados(55);
		time1.setGolsSofridos(23);
		assertEquals(32, time1.getSaldoGols());
	}

}
