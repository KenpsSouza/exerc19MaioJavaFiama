package exercicios19MaioJavaFiama;

import java.util.Scanner;

/**
 * Simulador de Cofrinho Inteligente
 * Este programa calcula o total de dinheiro inserido em um cofre
 * e projeta quanto tempo levará para atingir R$ 100.
 */
public class CofrinhoInteligente {
    public static void main(String[] args) {
        // Criar objeto Scanner para ler entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Boas-vindas ao programa
        System.out.println("=== SIMULADOR DE COFRINHO INTELIGENTE ===");
        System.out.println("Informe a quantidade de cada tipo de moeda:");
        
        // Solicita e armazena a quantidade de cada tipo de moeda
        System.out.print("Quantidade de moedas de R$ 0.01: ");
        int moeda1Centavo = scanner.nextInt();
        
        System.out.print("Quantidade de moedas de R$ 0.05: ");
        int moeda5Centavos = scanner.nextInt();
        
        System.out.print("Quantidade de moedas de R$ 0.10: ");
        int moeda10Centavos = scanner.nextInt();
        
        System.out.print("Quantidade de moedas de R$ 0.25: ");
        int moeda25Centavos = scanner.nextInt();
        
        System.out.print("Quantidade de moedas de R$ 0.50: ");
        int moeda50Centavos = scanner.nextInt();
        
        System.out.print("Quantidade de moedas de R$ 1.00: ");
        int moeda1Real = scanner.nextInt();
        
        // Cálculo do valor total no cofrinho (em reais)
        double valorTotal = (moeda1Centavo * 0.01) +
                           (moeda5Centavos * 0.05) +
                           (moeda10Centavos * 0.10) +
                           (moeda25Centavos * 0.25) +
                           (moeda50Centavos * 0.50) +
                           (moeda1Real * 1.0);
        
        // Exibe o valor total economizado
        System.out.printf("\nValor total no cofrinho: R$ %.2f\n", valorTotal);
        
        // Cálculo de quanto falta para R$ 100
        double valorFaltante = 100.0 - valorTotal;
        
        // Exibe quanto falta para atingir R$ 100
        if (valorFaltante > 0) {
            System.out.printf("Faltam R$ %.2f para atingir R$ 100,00\n", valorFaltante);
            
            // Cálculo simples do tempo em semanas
            if (valorTotal > 0) {
                // Arredonda para cima para garantir que o valor será alcançado
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
        
        // Fecha o scanner para evitar vazamento de recursos
        scanner.close();
    }
}