package exercicios19MaioJavaFiama;

import java.util.Scanner;
import java.util.Random;


public class CalculadoraComErro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("=== BEM-VINDO À CALCULADORA COM ERRO ===\n");
        System.out.println("=== CALCULADORA COM ERRO DE PRECISÃO ===");
        System.out.println("Esta calculadora tem um erro de até 1% nos resultados.\n");
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.print("Digite o primeiro número: ");
            double numero1 = scanner.nextDouble();
            
            System.out.print("Digite a operação (+, -, *, /): ");
            scanner.nextLine(); 
            String operacao = scanner.nextLine();
            
            System.out.print("Digite o segundo número: ");
            double numero2 = scanner.nextDouble();
            
            double resultadoCorreto = calcular(numero1, numero2, operacao);
            
            if (!Double.isNaN(resultadoCorreto)) {
                double erro = calcularErro(resultadoCorreto, random);
                double resultadoComErro = resultadoCorreto + erro;
                
                System.out.println("\nResultado matematicamente correto: " + resultadoCorreto);
                System.out.printf("Resultado desta calculadora: %.3f\n", resultadoComErro);
                System.out.println("Erro adicionado: " + erro + " (" + 
                                  String.format("%.3f", (erro/resultadoCorreto)*100) + "%)");
            }
            
            System.out.print("\nDeseja fazer outro cálculo? (S/N): ");
            scanner.nextLine(); 
            String resposta = scanner.nextLine().toUpperCase();
            continuar = resposta.equals("S") || resposta.equals("SIM");
            
            System.out.println(); 
        }
        
        System.out.println("Obrigado por usar a Calculadora com Erro!");
        scanner.close();
    }
    
    
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
                    System.out.println("Errado: Divisão por zero não é permitida!");
                    return Double.NaN;
                }
                return num1 / num2;
            default:
                System.out.println("Operação não reconhecida. Use +, -, * ou /");
                return Double.NaN;
        }
    }
    
    
    //Calcula um erro aleatório de até 1%
     
    private static double calcularErro(double resultado, Random random) {
        double valorAbsoluto = Math.abs(resultado);
        
        // Calcular erro máximo (1% do valor)
        double erroMaximo = valorAbsoluto * 0.01;
        
        // Gerar um erro aleatório entre 0 e o erro máximo
        double percentualAleatorio = random.nextDouble(); // Entre 0.0 e 1.0
        double erroAleatorio = erroMaximo * percentualAleatorio;
        
        if (random.nextBoolean()) {
            return erroAleatorio;
        } else {
            return -erroAleatorio;
        }
    }
}
