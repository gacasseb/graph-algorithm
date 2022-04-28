package Grafo;

import java.util.LinkedList;

public class Grafo {
	private boolean orientado;
	public LinkedList[] vertices;
	
	public boolean getOrientado()
	{
		return orientado;
	}
	
	/**
	 * Carrega os atributos da classe Grafo a partir do arquivo
	 */
	public boolean load(String[] file)
	{
		return true;
	}
	
	/**
	 * Carrega os atributos do Grafo com valores
	 */
	public void randomLoad()
	{
		orientado = true;
		this.vertices = new LinkedList[7];
		
		LinkedList<Integer> vertice0;
		vertice0 = new LinkedList<Integer>();
		vertice0.add(2);
		vertice0.add(3);
		vertice0.add(5);
		
		LinkedList<Integer> vertice1;
		vertice1 = new LinkedList<Integer>();
		vertice1.add(3);
		vertice1.add(4);
		
		LinkedList<Integer> vertice2;
		vertice2 = new LinkedList<Integer>();
		vertice2.add(0);
		vertice2.add(3);
		vertice2.add(4);
		vertice2.add(5);
		
		LinkedList<Integer> vertice3;
		vertice3 = new LinkedList<Integer>();
		vertice3.add(0);
		vertice3.add(1);
		vertice3.add(2);
				
		LinkedList<Integer> vertice4;
		vertice4 = new LinkedList<Integer>();
		vertice4.add(1);
		vertice4.add(2);
		vertice4.add(5);
		vertice4.add(6);
		
		LinkedList<Integer> vertice5;
		vertice5 = new LinkedList<Integer>();
		vertice5.add(0);
		vertice5.add(2);
		vertice5.add(4);
		vertice5.add(6);
		
		LinkedList<Integer> vertice6;
		vertice6 = new LinkedList<Integer>();
		vertice6.add(4);
		vertice6.add(5);
			
		this.vertices[0] = vertice0;
		this.vertices[1] = vertice1;
		this.vertices[2] = vertice2;
		this.vertices[3] = vertice3;
		this.vertices[4] = vertice4;
		this.vertices[5] = vertice5;
		this.vertices[6] = vertice6;
	}
}
