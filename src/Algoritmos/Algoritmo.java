package Algoritmos;

import Grafo.Grafo;

abstract class Algoritmo {
	
	protected Grafo grafo;
	protected Integer origem;
	
	public Algoritmo(Grafo grafo, Integer origem)
	{
		this.grafo = grafo;
		this.origem = origem;
	}
}
