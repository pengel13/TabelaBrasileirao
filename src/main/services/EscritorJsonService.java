package main.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

import com.google.gson.Gson;

import main.entities.Time;

/*
 * Serviço para escrever em um arquivo JSON utilizando a lib GSON
 */
public class EscritorJsonService {

	private Gson gson;
	private PriorityQueue<Time> tabela;

	public EscritorJsonService(PriorityQueue<Time> tabela) {
		this.tabela = tabela;
		gson = new Gson();
	}

	/**
	 * 
	 * @param fileName Nome do arquivo para não haver repetição e sobescrever o antigo
	 */
	public void escreverTabelaNoJson(String fileName) {
		try (FileWriter fileWriter = new FileWriter("./resources/" + fileName)) {

			gson.toJson(tabela, fileWriter);

			System.out.println("Tabela escrita em um arquivo JSON na pasta resources com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
