package main.services;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.entities.Time;

public class LeitorJsonService {

	public LeitorJsonService() {

	}

	public List<Time> lerListaDeTimes(String path) {
		try {
			if (!verificaPath(path)) {
				throw new InputMismatchException("Path inválido");
			}

			String json = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

			Type listaType = new TypeToken<List<Time>>() {
			}.getType();

			List<Time> times = new Gson().fromJson(json, listaType);

			return times;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;

		}
	}

	public boolean verificaPath(String path) {
		Path file = Paths.get(path);
		return Files.exists(file) && Files.isRegularFile(file) && path.endsWith(".json");
	}
}
