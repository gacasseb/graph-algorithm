package Grafo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Grafo {
	private boolean orientado;
	private int numVertices;
	public LinkedList<int[]>[] vertices;
	
	public boolean getOrientado()
	{
		return orientado;
	}
	
	public int getNumVertices()
	{
		return numVertices;
	}
	
	public LinkedList<int[]>[] getVertices()
	{
		return vertices;
	}
	
	/**
	 * Carrega os atributos da classe Grafo a partir do arquivo
	 * @throws IOException 
	 */
	public boolean load(BufferedReader file)
	{
		try {
			int i = 0;
			String line;
			while ((line = file.readLine()) != null) {
//				System.out.println(line);
				
				if ( i == 0 ) {
					loadOrientacao(line);
					
				} else if ( i == 1 ) {
					loadNumVertices(line);
					
				} else {
					loadVertice(line);
				}
				
				i++;
			}
			
		} catch (IOException error) {
			System.out.println("Um erro aconteceu durante a leitura do arquivo");
			error.printStackTrace();
		}
		
		return true;
	}
	
	public void printVertices()
	{
		for (int i=0; i < this.vertices.length; i++) {
			System.out.println("Vertice: " + i);
			for (int j=0; j < vertices[i].size(); j++ ) {
				System.out.println( "	" + vertices[i].get(j)[0] + ":" + vertices[i].get(j)[1]);
			}
		}
	}
	
	private void loadVertice(String line)
	{
		String[] split = line.split(":");
		String[] edges = split[0].split(",");
		
		for ( int i=0; i < edges.length; i++ ) {	
			edges[i] = edges[i].replaceAll("[^0-9]", "");
		}
	
		int weight = Integer.parseInt(split[1]);
		LinkedList<int[]> vertice;
		int pointer[] = new int[2];
		
		if (this.vertices[Integer.parseInt(edges[0])] != null) {
			vertice = this.vertices[Integer.parseInt(edges[0])];
			
		} else {
			vertice = new LinkedList<int[]>();
		}
		
		pointer[0] = Integer.parseInt(edges[1]);
		pointer[1] = weight;
			
		vertice.add(getOrdenedPosition(Integer.parseInt(edges[0]), pointer[0]), pointer);
							
		this.vertices[Integer.parseInt(edges[0])] = vertice;
		
		if ( !orientado ) {
			
			LinkedList<int[]> segundoVertice;
			int segundoPointer[] = new int[2];
						
			if (this.vertices[Integer.parseInt(edges[1])] != null) {
				segundoVertice = this.vertices[Integer.parseInt(edges[1])];
				
			} else {
				segundoVertice = new LinkedList<int[]>();
			}
			
			segundoPointer[0] = Integer.parseInt(edges[0]);
			segundoPointer[1] = weight;
			
			segundoVertice.add(getOrdenedPosition(Integer.parseInt(edges[1]), pointer[0]), segundoPointer);
			
			this.vertices[Integer.parseInt(edges[1])] = segundoVertice;
		}
	}
	
	private int getOrdenedPosition(int edge, int newEdge)
	{
		int position = 0;
		if ( this.vertices[edge] != null ) {			
			for (int i=0; i < this.vertices[edge].size(); i++) {
				if ( this.vertices[edge].get(i)[0] > newEdge ) {
					return i;
				}
				position = i+1;
			}
		}
		
		return position;
	}
	
	/**
	 *	Carrega a orientação do grafo
	 *	@param line
	 */
	private void loadOrientacao(String line)
	{
		String[] split = line.split("=");
		
		if ( split[1].contains("sim") ) {
			this.orientado = true;
			
		} else {
			this.orientado = false;
		}
	}
	
	/**
	 * Carrega o número de vértices do grafo
	 * @param line
	 */
	@SuppressWarnings("unchecked")
	private void loadNumVertices(String line)
	{
		String[] split = line.split("=");
		
		this.numVertices = Integer.parseInt(split[1]);
		this.vertices = new LinkedList[numVertices];
	}
	
	public void imprimirGrafo(){

	}
}
