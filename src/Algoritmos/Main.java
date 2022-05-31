package Algoritmos;

import java.io.*;
import java.util.Scanner;

import Grafo.Grafo;
import Menu.Menu;

public class Main {

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Menu menu;
		menu = new Menu();
		String fileName;
		fileName = menu.menuPrincipal(sc);
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		
		Grafo grafo;
		grafo = new Grafo();
		grafo.load(file);
		grafo.printVertices();
//		grafo.randomLoad();
		
//		runProfundidade(grafo);
//		runLargura(grafo);
		menu.menuAlgoritmos(grafo, sc);
		
//		System.out.println("Resultados: ");
//		System.out.println(grafo.getOrientado());
//		System.out.println(grafo.getNumVertices());
//		System.out.println(grafo.getVertices().length);
		sc.close();
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
