package Algoritmos;

import java.util.ArrayList;
import java.util.Comparator;

import javax.sql.rowset.spi.SyncProviderException;
import Grafo.Grafo;
import Grafo.Aresta;

public class Kruskall extends Algoritmo{
    public Kruskall(Grafo grafo, Integer origem){
        super(grafo, origem);
    }
    private ArrayList<ArrayList<Integer>> kruskall(){
        ArrayList<Aresta> arestas = new ArrayList<>();
        Aresta aresta = new Aresta();
        arestas = aresta.getArestas(grafo);
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        if(grafo.getOrientado()){
            System.out.println("Nao foi possivel executar, o grafo nao pode ser orientado");
        }
        else{
            aresta.ordenarPeso(arestas, arestas.size());
            aresta.removerRepetidos(arestas);
            aresta.printArestas(arestas);
        }

        return A;
    }

    public void run()
	{
		System.out.println("Iniciando o algoritmo de Bellman Ford");
		kruskall();
		System.out.println("\nFinalizado");
	}
}
