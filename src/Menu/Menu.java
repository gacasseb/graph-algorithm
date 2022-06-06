package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Algoritmos.BellmanFord;
import Algoritmos.Kruskall;
import Algoritmos.Largura;
import Algoritmos.Prim;
import Algoritmos.Profundidade;
import Grafo.Aresta;
import Grafo.Grafo;
import DesenhoGrafo.DesenhoGrafo;

public class Menu {
    
    public String menuPrincipal(Scanner sc){
        String entrada = null;
        System.out.println("Carregar Grafo");
        System.out.println("0. Sair");
        System.out.println("1.Carregar grafo");
        Integer opcao = sc.nextInt();
        while(opcao != 0){
            if(opcao == 1){
                System.out.println("Digite o caminho do arquivo:");
                entrada = sc.next();
                return entrada;
            }
            else{
                System.out.println("Opcao invalida, tente novamente");
                opcao = sc.nextInt();
            }
        }
        return entrada;
    }


    public void menuAlgoritmos(Grafo grafo, Scanner sc){
        ArrayList<Aresta> arestas = new ArrayList<>();
        Aresta a = new Aresta();
        arestas = a.getArestas(grafo);
        int entrada;
        Integer origem = 0;
        System.out.println("Selecione a opção de algoritmo ou desenhe o grafo:");
        System.out.println("0. Voltar");
        System.out.println("1. Busca em Profundidade");
        System.out.println("2. Busca em Largura");
        System.out.println("3. Bellman-Ford");
        System.out.println("4. Kruskal");
        System.out.println("5. Prim");
        System.out.println("6. Desenhar grafo");
        entrada = sc.nextInt();
        while(entrada != 0){
            if(entrada == 1){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                Profundidade algoritmo;
                algoritmo = new Profundidade(grafo, origem);
                algoritmo.run();
            }
            else if(entrada == 2){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                Largura algoritmo;
                algoritmo = new Largura(grafo, origem);
                algoritmo.run();
            }
            else if(entrada == 3){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                BellmanFord algoritmo;
                algoritmo = new BellmanFord(grafo, origem);
                algoritmo.run(origem);
            }
            else if(entrada == 4){
                Kruskall algoritmo;
                algoritmo = new Kruskall(grafo, 0);
                algoritmo.run();
            }
            else if(entrada == 5){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                Prim algoritmo;
                algoritmo = new Prim(grafo, origem);
                algoritmo.run();
            }
            else if(entrada == 6){
                DesenhoGrafo desenho = new DesenhoGrafo();
                if(!grafo.getOrientado()){
                    a.ordenarPeso(arestas, arestas.size());
                    a.removerRepetidos(arestas);
                }
                desenho.desenharGrafo(grafo, null, arestas);

            }
             else{
                System.out.println("Entrada inválida, tente novamente");
                entrada = sc.nextInt();
            }
        
            System.out.println("Selecione a opção de algoritmo ou desenhe o grafo:");
            System.out.println("0. Voltar");
            System.out.println("1. Busca em Profundidade");
            System.out.println("2. Busca em Largura");
            System.out.println("3. Bellman-Ford");
            System.out.println("4. Kruskal");
            System.out.println("5. Prim");
            System.out.println("6. Desenhar grafo");
            entrada = sc.nextInt();
        }
    }

}
