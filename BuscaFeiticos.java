package exercicios19MaioJavaFiama;

import java.util.Scanner;

/**
 * Busca Binária no Mundo dos Feitiços
 * Este programa implementa uma busca binária para encontrar um feitiço
 * em uma lista ordenada de feitiços mágicos.
 */
public class BuscaFeiticos {
    public static void main(String[] args) {
        // Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Boas-vindas
        System.out.println("=== BIBLIOTECA MÁGICA DE HOGWARTS ===");
        System.out.println("Sistema de Busca de Feitiços\n");
        
        // Definir a lista de feitiços (já ordenada alfabeticamente)
        String[] feiticos = {
            "Accio", "Alohomora", "Avada Kedavra", "Crucio", "Defensio",
            "Expecto Patronum", "Expelliarmus", "Finite Incantatem", "Imperius", 
            "Lumos", "Nox", "Obliviate", "Petrificus Totalus", "Riddikulus", "Wingardium Leviosa"
        };
        
        // Mostrar os feitiços disponíveis
        System.out.println("Lista de feitiços disponíveis:");
        for (int i = 0; i < feiticos.length; i++) {
            System.out.println((i+1) + ". " + feiticos[i]);
        }
        
        // Solicitar o feitiço a ser pesquisado
        System.out.print("\nQual feitiço você deseja encontrar? ");
        String feiticoBuscado = scanner.nextLine();
        
        // Realizar a busca binária
        int posicao = buscaBinaria(feiticos, feiticoBuscado);
        
        // Mostrar o resultado
        if (posicao != -1) {
            System.out.println("\nFeitiço encontrado na posição " + posicao);
            System.out.println("O feitiço '" + feiticos[posicao] + "' está na prateleira " + (posicao + 1) + "!");
        } else {
            System.out.println("\nO feitiço '" + feiticoBuscado + "' não foi encontrado em nossa biblioteca.");
            System.out.println("Talvez você queira consultar a Seção Restrita?");
        }
        
        // Fechar o scanner
        scanner.close();
    }
    
    /**
     * Implementa o algoritmo de busca binária
     * 
     * @param feiticos Array de feitiços ordenado
     * @param feiticoBuscado Feitiço que está sendo procurado
     * @return índice do feitiço encontrado ou -1 se não encontrar
     */
    private static int buscaBinaria(String[] feiticos, String feiticoBuscado) {
        // Imprimir uma mensagem para mostrar que a busca está começando
        System.out.println("\nIniciando busca mágica...");
        
        int inicio = 0;                   // Início da área de busca
        int fim = feiticos.length - 1;    // Fim da área de busca
        int tentativas = 0;               // Contador de tentativas
        
        // Enquanto houver área para procurar
        while (inicio <= fim) {
            // Incrementa o contador de tentativas
            tentativas++;
            
            // Calcula o meio da área atual
            int meio = (inicio + fim) / 2;
            
            // Mostra o processo de busca
            System.out.println("Tentativa " + tentativas + ": Verificando posição " + meio + 
                              " (" + feiticos[meio] + ")");
            
            // Compara o feitiço do meio com o buscado
            int resultadoComparacao = feiticoBuscado.compareToIgnoreCase(feiticos[meio]);
            
            // Se encontrou o feitiço
            if (resultadoComparacao == 0) {
                System.out.println("Feitiço encontrado após " + tentativas + " tentativas!");
                return meio;
            }
            
            // Se o feitiço buscado vem antes na ordem alfabética
            if (resultadoComparacao < 0) {
                System.out.println("O feitiço deve estar antes. Buscando na primeira metade...");
                fim = meio - 1;
            } 
            // Se o feitiço buscado vem depois na ordem alfabética
            else {
                System.out.println("O feitiço deve estar depois. Buscando na segunda metade...");
                inicio = meio + 1;
            }
        }
        
        // Se chegou aqui, não encontrou o feitiço
        System.out.println("Busca concluída após " + tentativas + " tentativas. Feitiço não encontrado.");
        return -1;
    }
}