package DesenhoGrafo;
import java.io.File;
import java.util.ArrayList;

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
    
      /**
     * Realiza o desenho do grafo
     * @param grafo
     * @param arestasDestacar (Resultado dos algoritmos Prim e Kruskall)
     * @param arestas
     * @param nome (Nome que será definido como GrafoEntrada, Prim ou Kruskall)
     */
    public void desenharGrafo(Grafo grafo, ArrayList<String> arestasDestacar, ArrayList<Aresta> arestas, String nome){
        MutableGraph grafoDesenho = mutGraph("Grafo").setDirected(grafo.getOrientado()).use((gr, ctx) -> {
            ArrayList<Aresta> destacar = new ArrayList<>();
            //Ordena as arestas de acordo com o menor inicio e menor destino
            arestas.sort((o1, o2) -> {
                if(o1.getInicio().compareTo(o2.getInicio()) == 0){
                    return o1.getDestino().compareTo(o2.getDestino());
                }
                else{
                    return o1.getInicio().compareTo(o2.getInicio());
                }
            });
            /*Converte o ArrayList de String das arestas de resultado (no caso de algoritmos Prim e Kruskall) em 
            ArrayList de Aresta*/
            if(arestasDestacar != null){
                destacar = getArestasDestacar(arestas, arestasDestacar);
            }
            //Percorre todas as arestas, são criados os nós e arestas do grafo em seguida
            for(int i = 0; i < arestas.size(); i++){
                if(grafo.getOrientado()){
                    mutNode(arestas.get(i).getDestino().toString());
                    Link aresta = mutNode(arestas.get(i).getDestino().toString()).linkTo();
                    aresta = aresta.with(Label.of(arestas.get(i).getPeso().toString()));
                    mutNode(arestas.get(i).getInicio().toString()).addLink(aresta);
                }
                else{
                    //Verifica se há ArrayList com resultado (para Prim e Kruskall)
                    if(arestasDestacar != null){
                        //Compara as arestas do grafo com as arestas de resultado para colorir as arestas de resultado
                        if(destacar.size() > 0 && 
                        (arestas.get(i).getInicio() == destacar.get(0).getInicio() &&
                        (arestas.get(i).getDestino() == destacar.get(0).getDestino()))){
                            Link aresta = mutNode(arestas.get(i).getDestino().toString()).linkTo();
                            aresta = aresta.with(Label.of(arestas.get(i).getPeso().toString()), Color.DODGERBLUE4);
                            mutNode(arestas.get(i).getInicio().toString()).addLink(aresta);
                            //Remove o primeiro elemento das arestas de resultado ate que nao haja mais elementos
                            if(destacar.size() != 0){
                                destacar.remove(0);
                            }
                        }
                        else{
                            Link aresta = mutNode(arestas.get(i).getDestino().toString()).linkTo();
                            aresta = aresta.with(Label.of(arestas.get(i).getPeso().toString()));
                            mutNode(arestas.get(i).getInicio().toString()).addLink(aresta);
                        }
                    }
                    else{
                        Link aresta = mutNode(arestas.get(i).getDestino().toString()).linkTo();
                        aresta = aresta.with(Label.of(arestas.get(i).getPeso().toString()));
                        mutNode(arestas.get(i).getInicio().toString()).addLink(aresta);
                    }
                }
            }
        });
        try{
            //Criacao do arquivo com a renderizacao do grafo de acordo com nome passado como argumento e data e hora
            DateTimeFormatter data = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
            Graphviz.fromGraph(grafoDesenho).width(500).render(Format.PNG).toFile(new File("src/GrafosDesenhados/" + nome + data.format(LocalDateTime.now()) + ".png"));
            System.out.println("Desenho gerado com sucesso\n");
        } catch(Exception e){
        }
    }

  /**
     * Retorna arestas do Arraylist de Strings em um ArrayList da Classe Aresta
     * @param arestas
     * @param arestasDestacar (Resultado dos algoritmos Prim e Kruskall)
     * @return ArrayList arestas
     */
    private ArrayList<Aresta> getArestasDestacar(ArrayList<Aresta> arestas, ArrayList<String> arestasDestacar){
        ArrayList<Aresta> destacadas = new ArrayList<>();
        if(arestasDestacar != null){
            for(int i = 0; i < arestasDestacar.size(); i++){
                String[] arestaDestaque = arestasDestacar.get(i).split(",");
                Aresta nova = new Aresta(Integer.valueOf(arestaDestaque[0]), Integer.valueOf(arestaDestaque[1]), -20000);
                destacadas.add(nova);
            }
        }
        destacadas.sort((o1, o2) -> {
            if(o1.getInicio().compareTo(o2.getInicio()) == 0){
                return o1.getDestino().compareTo(o2.getDestino());
            }
            else{
                return o1.getInicio().compareTo(o2.getInicio());
            }
        });
        return destacadas;
    }

}
