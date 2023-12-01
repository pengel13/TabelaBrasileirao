package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.entities.Partida;
import main.entities.Rodada;
import main.entities.Tabela;
import main.entities.Time;

class TestTabela {

	Tabela tabela1, tabela2, tabela3, tabela4, tabela5;

	@BeforeEach
	void setUp() {
		tabela1 = new Tabela();
		tabela2 = new Tabela();
		tabela3 = new Tabela();
		tabela4 = new Tabela();
		tabela5 = new Tabela();
	}

	@Test
	public void testAddTime() {
		Time time = new Time("Grêmio");
		assertTrue(tabela1.addTime(time));
		assertEquals(1, tabela1.retornaListaDeTimes().size());
		assertEquals(time, tabela1.retornaListaDeTimes().get(0));
	}

	@Test
	public void testRetornaTimeDaTabela() {
		Time timeA = new Time("Grêmio");
		Time timeB = new Time("Botafogo");
		tabela2.addTime(timeA);
		tabela2.addTime(timeB);

		assertEquals(timeA, tabela2.retornaTimeDaTabela(0));
		assertEquals(timeB, tabela2.retornaTimeDaTabela(1));
		assertNull(tabela2.retornaTimeDaTabela(2));
	}

	@Test
	public void testPrimeiroTimeDaTabela() {
		Time timeA = new Time("Grêmio");
		Time timeB = new Time("Coritiba");
		tabela3.addTime(timeA);
		tabela3.addTime(timeB);

		assertEquals(timeA, tabela3.primeiroTimeDaTabela());
		assertEquals(timeB, tabela3.primeiroTimeDaTabela());
	}

	@Test
	public void testRegistraPartida() {
		Time timeA = new Time("Grêmio");
		Time timeB = new Time("Fluminense");
		Partida partida = new Partida(timeA, timeB, 2, 1);

		assertFalse(tabela4.registraPartida(partida));
		tabela4.addTime(timeA);
		tabela4.addTime(timeB);

		assertTrue(tabela4.registraPartida(partida));
		assertEquals(1, timeA.getVitorias());
		assertEquals(1, timeB.getDerrotas());
	}

	@Test
	public void testAdicionaRodadaNaLista() {
		Rodada rodada = new Rodada(1);

		assertTrue(tabela5.adicionaRodadaNaLista(rodada));
		assertEquals(1, tabela5.getListaDeRodadas().size());
		assertEquals(rodada, tabela5.getListaDeRodadas().get(0));
	}

}
