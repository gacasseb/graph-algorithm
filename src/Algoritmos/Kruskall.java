package Algoritmos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import javax.sql.rowset.spi.SyncProviderException;
import Grafo.Grafo;
import Grafo.Aresta;

public class Kruskall extends Algoritmo {
	
	/**
	 * 
	 * @param grafo
	 * @param origem
	 */
    public Kruskall(Grafo grafo, Integer origem) {
        super(grafo, origem);
    }
    
    /**
     * Roda algoritmo principal do algoritmo de Kruskall
     * @return
     */
    private ArrayList<String> kruskall(){
        ArrayList<Aresta> arestas = new ArrayList<>();
        ArrayList<LinkedList<Integer>> conjuntos = new ArrayList<>();
        Aresta aresta = new Aresta();
        arestas = aresta.getArestas(grafo);
        ArrayList<String> A = new ArrayList<>();
        if(grafo.getOrientado()){
            System.out.println("Nao foi possivel executar, o grafo nao pode ser orientado");
        }
        else{
            for(int i = 0; i < grafo.getNumVertices(); i++){
                LinkedList<Integer> conjunto = new LinkedList<>();
                conjunto.add(i);
                conjuntos.add(conjunto);
            }
            aresta.ordenarPeso(arestas, arestas.size());
            aresta.removerRepetidos(arestas);
            for(int i = 0; i < arestas.size(); i++){
                LinkedList<Integer> l1;
                LinkedList<Integer> l2;
                l1 = conjuntos.get(localizarPosConjunto(conjuntos, arestas.get(i).getInicio()));
                l2 = conjuntos.get(localizarPosConjunto(conjuntos, arestas.get(i).getDestino()));
                if(!l1.equals(l2)){
                    String arestaAInserir;
                    arestaAInserir = arestas.get(i).getInicio().toString() + "," + arestas.get(i).getDestino().toString();
                    A.add(arestaAInserir);
                    LinkedList<Integer> conjunto = new LinkedList<>();
                    for(int j = 0; j < l1.size(); j++){
                        conjunto.add(l1.get(j));
                    }
                    for(int j = 0; j < l2.size(); j++){
                        conjunto.add(l2.get(j));
                    }
                    conjuntos.remove((int)localizarPosConjunto(conjuntos, l2.get(0)));
                    conjuntos.set(localizarPosConjunto(conjuntos, conjunto.get(0)), conjunto);
                }
            }
        }
        System.out.println("Peso total: " + getPeso(A, arestas));
        return A;
    }

    /**
     * Retorna peso da aresta
     * @param A
     * @param arestas
     * @return
     */
    private Integer getPeso(ArrayList<String> A, ArrayList<Aresta> arestas){
        Integer peso = 0;
        Integer inicio, destino;
        String[] resultado;
        String elemento;
        for(int i = 0; i < A.size(); i++){
            elemento = A.get(i);
            resultado = elemento.split(",");
            inicio = Integer.parseInt(resultado[0]);
            destino = Integer.parseInt(resultado[1]);
            for(int j = 0; j < arestas.size(); j++){
                if((arestas.get(j).getInicio() == inicio) && (arestas.get(j).getDestino() == destino)){
                    peso = peso + arestas.get(j).getPeso();
                }
            }
            
        }
        return peso;
    }

    /**
     * Busca posição do vértice no conjunto
     * @param conjuntos
     * @param vertice
     * @return posição do vértice no conjunto
     */
    private Integer localizarPosConjunto(ArrayList<LinkedList<Integer>> conjuntos, Integer vertice){
        for(int i = 0; i < conjuntos.size(); i++){
            for(int j = 0; j < conjuntos.get(i).size(); j++){
                if(conjuntos.get(i).contains(vertice)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Imprime no console os conjuntos
     * @param conjuntos
     */
    private void imprimirConjuntos(ArrayList<LinkedList<Integer>> conjuntos){
        for(int i = 0; i < conjuntos.size(); i++){
            System.out.print("{ ");
            for(int j = 0; j < conjuntos.get(i).size(); j++){
                System.out.print(conjuntos.get(i).get(j) + " ");
            }
            System.out.print(" }");
        }
        System.out.println("\n");
    }

    /**
     * Gatilho para iniciar o algoritmo de Kruskall
     */
    public ArrayList<String> run()
	{
        ArrayList<String> resultado = new ArrayList<>();
		System.out.println("Iniciando o algoritmo de Kruskall\n");
		resultado = kruskall();
        imprimirResultado(resultado);
		System.out.println("\nFinalizado");
        return resultado;
	}

    /**
     * Imprime os resultados gerados
     * @param resultado
     */
    private void imprimirResultado(ArrayList<String> resultado){
        for(int i = 0; i < resultado.size(); i++){
            System.out.print("(" + resultado.get(i) + ") ");
        }
        System.out.println();
    }
}
