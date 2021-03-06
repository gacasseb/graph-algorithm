package Algoritmos;

import Grafo.Grafo;

public class Profundidade extends Algoritmo {
	
	// Vetor de cores
	private String[] cor;
	// Guarda vértice precendete
	private Integer[] precedente;
	private Integer time;
	private Integer[] timestamp;
	// Tempo de início
	private Integer[] finishTime;
	
	/**
	 * Início de todas as variáveis, começa todas as cores com branco
	 * @param grafo
	 * @param origem
	 */
	public Profundidade(Grafo grafo, Integer origem)
	{
		super(grafo, origem);
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
		System.out.println("Iniciando o algoritmo em profundidade");
		visit(origem);
		System.out.println("Finalizado");
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
		
		// Percorre todos os vértices
		for ( int i = 0; i < this.grafo.vertices[current].size(); i++ ) {
			int next = (int) this.grafo.vertices[current].get(i)[0];
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
