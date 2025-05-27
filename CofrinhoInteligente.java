package exercicios19MaioJavaFiama;

import java.util.Scanner;

public class CofrinhoInteligente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("=== SIMULADOR DE COFRINHO INTELIGENTE ===");
        
        while (continuar) {
            System.out.println("\nInforme a quantidade de cada tipo de moeda:");
            
            System.out.print("Quantidade de moedas de R$ 0.01: ");
            int moeda1Centavo = sc.nextInt();
            
            System.out.print("Quantidade de moedas de R$ 0.05: ");
            int moeda5Centavos = sc.nextInt();
            
            System.out.print("Quantidade de moedas de R$ 0.10: ");
            int moeda10Centavos = sc.nextInt();
            
            System.out.print("Quantidade de moedas de R$ 0.25: ");
            int moeda25Centavos = sc.nextInt();
            
            System.out.print("Quantidade de moedas de R$ 0.50: ");
            int moeda50Centavos = sc.nextInt();
            
            System.out.print("Quantidade de moedas de R$ 1.00: ");
            int moeda1Real = sc.nextInt();
            
            double valorTotal = (moeda1Centavo * 0.01) +
                               (moeda5Centavos * 0.05) +
                               (moeda10Centavos * 0.10) +
                               (moeda25Centavos * 0.25) +
                               (moeda50Centavos * 0.50) +
                               (moeda1Real * 1.0);
            
            System.out.printf("\nValor total no cofrinho: R$ %.2f\n", valorTotal);
            
            double valorFaltante = 100.0 - valorTotal;
            
            if (valorFaltante > 0) {
                System.out.printf("Faltam R$ %.2f para atingir R$ 100,00\n", valorFaltante);
                
                if (valorTotal > 0) {
                    int semanas = (int) Math.ceil(valorFaltante / valorTotal);
                    System.out.printf("\nSe você depositar R$ %.2f por semana, levará %d semanas para atingir R$ 100,00.\n", 
                                     valorTotal, semanas);
                } else {
                    System.out.println("\nVocê precisa fazer algum depósito para calcular o tempo necessário.");
                }
            } else if (valorFaltante < 0) {
                System.out.printf("Parabéns! Você já ultrapassou o objetivo de R$ 100,00 em R$ %.2f\n", Math.abs(valorFaltante));
            } else {
                System.out.println("Parabéns! Você atingiu exatamente o objetivo de R$ 100,00!");
            }
            
            System.out.print("\nDeseja fazer uma nova simulação? (S/N): ");
            sc.nextLine(); 
            String resposta = sc.nextLine().trim().toUpperCase();
            
            continuar = resposta.equals("S") || resposta.equals("SIM");
            
            if (continuar) {
                System.out.println("\n----------------------------------------");
            }
        }
        
        System.out.println("\nObrigado por usar o Simulador de Cofrinho Inteligente!");
        sc.close();
    }
}