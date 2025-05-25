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
/**Explicação Passo a Passo
Importação da Biblioteca: Começamos importando a classe Scanner que será usada para receber entrada do usuário.

Declaração da Classe: Criamos a classe principal CofrinhoDeMoedas.

Método Main: Este é o ponto de entrada do programa onde todo o código será executado.

Criação do Scanner: Instanciamos um objeto Scanner para ler a entrada do teclado.

Coleta de Dados: Usamos uma série de System.out.print e scanner.nextInt() para pedir e armazenar as quantidades de cada tipo de moeda.

Cálculo do Total: Multiplicamos cada quantidade de moedas pelo seu valor correspondente e somamos todos para obter o valor total.

Exibição do Total: Mostramos para o usuário quanto dinheiro ele tem no cofrinho usando System.out.printf para formatar o número com duas casas decimais.

Cálculo do Valor Faltante: Calculamos quanto falta para chegar a R$ 100 subtraindo o valor total de 100.

Mensagem sobre o Valor Faltante: Usamos uma estrutura condicional if-else if-else para exibir uma mensagem adequada:

Se falta dinheiro, mostramos quanto falta
Se passou de R$ 100, parabenizamos e mostramos quanto passou
Se é exatamente R$ 100, parabenizamos de forma específica
Cálculo de Tempo: Se o usuário já fez algum depósito, calculamos quantas semanas levariam para atingir R$ 100 mantendo o mesmo padrão de depósito semanal.
*/