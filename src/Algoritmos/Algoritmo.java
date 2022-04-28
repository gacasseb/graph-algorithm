package Algoritmos;

import Grafo.Grafo;

abstract class Algoritmo {
	
	protected Grafo grafo;
	
	public Algoritmo(Grafo grafo)
	{
		this.grafo = grafo;
	}
}
