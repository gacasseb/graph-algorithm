package Algoritmos;

import java.util.Arrays;
import java.util.LinkedList;

import Grafo.Grafo;

public class Largura extends Algoritmo {
	
	private String[] cor;
	private Integer[] precedente;
	private Integer[] distancia;
	private LinkedList<Integer> fila;

	/**
	 * Inicia variáveis para algoritmo de busca em largura
	 * @param grafo
	 * @param origem
	 */
	public Largura(Grafo grafo, Integer origem) {
		super(grafo, origem);
		
		precedente = new Integer[this.grafo.vertices.length];
		distancia = new Integer[this.grafo.vertices.length];
		Arrays.fill(distancia, 0);
		fila = new LinkedList<Integer>();
		setWhite();
	}
	
	/**
	 * Inicia o vetor de cores com todas as cores "branca"
	 */
	public void setWhite()
	{
		cor = new String[this.grafo.vertices.length];
		for ( int i = 0; i < cor.length; i++ ) {
			cor[i] = "branco";
		}
	}
	
	/**
	 * Gatilho para algoritmo de Busca em Largura
	 */
	public void run()
	{
		System.out.println("Iniciando o algoritmo de busca em largura");
		iterate(origem);
		System.out.println("\nFinalizado");
	}
		
	/**
	 * Roda o algoritmo de busca por largura
	 * @param origin
	 */
	public void iterate(Integer origin)
	{
		cor[origin] = "cinza";
		enqueue(origin);
		System.out.print(origin);
		
		while(fila.size() > 0)
		{
			int current;
			current = fila.getFirst();
			System.out.print(" - " + current);
			
			for ( int i = 0; i < this.grafo.vertices[current].size(); i++ ) {
				
				int next = (int) this.grafo.vertices[current].get(i)[0];
				if ( cor[next] == "branco" ) {
					cor[next] = "cinza";
					distancia[next] = distancia[current] + 1;
					// Verifica se o nó já contem na lista antes de adicionar
					if ( !fila.contains(next) ) {
						fila.add(next);
					}
				}
			}
			
			fila.remove();
			cor[current] = "preto";
		}
	}
	
	/**
	 * Adiciona na fila todos os vertices adjacentes do vértice edge
	 * @param edge
	 */
	public void enqueue(Integer edge)
	{
		for ( int i = 0; i < this.grafo.vertices[edge].size(); i++ ) {
			fila.add((int) this.grafo.vertices[edge].get(i)[0]);
		}
	}
}
