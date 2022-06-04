package Algoritmos;

import java.util.ArrayList;

import Grafo.Grafo;
import Grafo.Aresta;

public class BellmanFord extends Algoritmo{
    private ArrayList<Integer> pi= new ArrayList<>();
    private ArrayList<Integer> d = new ArrayList<>();

    public BellmanFord(Grafo grafo, Integer origem){
        super(grafo, origem);
        for(int i = 0; i < grafo.getNumVertices(); i++){
            pi.add(null);
            d.add(30000);
        }
        d.add(origem, 0);
    }

    private void relax(Aresta aresta, Integer origem){
        System.out.print("d[v] :");
        System.out.println(d.get(aresta.getInicio()));
        System.out.print("d[u]: ");
        System.out.println(d.get(aresta.getDestino()));
        System.out.print("peso: ");
        System.out.println(aresta.getPeso());
        if(d.get(aresta.getInicio()) > d.get(aresta.getDestino()) + aresta.getPeso()){
            if(d.get(aresta.getInicio()) == 30000 || aresta.getDestino() != origem){
                d.add(aresta.getDestino(), aresta.getPeso());
            }
            else{
                d.add(aresta.getDestino(), d.get(aresta.getInicio()) + aresta.getPeso());
            }
            pi.add(aresta.getDestino(), aresta.getInicio());
        }
    }

    private Boolean bellmanFord(Integer origem){
        if(!grafo.getOrientado()){
            System.out.println("Nao foi possivel executar, o grafo deve ser orientado");
        }
        else{
            grafo.printVertices();
            Aresta aresta = new Aresta();
            ArrayList<Aresta> arestas = new ArrayList<>();
            arestas = aresta.getArestas(grafo);
            System.out.println(d);
            System.out.println(pi);
            for(int i = 1; i < grafo.getNumVertices() - 1; i++){
                for(int j = 0; j < arestas.size(); j++){
                    relax(arestas.get(j), origem);
                    System.out.println(d);
                    System.out.println(pi);
                }
            }
            /*
            for(int i = 0; i < grafo.getNumVertices(); i++){
                for(int j = 0; j < grafo.vertices[i].size(); j++){
                    if(d.get(aresta[0]) > d.get(grafo.vertices[i].get(j)[0]) + aresta[1]){
                        System.out.println("Nao foi possivel executar, ciclo de peso negativo");
                        return false;
                    }
                }
            }
            */
            return true;
        }
        return false;
    }

    public void run(Integer origem)
	{
		System.out.println("Iniciando o algoritmo de Bellman Ford");
		bellmanFord(origem);
		System.out.println("\nFinalizado");
	}

}
