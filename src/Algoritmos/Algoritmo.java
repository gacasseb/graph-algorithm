package Algoritmos;

import Grafo.Grafo;

abstract class Algoritmo {
	
	// Grafo carregado
	protected Grafo grafo;
	// Ponto de origem do algoritmo
	protected Integer origem;
	
	/**
	 * 
	 * @param grafo
	 * @param origem ponto de origem
	 */
	public Algoritmo(Grafo grafo, Integer origem)
	{
		this.grafo = grafo;
		this.origem = origem;
	}
}
