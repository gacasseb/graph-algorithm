package DesenhoGrafo;
import java.io.File;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Scanner;

import Grafo.Aresta;
import Grafo.Grafo;

import static guru.nidi.graphviz.model.Factory.mutGraph;
import static guru.nidi.graphviz.model.Factory.mutNode;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.attribute.Label;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Link;
import guru.nidi.graphviz.model.MutableGraph;

public class DesenhoGrafo {
    public void desenharGrafo(Grafo grafo, ArrayList<String> arestasDestacar, ArrayList<Aresta> arestas){
        MutableGraph grafoDesenho = mutGraph("Grafo").setDirected(grafo.getOrientado()).use((gr, ctx) -> {
            for(int i = 0; i < arestas.size(); i++){
                if(grafo.getOrientado()){
                    mutNode(arestas.get(i).getDestino().toString());
                    Link aresta = mutNode(arestas.get(i).getDestino().toString()).linkTo();
                    aresta = aresta.with(Label.of(arestas.get(i).getPeso().toString()));
                    mutNode(arestas.get(i).getInicio().toString()).addLink(aresta);
                }
                else{
                    Link aresta = mutNode(arestas.get(i).getDestino().toString()).linkTo();
                    aresta = aresta.with(Label.of(arestas.get(i).getPeso().toString()));
                    mutNode(arestas.get(i).getInicio().toString()).addLink(aresta);
                }
            }
            /* 
            for(int i = 0; i < grafo.getNumVertices(); i++){
                String vertice = String.valueOf(i);
                mutNode(vertice);
                for(int j = 0; j < grafo.vertices[i].size(); j++){
                    if(grafo.getOrientado()){
                        mutNode(arestas.get(j).getDestino().toString());
                        Link aresta = mutNode(arestas.get(j).getDestino().toString()).linkTo();
                        aresta = aresta.with(Label.of(arestas.get(j).getPeso().toString()));
                        mutNode(arestas.get(i+j).getInicio().toString()).addLink(aresta);
                    }
                    else{
                        Link aresta = mutNode(arestas.get(j).getDestino().toString()).linkTo();
                        aresta = aresta.with(Label.of(arestas.get(j).getPeso().toString()));
                        mutNode(arestas.get(i+j).getInicio().toString()).addLink(aresta);
                    }
                }
            }
            */
        });
        try{
            DateTimeFormatter data = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
            Graphviz.fromGraph(grafoDesenho).width(500).render(Format.PNG).toFile(new File("src/GrafosDesenhados/" + data.format(LocalDateTime.now()) + ".png"));
            System.out.println("Desenho gerado com sucesso\n");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
