package exercicios19MaioJavaFiama;

import java.util.Scanner;
import java.util.Random;

/**
 * Calculadora de Cálculos Matematicamente Errados
 * Esta calculadora realiza operações básicas (soma, subtração, multiplicação, divisão)
 * e adiciona um erro aleatório de até 1% no resultado final.
 */
public class CalculadoraComErro {
    public static void main(String[] args) {
        // Criar objetos para entrada do usuário e geração de números aleatórios
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Boas-vindas ao usuário
        System.out.println("=== CALCULADORA COM ERRO DE PRECISÃO ===");
        System.out.println("Esta calculadora tem um erro de até 1% nos resultados.\n");
        
        boolean continuar = true;
        
        while (continuar) {
            // Solicitar o primeiro número
            System.out.print("Digite o primeiro número: ");
            double numero1 = scanner.nextDouble();
            
            // Solicitar a operação
            System.out.print("Digite a operação (+, -, *, /): ");
            scanner.nextLine(); // Limpar buffer
            String operacao = scanner.nextLine();
            
            // Solicitar o segundo número
            System.out.print("Digite o segundo número: ");
            double numero2 = scanner.nextDouble();
            
            // Realizar o cálculo
            double resultadoCorreto = calcular(numero1, numero2, operacao);
            
            // Se o cálculo foi válido (não divisão por zero)
            if (!Double.isNaN(resultadoCorreto)) {
                // Adicionar o erro aleatório
                double erro = calcularErro(resultadoCorreto, random);
                double resultadoComErro = resultadoCorreto + erro;
                
                // Mostrar os resultados
                System.out.println("\nResultado matematicamente correto: " + resultadoCorreto);
                System.out.println("Resultado desta calculadora: " + resultadoComErro);
                System.out.println("Erro adicionado: " + erro + " (" + 
                                  String.format("%.4f", (erro/resultadoCorreto)*100) + "%)");
            }
            
            // Perguntar se o usuário deseja fazer outro cálculo
            System.out.print("\nDeseja fazer outro cálculo? (S/N): ");
            scanner.nextLine(); // Limpar buffer
            String resposta = scanner.nextLine().toUpperCase();
            continuar = resposta.equals("S") || resposta.equals("SIM");
            
            System.out.println(); // Linha em branco para separar cálculos
        }
        
        System.out.println("Obrigado por usar a Calculadora com Erro!");
        scanner.close();
    }
    
    /**
     * Realiza o cálculo básico entre dois números
     */
    private static double calcular(double num1, double num2, String operacao) {
        switch (operacao) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Erro: Divisão por zero não é permitida!");
                    return Double.NaN; // Not a Number
                }
                return num1 / num2;
            default:
                System.out.println("Operação não reconhecida. Use +, -, * ou /");
                return Double.NaN; // Not a Number
        }
    }
    
    /**
     * Calcula um erro aleatório de até 1% do resultado
     */
    private static double calcularErro(double resultado, Random random) {
        // Valor absoluto para trabalhar com números negativos
        double valorAbsoluto = Math.abs(resultado);
        
        // Calcular erro máximo (1% do valor)
        double erroMaximo = valorAbsoluto * 0.01;
        
        // Gerar um erro aleatório entre 0 e o erro máximo
        double percentualAleatorio = random.nextDouble(); // Entre 0.0 e 1.0
        double erroAleatorio = erroMaximo * percentualAleatorio;
        
        // Aleatoriamente decidir se o erro será positivo ou negativo
        if (random.nextBoolean()) {
            return erroAleatorio;
        } else {
            return -erroAleatorio;
        }
    }
}