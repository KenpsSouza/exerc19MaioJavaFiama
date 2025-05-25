package exercicios19MaioJavaFiama;

import java.util.Scanner;

/**
 * Sistema de Votação para o Mascote da Turma (Versão Simplificada)
 * Este programa permite votar em diferentes candidatos a mascote
 * até que o usuário digite "fim", e então mostra os resultados.
 */
public class SistemaVotacao {
    public static void main(String[] args) {
        // Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Definir os candidatos e seus contadores de votos
        String[] candidatos = {"Leão", "Águia", "Lobo", "Coruja", "Golfinho"};
        int[] votos = {0, 0, 0, 0, 0}; // Cada posição corresponde ao candidato da mesma posição
        
        // Contador de votos totais
        int totalVotos = 0;
        
        // Boas-vindas e instruções
        System.out.println("=== VOTAÇÃO PARA O MASCOTE DA TURMA ===");
        System.out.println("Digite o número do candidato para votar:");
        
        // Mostra os candidatos disponíveis
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println((i+1) + " - " + candidatos[i]);
        }
        
        System.out.println("Para encerrar a votação e ver os resultados, digite 'fim'");
        
        // Loop para receber os votos
        boolean continuarVotacao = true;
        while (continuarVotacao) {
            System.out.print("\nSeu voto: ");
            String entrada = scanner.nextLine();
            
            // Verificar se o usuário quer encerrar a votação
            if (entrada.equalsIgnoreCase("fim")) {
                continuarVotacao = false;
            } else {
                try {
                    // Converter a entrada para número
                    int opcao = Integer.parseInt(entrada);
                    
                    // Verificar se é uma opção válida
                    if (opcao >= 1 && opcao <= candidatos.length) {
                        // Registrar o voto (índice do array começa em 0)
                        votos[opcao - 1]++;
                        totalVotos++;
                        System.out.println("Voto registrado para " + candidatos[opcao - 1] + "!");
                    } else {
                        System.out.println("Opção inválida. Por favor, vote novamente.");
                    }
                } catch (NumberFormatException e) {
                    // Se a entrada não for "fim" nem um número válido
                    System.out.println("Entrada inválida. Digite o número do candidato ou 'fim'.");
                }
            }
        }
        
        // Mostrar os resultados se houver votos
        if (totalVotos > 0) {
            System.out.println("\n=== RESULTADO DA VOTAÇÃO ===");
            System.out.println("Total de votos: " + totalVotos);
            System.out.println("\nCandidato\tVotos\tPercentual");
            System.out.println("-------------------------------");
            
            // Encontrar o vencedor
            int maiorVotos = 0;
            int indiceVencedor = 0;
            
            // Mostrar os votos de cada candidato
            for (int i = 0; i < candidatos.length; i++) {
                int percentual = (votos[i] * 100) / totalVotos;
                System.out.println(candidatos[i] + "\t\t" + votos[i] + "\t" + percentual + "%");
                
                // Verifica se este candidato tem mais votos que o atual líder
                if (votos[i] > maiorVotos) {
                    maiorVotos = votos[i];
                    indiceVencedor = i;
                }
            }
            
            // Mostrar o vencedor
            System.out.println("\nO mascote vencedor é: " + candidatos[indiceVencedor]);
            System.out.println("Com " + votos[indiceVencedor] + " votos (" + 
                              (votos[indiceVencedor] * 100 / totalVotos) + "% do total)");
            
        } else {
            System.out.println("\nNenhum voto foi registrado.");
        }
        
        // Fechar o scanner
        scanner.close();
    }
}