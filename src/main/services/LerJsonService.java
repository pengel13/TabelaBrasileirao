package main.services;

import java.lang.reflect.Type;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.entities.Time;

public class LerJsonService {
	private Gson gson;

	public LerJsonService() {
		gson = new Gson();
	}

	public List<Time> lerListaDeTimes(String path) {
		try {
			if (!isPathValid(path)) {
				throw new Error("Invalid path");
			}

			String json = Files.readString(Paths.get(path), StandardCharsets.UTF_8);

			Type listType = new TypeToken<List<Time>>() {
			}.getType();

			List<Time> times = new Gson().fromJson(json, listType);

			return times;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
			return null;

		}
	}

	public boolean isPathValid(String path) {
		Path file = Paths.get(path);
		return Files.exists(file) && Files.isRegularFile(file) && path.endsWith(".json");
	}
}
