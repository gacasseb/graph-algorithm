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
            d.add(Integer.MAX_VALUE/2);
        }
        d.set(origem, 0);
    }

    private void relax(Aresta aresta){
        if(d.get(aresta.getDestino()) > d.get(aresta.getInicio()) + aresta.getPeso()){
            d.set(aresta.getDestino(), d.get(aresta.getInicio()) + aresta.getPeso());
            pi.set(aresta.getDestino(), aresta.getInicio());
        }
        System.out.println(d);
        System.out.println(pi);
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
            System.out.println("\n\n\n");
            for(int i = 1; i < grafo.getNumVertices() - 1; i++){
                for(int j = 0; j < arestas.size(); j++){
                    relax(arestas.get(j));
                }
            }
            System.out.println(arestas.size());
            for(int k = 0; k < arestas.size(); k++){
                if(d.get(arestas.get(k).getDestino()) > d.get(arestas.get(k).getInicio())+ arestas.get(k).getPeso()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void imprimirResultado(Integer origem){
        int j, k = 0, w;
        System.out.println("\nOrigem: " + origem);
        for(int i = 0; i < grafo.getNumVertices(); i++){
            ArrayList<Integer> caminho = new ArrayList<>();
            System.out.print("Destino: " + i + " ");
            System.out.print("Distancia: " + d.get(i) + " ");
            j = i;
            System.out.print("Caminho: ");
            while(pi.get(j) != null){
                if(k >= grafo.getNumVertices()){
                    break;
                }
                caminho.add(pi.get(j));
                j = pi.get(j);
            }
            k = caminho.size();
            w = k - 1;
            while(w >= 0){
                System.out.print(caminho.get(w) + " - ");
                w--;
            }
            System.out.println(i);
        }
    }

    public void run(Integer origem)
	{
		System.out.println("Iniciando o algoritmo de Bellman Ford");
        boolean resultado;
		resultado = bellmanFord(origem);
        if(resultado){
            System.out.println("Executado com sucesso");
            imprimirResultado(origem);    
        }
        else{
            System.out.println("Erro: ciclo negativo no grafo");
        }
		System.out.println("\nFinalizado");
	}

}
