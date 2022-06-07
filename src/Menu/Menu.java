package Menu;

import java.io.IOException;
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
    
	/**
	 * Printa e gerencia menu principal
	 * @param sc
	 * @return
	 */
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


    /**
     * Printa e gerencia menu de algoritmos
     * @param grafo
     * @param sc
     */
    public void menuAlgoritmos(Grafo grafo, Scanner sc){
        DesenhoGrafo desenho = new DesenhoGrafo();
        ArrayList<Aresta> arestas = new ArrayList<>();
        ArrayList<String> resultadoPrimKruskall = new ArrayList<>();
        Aresta a = new Aresta();
        arestas = a.getArestas(grafo);
        int entrada;
        Integer origem = 0;
        System.out.println("Selecione a opção de algoritmo ou desenhe o grafo:");
        System.out.println("0. Sair");
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
                pressionarEnterParaContinuar();
                limparTela();
            }
            else if(entrada == 2){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                Largura algoritmo;
                algoritmo = new Largura(grafo, origem);
                algoritmo.run();
                pressionarEnterParaContinuar();
                limparTela();
            }
            else if(entrada == 3){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                BellmanFord algoritmo;
                algoritmo = new BellmanFord(grafo, origem);
                algoritmo.run(origem);
                pressionarEnterParaContinuar();
                limparTela();
            }
            else if(entrada == 4){
                Kruskall algoritmo;
                algoritmo = new Kruskall(grafo, 0);
                resultadoPrimKruskall = algoritmo.run();
                a.ordenarPeso(arestas, arestas.size());
                a.removerRepetidos(arestas);
                desenho.desenharGrafo(grafo, resultadoPrimKruskall, arestas, "Kruskall");
                pressionarEnterParaContinuar();
                limparTela();
            }
            else if(entrada == 5){
                System.out.println("Digite o vertice de origem");
                origem = sc.nextInt();
                Prim algoritmo;
                algoritmo = new Prim(grafo, origem);
                resultadoPrimKruskall = algoritmo.run();
                a.ordenarPeso(arestas, arestas.size());
                a.removerRepetidos(arestas);
                desenho.desenharGrafo(grafo, resultadoPrimKruskall, arestas, "Prim");
                pressionarEnterParaContinuar();
                limparTela();
            }
            else if(entrada == 6){
                if(!grafo.getOrientado()){
                    a.ordenarPeso(arestas, arestas.size());
                    a.removerRepetidos(arestas);
                }
                desenho.desenharGrafo(grafo, null, arestas, "GrafoEntrada");
                pressionarEnterParaContinuar();
                limparTela();
            }
             else{
                System.out.println("Entrada inválida, tente novamente");
                entrada = sc.nextInt();
            }
            System.out.println("Selecione a opção de algoritmo ou desenhe o grafo:");
            System.out.println("0. Sair");
            System.out.println("1. Busca em Profundidade");
            System.out.println("2. Busca em Largura");
            System.out.println("3. Bellman-Ford");
            System.out.println("4. Kruskal");
            System.out.println("5. Prim");
            System.out.println("6. Desenhar grafo");
            entrada = sc.nextInt();
        }
    }

    /**
     * Limpa o console
     */
    public static void limparTela(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    /**
     * Aguarda a entrada de um enter do teclado para gerenciamento das telas dos menus
     */
    private void pressionarEnterParaContinuar(){ 
           System.out.println("Pressione Enter para continuar");
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
}
