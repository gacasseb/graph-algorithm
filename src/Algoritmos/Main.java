package Algoritmos;

import java.io.*;

import Grafo.Grafo;

public class Main {

	public static void main(String args[]) throws FileNotFoundException
	{
		String fileName = "src/grafo1.txt";
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		
		Grafo grafo;
		grafo = new Grafo();
		grafo.load(file);
		grafo.printVertices();
//		grafo.randomLoad();
		
		runProfundidade(grafo);
//		runLargura(grafo);
		
//		System.out.println("Resultados: ");
//		System.out.println(grafo.getOrientado());
//		System.out.println(grafo.getNumVertices());
//		System.out.println(grafo.getVertices().length);
	}
	
	public static void runProfundidade(Grafo grafo)
	{
		Profundidade algoritmo;
		algoritmo = new Profundidade(grafo);
		algoritmo.run();
	}
	
	public static void runLargura(Grafo grafo)
	{
		Largura algoritmo;
		algoritmo = new Largura(grafo);
		algoritmo.run();
	}
}
