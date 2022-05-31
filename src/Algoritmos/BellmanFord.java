package Algoritmos;

import java.util.ArrayList;

import Grafo.Grafo;

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

    private void relax(int[] u, int[] v){
        System.out.print("d[v] :");
        System.out.println(d.get(v[0]));
        System.out.print("d[u]: ");
        System.out.println(d.get(u[0]));
        System.out.print("peso: ");
        System.out.println(v[1]);
        if(d.get(v[0]) > d.get(u[0]) + v[1]){
            d.add(v[0], d.get(u[0]) + v[1]);
            pi.add(v[0], u[0]);
        }
    }

    private Boolean bellmanFord(Integer origem){
        if(!grafo.getOrientado()){
            System.out.println("Nao foi possivel executar, o grafo deve ser orientado");
        }
        else{
            grafo.printVertices();
            for(int i = 0; i < grafo.getNumVertices(); i++){
                for(int j = 0; j < grafo.vertices[i].size(); j++){
                    int[] aresta;
                    aresta = new int[2];
                    aresta = grafo.vertices[i].get(j);
                    relax(grafo.vertices[i].get(j), aresta);
                    System.out.println(d);
                    System.out.println(pi);
                }
            }
            for(int i = 0; i < grafo.getNumVertices(); i++){
                for(int j = 0; j < grafo.vertices[i].size(); j++){
                    int[] aresta = new int[2];
                    aresta = grafo.vertices[i].get(j);
                    System.out.println(aresta[0]);
                    if(d.get(aresta[0]) > d.get(grafo.vertices[i].get(j)[0]) + aresta[1]){
                        System.out.println("Nao foi possivel executar, ciclo de peso negativo");
                        return false;
                    }
                }
            }
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
