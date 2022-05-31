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
        if(d.get(u[0]) > d.get(v[0]) + v[1]){
            d.add(v[0], d.get(u[0]) + v[1]);
            pi.add(v[0], u[0]);
        }
    }

    

}
