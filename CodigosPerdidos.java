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
/**Explicação Passo a Passo
1. Estrutura do Programa
O programa tem uma estrutura simples dividida em:

Método main: Controla o fluxo principal do programa
Método decodificarCodigos: Responsável por processar os códigos e gerar a mensagem decodificada
2. Entrada do Usuário
O programa pede ao usuário que informe quantos códigos irá inserir
Em seguida, solicita cada código individualmente
Armazena os códigos em um array de strings
3. Processo de Decodificação
Para cada código (como "4H"):

Separa o número (4) da letra (H)
O número pode ter múltiplos dígitos, então pegamos todos os caracteres exceto o último
A letra é sempre o último caractere do código
Converte o número para inteiro
Adiciona a letra ao resultado o número de vezes indicado
4. Tratamento de Erros Básico
Verifica se o código tem pelo menos 2 caracteres (um para o número e um para a letra)
Usa try-catch para lidar com possíveis erros na conversão do número
5. Saída
Exibe a mensagem decodificada completa ao final do processo
Exemplo:
Para a entrada ["4H", "7A", "2C"], o programa vai:
Processar "4H": adicionar "HHHH"
Processar "7A": adicionar "AAAAAAA"
Processar "2C": adicionar "CC"
Resultado final: "HHHHAAAAACC"*/