package Menu;

import java.util.Scanner;

import Grafo.Grafo;
import Algoritmos.Profundidade;
import Algoritmos.Largura;
import Algoritmos.BellmanFord;
import guru.nidi.graphviz.model.Graph;

public class Menu {
    
    public String menuPrincipal(Scanner sc){
        System.out.println("Carregar grafo");
        System.out.println("Digite o caminho do arquivo:");
        String entrada = sc.nextLine();
        return entrada;
    }


    public void menuAlgoritmos(Grafo grafo, Scanner sc){
        System.out.println("Selecione a opção de algoritmo ou desenhe o grafo:");
        System.out.println("0. Sair");
        //System.out.println("1. Carregar Grafo");
        System.out.println("1. Busca em Profundidade");
        System.out.println("2. Busca em Largura");
        System.out.println("3. Bellman-Ford");
        System.out.println("4. Kruskal");
        System.out.println("5. Prim");
        System.out.println("6. Desenhar grafo");
        int entrada = 1;
        while(entrada != 0){
            if(entrada == 1){
            }
            else if(entrada == 2){
                Profundidade algoritmo;
                algoritmo = new Profundidade(grafo, origem);
                algoritmo.run();
            }
            else if(entrada == 3){
                Largura algoritmo;
                algoritmo = new Largura(grafo, origem);
                algoritmo.run();
            }
            else if(entrada == 4){
                BellmanFord algoritmo;
                algoritmo = new BellmanFord(grafo, origem);
            }
            else if(entrada == 5){
        
            }
            else if(entrada == 6){
                if(grafo.getOrientado() == true){
                    
                }
                else{

                }
            }
             else{
                System.out.println("Entrada inválida, tente novamente");
                entrada = sc.nextInt();
            }
            System.out.println("Selecione a opção de algoritmo ou desenhe o grafo:");
            System.out.println("0. Sair");
            System.out.println("1. Carregar Grafo");
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
