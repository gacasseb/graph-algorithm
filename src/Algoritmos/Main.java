package Algoritmos;

import java.io.*;
import java.util.Scanner;

import Grafo.Grafo;
import Menu.Menu;

public class Main {

	/**
	 * Lê arquivo do grafo armazenado, carrega o grafo do arquivo e printa o menu de algoritmos
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		Menu menu;
		menu = new Menu();
		String fileName;
		fileName = menu.menuPrincipal(sc);
		if(fileName != null){
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			Grafo grafo;
			grafo = new Grafo();
			
			grafo.load(file);
			menu.menuAlgoritmos(grafo, sc);
	
		}
		sc.close();
	}
}
