package exercicios19MaioJavaFiama;

import java.util.Scanner;

public class BuscaFeiticos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        
        // Lista de feitiços ordenada 
        String[] feiticos = {
            "Aceleratio", "Defensio", "Expelliarmus", "Lumos", "Wingardium Leviosa"
        };
        
        while (continuar) {
        	System.out.println("\n\n\n");
			// Exibir cabeçalho do sistema	
			System.out.println("=============================================");
			System.out.println("  Bem-vindo ao Sistema de Busca de Feitiços");
			System.out.println("       Biblioteca Mágica de Hogwarts");
			System.out.println("   =======================================");
            System.out.println();
            
            // Mostrar os feitiços disponíveis
            System.out.println("Lista de feitiços disponíveis:");
            for (int i = 0; i < feiticos.length; i++) {
                System.out.println("- " + feiticos[i]);
            }
            
            System.out.print("\nDigite o nome do feitiço que deseja encontrar: ");
            String feiticoBuscado = sc.nextLine();
            
            // Realizar a busca binária e mostrar passos
            System.out.println("\nRealizando busca por: " + feiticoBuscado);
            int posicao = buscaBinaria(feiticos, feiticoBuscado);
            
            if (posicao != -1) {
                System.out.println("\nFeitiço encontrado na posição " + posicao);
                System.out.println("Nome do feitiço: " + feiticos[posicao]);
            } else {
                System.out.println("\nFeitiço não encontrado na biblioteca.");
                System.out.println("Verifique se digitou o nome corretamente.");
            }
            
            System.out.print("\nDeseja buscar outro feitiço? (S/N): ");
            String resposta = sc.nextLine();
            
            if (resposta.equalsIgnoreCase("N") || resposta.equalsIgnoreCase("Não") || 
                resposta.equalsIgnoreCase("Nao")) {
                continuar = false;
                System.out.println("\nObrigado por utilizar o sistema!");
            } else {
                System.out.println("\n\n\n");
            }
        }
        
        sc.close();
    }
    
    // algoritmo de busca binária
    private static int buscaBinaria(String[] feiticos, String feiticoBuscado) {
        int inicio = 0;
        int fim = feiticos.length - 1;
        int passos = 0;
        
        while (inicio <= fim) {
            passos++;
            int meio = (inicio + fim) / 2;
            
            System.out.println("Passo " + passos + ": Verificando posição " + meio + " (" + feiticos[meio] + ")");
            
            // Comparação ignorando maiúsculas/minúsculas
            int comparacao = feiticoBuscado.compareToIgnoreCase(feiticos[meio]);
            
            if (comparacao == 0) {
                return meio;
            }
            
            // Buscar na primeira metade (feitiço vem antes alfabeticamente)
            if (comparacao < 0) {
                fim = meio - 1;
                System.out.println("O feitiço buscado vem antes na ordem alfabética. Buscando na primeira metade.");
            }
            // Buscar na segunda metade (feitiço vem depois alfabeticamente)
            else {
                inicio = meio + 1;
                System.out.println("O feitiço buscado vem depois na ordem alfabética. Buscando na segunda metade.");
            }
        }
        
        return -1;
    }
}