package services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.services.LeitorJsonService;

class TestLeitorJsonService {

	private LeitorJsonService leitorJsonService;

	@BeforeEach
	void setup() {
		leitorJsonService = new LeitorJsonService();
	}

	@Test
	void testVerificaPath() {
		String pathFalso = "./resources/times.txt";
		String pathVerdadeiro = "./resources/times.json";

		assertFalse(leitorJsonService.verificaPath(pathFalso));
		assertTrue(leitorJsonService.verificaPath(pathVerdadeiro));
	}

}
