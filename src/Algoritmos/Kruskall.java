package Algoritmos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import javax.sql.rowset.spi.SyncProviderException;
import Grafo.Grafo;
import Grafo.Aresta;

public class Kruskall extends Algoritmo{
    public Kruskall(Grafo grafo, Integer origem){
        super(grafo, origem);
    }
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
            aresta.printArestas(arestas);
            for(int i = 0; i < arestas.size(); i++){
                if(conjuntos.get(arestas.get(i).getInicio()) != conjuntos.get(arestas.get(i).getDestino())){
                    String arestaAInserir;
                    arestaAInserir = "(" + arestas.get(i).getInicio() + "," + arestas.get(i).getDestino() + ")";
                    A.add(arestaAInserir);
                    LinkedList<Integer> conjunto = new LinkedList<>();
                    conjunto.add(arestas.get(i).getInicio());
                    conjunto.add(arestas.get(i).getDestino());
                    conjuntos.set(arestas.get(i).getInicio(), conjunto);
                    conjuntos.remove(arestas.get(i).getDestino());
                }
            }
        }
        return A;
    }

    public void run()
	{
        ArrayList<String> resultado = new ArrayList<>();
		System.out.println("Iniciando o algoritmo de Bellman Ford");
		resultado = kruskall();
        imprimirResultado(resultado);
		System.out.println("\nFinalizado");
	}

    public void imprimirResultado(ArrayList<String> resultado){
        for(int i = 0; i < resultado.size(); i++){
            System.out.print(resultado.get(i) + " ");
        }
        System.out.println();
    }
}
