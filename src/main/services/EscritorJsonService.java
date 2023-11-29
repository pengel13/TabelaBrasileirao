package main.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

import com.google.gson.Gson;

import main.entities.Time;

public class EscritorJsonService {

	private Gson gson;
	private PriorityQueue<Time> tabela;

	public EscritorJsonService(PriorityQueue<Time> tabela) {
		this.tabela = tabela;
		gson = new Gson();
	}

	public void escreverTabelaNoJson(String fileName) {
		try (FileWriter fileWriter = new FileWriter("./resources/" + fileName)) {

			gson.toJson(tabela, fileWriter);

			System.out.println("Tabela escrita em um arquivo JSON na pasta resources com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
