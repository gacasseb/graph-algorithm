package Grafo;

import java.util.ArrayList;

public class Aresta {
    Integer inicio;
    Integer destino;
    Integer peso;

    /**
     * Inicio das variáveis de Aresta
     */
    public Aresta(){
        this.destino = -1;
        this.inicio = -1;
        this.peso = Integer.MAX_VALUE;
    }

    /**
     * Inicio das variáveis de Aresta
     * @param inicio
     * @param destino
     * @param peso
     */
    public Aresta(Integer inicio, Integer destino, Integer peso){
        this.inicio = inicio;
        this.destino = destino;
        this.peso = peso;
    }
    /**
     * Retorna arestas em um arrayList
     * @param grafo
     * @return ArrayList arestas
     */
    public ArrayList<Aresta> getArestas(Grafo grafo){
        ArrayList<Aresta> arestas = new ArrayList<>();
        for(int i = 0; i < grafo.getNumVertices(); i++){
            for(int j = 0; j < grafo.vertices[i].size(); j++){
                Aresta novaAresta = new Aresta(i, grafo.vertices[i].get(j)[0], grafo.vertices[i].get(j)[1]);
                arestas.add(novaAresta);
            }
        }
        return arestas;
    }

    /**
     * Printa em consolo todas as arestas
     * @param arestas
     */
    public void printArestas(ArrayList<Aresta> arestas){
        for(int i = 0; i < arestas.size(); i++){
            System.out.print("Inicio: ");
            System.out.println(arestas.get(i).inicio);
            System.out.print("Destino: ");
            System.out.println(arestas.get(i).destino);
            System.out.print("Peso: ");
            System.out.println(arestas.get(i).peso);
        }
    }

    /**
     * Faz a ordenação de peso das arestas
     * @param arestas
     * @param n
     */
    public void ordenarPeso(ArrayList<Aresta> arestas, Integer n){
        if(n <= 1){
            return;
        }

        ordenarPeso(arestas, n-1);

        Aresta ultimo = arestas.get(n-1);
        int j = n - 2;

        while(j >= 0 && arestas.get(j).peso > ultimo.peso){
            arestas.set(j+1, arestas.get(j));
            j--;
        }
        arestas.set(j+1, ultimo);

    }

    /**
     * Remove todas arestas repetidas
     * @param arestas
     * @return
     */
    public void removerRepetidos(ArrayList<Aresta> arestas){
        for(int i = 0; i < arestas.size() - 1; i++){
            if(arestas.get(i).inicio == arestas.get(i+1).destino && arestas.get(i).destino == arestas.get(i+1).inicio){
                arestas.remove(i+1);
            }
        }
    }

    /**
     * Retorna inicio
     * @return
     */
    public Integer getInicio(){
        return this.inicio;
    }

    /***
     * Retorna destino
     * @return
     */
    public Integer getDestino(){
        return this.destino;
    }

    /**
     * Retorna peso da aresta
     * @return
     */
    public Integer getPeso(){
        return this.peso;
    }
}
