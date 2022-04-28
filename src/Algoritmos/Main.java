package Algoritmos;

import Grafo.Grafo;

public class Main {

	public static void main(String args[])
	{
		System.out.println("Entrou no main");
		
		Grafo grafo;
		grafo = new Grafo();
		grafo.randomLoad();
		
		runProfundidade(grafo);
	}
	
	public static void runProfundidade(Grafo grafo)
	{
		Profundidade algoritmo;
		algoritmo = new Profundidade(grafo);
		algoritmo.run();
	}
}
