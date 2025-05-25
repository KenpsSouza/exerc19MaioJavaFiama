package exercicios19MaioJavaFiama;

import java.util.Scanner;

/**
 * A Ilha dos Códigos Perdidos
 * Este programa decodifica uma sequência de códigos misteriosos.
 * Cada código consiste em um número seguido por uma letra.
 * O número representa quantas vezes a letra deve ser repetida.
 */
public class CodigosPerdidos {
    public static void main(String[] args) {
        // Criar scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Boas-vindas
        System.out.println("=== A ILHA DOS CÓDIGOS PERDIDOS ===");
        System.out.println("Este programa decodifica mensagens misteriosas!");
        System.out.println("Cada código deve ser um número seguido de uma letra (exemplo: 4H)");
        
        // Perguntar quantos códigos serão inseridos
        System.out.print("\nQuantos códigos você vai inserir? ");
        int quantidadeCodigos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        // Criar um array para armazenar os códigos
        String[] codigos = new String[quantidadeCodigos];
        
        // Ler os códigos do usuário
        System.out.println("\nDigite os códigos, um por um:");
        for (int i = 0; i < quantidadeCodigos; i++) {
            System.out.print("Código " + (i + 1) + ": ");
            codigos[i] = scanner.nextLine();
        }
        
        // Decodificar a mensagem
        String mensagemDecodificada = decodificarCodigos(codigos);
        
        // Mostrar o resultado
        System.out.println("\n=== MENSAGEM DECODIFICADA ===");
        System.out.println(mensagemDecodificada);
        
        // Fechar o scanner
        scanner.close();
    }
    
    /**
     * Decodifica uma array de códigos
     * @param codigos Array contendo os códigos (ex: "4H", "7A", "2C")
     * @return String com a mensagem decodificada
     */
    private static String decodificarCodigos(String[] codigos) {
        // StringBuilder para construir a mensagem eficientemente
        StringBuilder mensagem = new StringBuilder();
        
        // Processar cada código
        for (String codigo : codigos) {
            // Verificar se o código tem pelo menos 2 caracteres
            if (codigo.length() >= 2) {
                try {
                    // Extrair o número (pode ser mais de um dígito)
                    // A letra será sempre o último caractere
                    String numeroStr = codigo.substring(0, codigo.length() - 1);
                    char letra = codigo.charAt(codigo.length() - 1);
                    
                    // Converter o número para inteiro
                    int repeticoes = Integer.parseInt(numeroStr);
                    
                    // Adicionar a letra o número correto de vezes
                    for (int i = 0; i < repeticoes; i++) {
                        mensagem.append(letra);
                    }
                } catch (NumberFormatException e) {
                    // Se ocorrer um erro ao converter o número
                    System.out.println("Código inválido: " + codigo);
                }
            } else {
                System.out.println("Código muito curto: " + codigo);
            }
        }
        
        return mensagem.toString();
    }
}