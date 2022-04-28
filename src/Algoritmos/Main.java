package Algoritmos;

import Grafo.Grafo;

public class Main {

	public static void main(String args[])
	{
		Grafo grafo;
		grafo = new Grafo();
		grafo.randomLoad();
		
//		runProfundidade(grafo);
		runLargura(grafo);
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
