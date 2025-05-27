package exercicios19MaioJavaFiama;

import java.util.Scanner;

public class ValidadorSenhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== VALIDADOR DE SENHAS INCOMUNS ===");
        System.out.println("\nRegras para senha válida:");
        System.out.println("1. Pelo menos uma letra maiúscula");
        System.out.println("2. Pelo menos um número primo (2, 3, 5, 7, etc.)");
        System.out.println("3. Pelo menos um caractere especial (!, @, #, $, %, etc.)");
        System.out.println("4. Não pode conter vogais duplicadas seguidas (aa, ee, ii, oo, uu)");
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.print("\nDigite uma senha para validar: ");
            String senha = sc.nextLine();
            
            boolean temLetraMaiuscula = verificarLetraMaiuscula(senha);
            boolean temNumeroPrimo = verificarNumeroPrimo(senha);
            boolean temCaractereEspecial = verificarCaractereEspecial(senha);
            boolean naoTemVogaisDuplicadas = verificarVogaisDuplicadas(senha);
            
            System.out.println("\nResultado da validação:");
            System.out.println("- Letra maiúscula: " + (temLetraMaiuscula ? "S" : "N"));
            System.out.println("- Número primo: " + (temNumeroPrimo ? "S" : "N"));
            System.out.println("- Caractere especial: " + (temCaractereEspecial ? "S" : "N"));
            System.out.println("- Sem vogais duplicadas: " + (naoTemVogaisDuplicadas ? "S" : "N"));
            
            if (temLetraMaiuscula && temNumeroPrimo && temCaractereEspecial && naoTemVogaisDuplicadas) {
                System.out.println("\n(V) Senha VÁLIDA! Atende a todos os requisitos.");
            } else {
                System.out.println("\n(X) Senha INVÁLIDA! Não atende a todos os requisitos.");
            }
            
            System.out.print("\nDeseja verificar outra senha? (S/N): ");
            String resposta = sc.nextLine().toUpperCase();
            continuar = resposta.equals("S") || resposta.equals("SIM");
        }
        
        System.out.println("\nObrigado por usar o validador de senhas!");
        sc.close();
    }
    
    private static boolean verificarLetraMaiuscula(String senha) {
        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
   
    private static boolean verificarNumeroPrimo(String senha) {
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
   
    private static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        
        if (numero <= 3) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean verificarCaractereEspecial(String senha) {
        String caracteresEspeciais = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?`~";
        
        for (char c : senha.toCharArray()) {
            if (caracteresEspeciais.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean verificarVogaisDuplicadas(String senha) {
        senha = senha.toLowerCase();
        
        if (senha.contains("aa") || senha.contains("ee") || 
            senha.contains("ii") || senha.contains("oo") || 
            senha.contains("uu")) {
            return false;
        }
        
        return true;
    }
}
