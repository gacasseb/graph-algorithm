package Algoritmos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;

import javax.lang.model.type.NoType;
import javax.lang.model.util.Elements.Origin;

import com.kitfox.svg.A;

import Grafo.Aresta;
import Grafo.Grafo;

public class Prim extends Algoritmo{
    private ArrayList<Integer> pi= new ArrayList<>();
    private ArrayList<Integer> key = new ArrayList<>();

    public Prim(Grafo grafo, Integer origem){
        super(grafo, origem);
        for(int i = 0; i < grafo.getNumVertices(); i++){
            pi.add(-1);
            key.add(Integer.MAX_VALUE/2);
        }
        pi.set(origem, null);
        key.set(origem, 0);
    }

    public void prim(Integer origem){
        ArrayList<Integer> Q = new ArrayList<>();
        ArrayList<Aresta> arestas = new ArrayList<>();
        Aresta aresta = new Aresta();
        arestas = aresta.getArestas(grafo);
        aresta.ordenarPeso(arestas, arestas.size());
        if(grafo.getOrientado()){
            System.out.println("Nao foi possivel executar, o grafo nao pode ser orientado");
        }
        else{
            Q.add(origem);
            for(int i = 0; i < grafo.getNumVertices(); i++){
                if(i != origem){
                    Q.add(i);
                }
            }
            while(!Q.isEmpty()){
                Integer minimo;
                minimo = Q.get(ordenarQ(Q));
                Q.remove(minimo);
                for(int i = 0; i < grafo.getNumVertices(); i++){
                    ArrayList<Integer> aux = new ArrayList<>();
                    for(int j = 0; j < arestas.size(); j++){
                        if(arestas.get(j).getInicio() == minimo && Q.contains(arestas.get(j).getDestino())){
                            if(arestas.get(j).getPeso() < key.get(arestas.get(j).getDestino())){
                                aux.add(arestas.get(j).getDestino());
                                pi.set(arestas.get(j).getDestino(), arestas.get(j).getInicio());
                                key.set(arestas.get(j).getDestino(), arestas.get(j).getPeso());
                            }
                        }
                    }
                    Q = extrairVerticesMinimo(Q, aux);
                    aux.addAll(Q);
                    Q = new ArrayList<>(aux);
                }
            }
        }
    }

    private void imprimirResultado(Integer origem){
        System.out.println("vertice inicial: " + origem);
        int pesoTotal = 0;
        for(int i = 0; i < key.size(); i++){
            pesoTotal = pesoTotal + key.get(i);
        }
        System.out.println("Peso total: " + pesoTotal);
        System.out.print("Arestas: ");
        for(int i = 0; i < pi.size(); i++){
            if(i != origem){
                System.out.print("(" + pi.get(i) + "," + i + ") ");
            }
        }
        System.out.println();
    }

    private Integer ordenarQ(ArrayList<Integer> Q){
        Integer menor = Q.get(0);
        Integer posicao = 0;
        for(int i = 1; i < Q.size(); i++){
            if(key.get(menor) > key.get(Q.get(i))){
                menor = Q.get(i);
                posicao = i;
            }
        }
        return posicao;
    }

    private ArrayList<Integer> extrairVerticesMinimo(ArrayList<Integer> Q, ArrayList<Integer> aux){
        for(int i = 0; i < aux.size(); i++){
            Q.remove(aux.get(i));
        }
        return Q;
    }

    public void run()
	{
        ArrayList<String> resultado = new ArrayList<>();
		System.out.println("Iniciando o algoritmo de Bellman Ford\n");
		prim(origem);
        imprimirResultado(origem);
		System.out.println("\nFinalizado");
	}

     


}
