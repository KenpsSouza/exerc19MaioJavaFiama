package exercicios19MaioJavaFiama;


import java.util.Scanner;

/**
 * Validador de Senhas Incomuns
 * Este programa verifica se uma senha atende a critérios específicos:
 * - Pelo menos uma letra maiúscula
 * - Pelo menos um número primo
 * - Pelo menos um caractere especial
 * - Não ter vogais duplicadas seguidas
 */
public class ValidadorSenhas {
    public static void main(String[] args) {
        // Criar scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Apresentação do programa
        System.out.println("=== VALIDADOR DE SENHAS INCOMUNS ===");
        System.out.println("\nRegras para senha válida:");
        System.out.println("1. Pelo menos uma letra maiúscula");
        System.out.println("2. Pelo menos um número primo (2, 3, 5, 7, etc.)");
        System.out.println("3. Pelo menos um caractere especial (!, @, #, $, %, etc.)");
        System.out.println("4. Não pode conter vogais duplicadas seguidas (aa, ee, ii, oo, uu)");
        
        boolean continuar = true;
        
        while (continuar) {
            // Solicitar a senha ao usuário
            System.out.print("\nDigite uma senha para validar: ");
            String senha = scanner.nextLine();
            
            // Validar cada regra separadamente para poder dar feedback específico
            boolean temLetraMaiuscula = verificarLetraMaiuscula(senha);
            boolean temNumeroPrimo = verificarNumeroPrimo(senha);
            boolean temCaractereEspecial = verificarCaractereEspecial(senha);
            boolean naoTemVogaisDuplicadas = verificarVogaisDuplicadas(senha);
            
            // Mostrar resultado
            System.out.println("\nResultado da validação:");
            System.out.println("- Letra maiúscula: " + (temLetraMaiuscula ? "V" : "X"));
            System.out.println("- Número primo: " + (temNumeroPrimo ? "V" : "X"));
            System.out.println("- Caractere especial: " + (temCaractereEspecial ? "V" : "X"));
            System.out.println("- Sem vogais duplicadas: " + (naoTemVogaisDuplicadas ? "V" : "X"));
            
            // Verificar se todas as regras foram atendidas
            if (temLetraMaiuscula && temNumeroPrimo && temCaractereEspecial && naoTemVogaisDuplicadas) {
                System.out.println("\n✅ Senha VÁLIDA! Atende a todos os requisitos.");
            } else {
                System.out.println("\n❌ Senha INVÁLIDA! Não atende a todos os requisitos.");
            }
            
         
            
            // Perguntar se o usuário deseja verificar outra senha
            System.out.print("\nDeseja verificar outra senha? (S/N): ");
            String resposta = scanner.nextLine().toUpperCase();
            continuar = resposta.equals("S") || resposta.equals("SIM");
        }
        
        System.out.println("\nObrigado por usar o validador de senhas!");
        scanner.close();
    }
    
    /**
     * Verifica se a senha contém pelo menos uma letra maiúscula
     */
    private static boolean verificarLetraMaiuscula(String senha) {
        // Percorre cada caractere verificando se algum é maiúsculo
        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Verifica se a senha contém pelo menos um número primo
     */
    private static boolean verificarNumeroPrimo(String senha) {
        // Percorre cada caractere verificando se é um dígito e se é primo
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                int numero = Character.getNumericValue(c);
                if (ehPrimo(numero)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Verifica se um número é primo
     */
    private static boolean ehPrimo(int numero) {
        // 0 e 1 não são primos
        if (numero <= 1) {
            return false;
        }
        
        // 2 e 3 são primos
        if (numero <= 3) {
            return true;
        }
        
        // Verificar divisibilidade por números até a raiz quadrada
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Verifica se a senha contém pelo menos um caractere especial
     */
    private static boolean verificarCaractereEspecial(String senha) {
        // Caracteres especiais comuns
        String caracteresEspeciais = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?`~";
        
        // Percorre cada caractere verificando se é um caractere especial
        for (char c : senha.toCharArray()) {
            if (caracteresEspeciais.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Verifica se a senha NÃO contém vogais duplicadas seguidas
     */
    private static boolean verificarVogaisDuplicadas(String senha) {
        // Converte para minúsculo para simplificar a verificação
        senha = senha.toLowerCase();
        
        // Verifica se existe alguma sequência de vogais duplicadas
        if (senha.contains("aa") || senha.contains("ee") || 
            senha.contains("ii") || senha.contains("oo") || 
            senha.contains("uu")) {
            return false;
        }
        
        return true;
    }
}

/** Explicação Passo a Passo
Importação de Biblioteca:

java.util.Scanner para capturar a entrada do usuário.
Classe Principal (ValidadorSenhas):

Criamos a classe que contém a lógica do validador de senhas.
Método Main:

Cria o scanner para entrada do usuário.
Exibe as regras de validação para o usuário entender os requisitos.
Cria um loop que permite validar múltiplas senhas.
Processos de Validação:

Cada regra é verificada usando métodos específicos, retornando verdadeiro ou falso.
Apresentamos o resultado de cada validação usando ✓ ou ✗ para tornar o resultado visual.
Se todas as regras forem atendidas, a senha é considerada válida.
Método verificarLetraMaiuscula:

Percorre cada caractere da senha e verifica se pelo menos um é letra maiúscula.
Utiliza o método Character.isUpperCase() para verificar.
Método verificarNumeroPrimo:

Percorre cada caractere da senha para identificar dígitos.
Quando encontra um dígito, verifica se é primo usando o método auxiliar ehPrimo().
Método ehPrimo:

Implementa o algoritmo para verificação de números primos.
Primeiro trata os casos especiais (0, 1, 2, 3).
Para números maiores, verifica divisibilidade até a raiz quadrada do número.
Método verificarCaractereEspecial:

Define uma string contendo caracteres especiais comuns.
Verifica se a senha contém pelo menos um desses caracteres.
Método verificarVogaisDuplicadas:

Converte a senha para minúsculas para simplificar a verificação.
Verifica se a senha contém alguma das combinações de vogais duplicadas ("aa", "ee", etc.).
Retorna verdadeiro apenas se NÃO contiver vogais duplicadas seguidas.
*/