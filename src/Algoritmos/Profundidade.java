package Algoritmos;

import Grafo.Grafo;

public class Profundidade extends Algoritmo {
	
	private String[] cor;
	private Integer[] precedente;
	private Integer time;
	private Integer[] timestamp;
	private Integer[] finishTime;
		
	public Profundidade(Grafo grafo)
	{
		super(grafo);
		time = 0;
		precedente = new Integer[this.grafo.vertices.length];
		timestamp = new Integer[this.grafo.vertices.length];
		finishTime = new Integer[this.grafo.vertices.length];
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
	 * Roda o algoritmo DSF
	 */
	public void run()
	{
		System.out.println("Iniciando o algoritmo");
		visit(3);
	}
	
	/**
	 * Faz a busca profunda dado um inteiro que representa um vértice 
	 * @param current
	 */
	private void visit(Integer current)
	{
		cor[current] = "cinza";
		time++;
		timestamp[current] = time;
		
		System.out.println(current);
		
		for ( int i = 0; i < this.grafo.vertices[current].size(); i++ ) {
			int next = (int) this.grafo.vertices[current].get(i);
			if ( cor[next] == "branco" ) {
				precedente[next] = current;
				visit(next);
			}
		}
		
		time++;
		finishTime[current] = time;
		cor[current] = "preto";
	}
}
