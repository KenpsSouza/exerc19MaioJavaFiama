package exercicios19MaioJavaFiama;

import java.util.Scanner;

public class SistemaVotacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] candidatos = {"Leão", "Águia", "Lobo", "Coruja", "Gato"};
        int[] votos = {0, 0, 0, 0, 0}; 
        
        int totalVotos = 0;
        
        System.out.println("Bem-vindo ao Sistema de Votação de Mascotes!");
        System.out.println("=== VOTAÇÃO PARA O MASCOTE DA TURMA ===");
        System.out.println("Digite o número do candidato para votar:");
        
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println((i+1) + " - " + candidatos[i]);
        }
        
        System.out.println("\nPara encerrar a votação e ver os resultados, digite 'fim'");
        
        boolean continuarVotacao = true;
        while (continuarVotacao) {
            System.out.print("\nSeu voto: ");
            String entrada = sc.nextLine();
            
            if (entrada.equalsIgnoreCase("fim")) {
                System.out.println("\nEncerrando a votação...");
                System.out.println("Preparando a contagem final dos votos...");
                continuarVotacao = false;
            } else {
                try {
                    int opcao = Integer.parseInt(entrada);
                    
                    if (opcao >= 1 && opcao <= candidatos.length) {
                        votos[opcao - 1]++;
                        totalVotos++;
                        System.out.println("Voto registrado para " + candidatos[opcao - 1] + "!");
                        System.out.println("Total de votos até agora: " + totalVotos);
                        System.out.println("\nPara encerrar a votação e ver os resultados, digite 'fim'");

                    } else {
                        System.out.println("Opção inválida. Por favor, vote novamente.");
                        System.out.println("Os números válidos são de 1 a " + candidatos.length);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite o número do candidato ou 'fim'.");
                }
            }
        }
        
        if (totalVotos > 0) {
            System.out.println("\n=== RESULTADO FINAL DA VOTAÇÃO ===");
            System.out.println("Total de votos: " + totalVotos);
            System.out.println("\nCandidato\tVotos\tPercentual");
            System.out.println("-------------------------------");
            
            int maiorVotos = 0;
            int indiceVencedor = 0;
            
            for (int i = 0; i < candidatos.length; i++) {
                int percentual = (votos[i] * 100) / totalVotos;
                System.out.println(candidatos[i] + "\t\t" + votos[i] + "\t" + percentual + "%");
                
                if (votos[i] > maiorVotos) {
                    maiorVotos = votos[i];
                    indiceVencedor = i;
                }
            }
            
            System.out.println("\nO mascote vencedor é: " + candidatos[indiceVencedor]);
            System.out.println("Com " + votos[indiceVencedor] + " votos (" + 
                              (votos[indiceVencedor] * 100 / totalVotos) + "% do total)");
            
        } else {
            System.out.println("\nNenhum voto foi registrado.");
        }
        
        System.out.println("\nObrigado por utilizar o Sistema de Votação de Mascotes!");
        sc.close();
    }
}