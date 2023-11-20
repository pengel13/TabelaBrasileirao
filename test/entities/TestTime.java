package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.entities.Time;

class TestTime {

	private Time time;

	@BeforeEach
	void setUp() {
		time = new Time("Grêmio");
	}

	@Test
	void testGetSaldoDeGols() {
		time.setGolsMarcados(55);
		time.setGolsSofridos(23);
		assertEquals(32, time.getSaldoGols());
	}

}
