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
/**
Explicação Passo a Passo
1. Estrutura do Programa
O programa é dividido em três partes principais:

método main: controla o fluxo principal e interação com o usuário
método calcular: realiza as operações matemáticas básicas
método calcularErro: calcula o erro aleatório a ser adicionado
2. Entrada e Processamento
Solicitação de Dados:

A calculadora pede dois números e um operador matemático (+, -, *, /)
Os dados são lidos através do objeto Scanner
Cálculo Básico:

A função calcular() recebe os dois números e o operador
Usa uma estrutura switch para determinar a operação a ser realizada
Retorna o resultado correto ou NaN (Not a Number) em caso de erro
Adição do Erro:

Após obter o resultado correto, calculamos o erro com a função calcularErro()
Este erro é então adicionado ao resultado correto
3. Cálculo do Erro
A função calcularErro() é a parte central do programa:

Primeiro, calcula o valor absoluto do resultado (para funcionar com números negativos)
Segundo, determina o erro máximo possível (1% do valor absoluto)
Terceiro, gera um percentual aleatório entre 0 e 1 usando random.nextDouble()
Quarto, multiplica o erro máximo pelo percentual aleatório
Finalmente, decide aleatoriamente se o erro será positivo ou negativo
4. Saída
O programa exibe:

O resultado matematicamente correto
O resultado com o erro adicionado
O valor do erro e sua porcentagem em relação ao resultado
5. Características Adicionais
Tratamento de divisão por zero
Validação da operação matemática
Opção para realizar múltiplos cálculos
Formatação do percentual de erro com 4 casas decimais */