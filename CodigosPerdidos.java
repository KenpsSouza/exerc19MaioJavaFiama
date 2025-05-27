package exercicios19MaioJavaFiama;

import java.util.Scanner;

public class CodigosPerdidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("=== A ILHA DOS CÓDIGOS PERDIDOS ===");
        System.out.println("Este programa decodifica mensagens misteriosas!");
        System.out.println("Cada código deve ser um número seguido de uma letra (exemplo: 4H)");
        System.out.println("Explicação: O número indica quantas vezes a letra se repete");
        System.out.println("Exemplo: 4H = HHHH, 2M = MM, 5A = AAAAA");
        
        while (continuar) {
            System.out.print("\nQuantos códigos você vai inserir? ");
            int quantidadeCodigos = sc.nextInt();
            sc.nextLine(); 
            
            String[] codigos = new String[quantidadeCodigos];
            
            System.out.println("\nDigite os códigos, um por um:");
            System.out.println("Lembre-se: PRIMEIRO o número, DEPOIS a letra (ex: 3B)");
            
            for (int i = 0; i < quantidadeCodigos; i++) {
                System.out.print("Código " + (i + 1) + ": ");
                String codigo = sc.nextLine();
                
                if (codigo.length() < 2) {
                    System.out.println("ATENÇÃO: Código muito curto! Deve ter pelo menos um número e uma letra.");
                    System.out.print("Digite novamente o código " + (i + 1) + ": ");
                    codigo = sc.nextLine();
                } else if (!Character.isDigit(codigo.charAt(0))) {
                    System.out.println("ATENÇÃO: O código deve começar com um número!");
                    System.out.print("Digite novamente o código " + (i + 1) + ": ");
                    codigo = sc.nextLine();
                } else if (!Character.isLetter(codigo.charAt(codigo.length() - 1))) {
                    System.out.println("ATENÇÃO: O código deve terminar com uma letra!");
                    System.out.print("Digite novamente o código " + (i + 1) + ": ");
                    codigo = sc.nextLine();
                }
                
                codigos[i] = codigo;
            }
            
            String mensagemDecodificada = decodificarCodigos(codigos);
            
            System.out.println("\n=== MENSAGEM DECODIFICADA ===");
            System.out.println(mensagemDecodificada);
            
            
            System.out.print("\nDeseja decodificar outra? (S/N): ");
            String resposta = sc.nextLine().trim().toUpperCase();
            
            continuar = resposta.equals("S") || resposta.equals("SIM");
            
            if (continuar) {
                System.out.println("\n----------------------------------------");
            }
        }
        
        System.out.println("\nObrigado por usar o decodificador de mensagens!");
        sc.close();
    }
    
    private static String decodificarCodigos(String[] codigos) {
        StringBuilder mensagem = new StringBuilder();
        
        for (String codigo : codigos) {
            if (codigo.length() >= 2) {
                try {
                    // Extrair o número (pode ser mais de um dígito)
                    // A letra será sempre o último caractere
                    String numeroStr = codigo.substring(0, codigo.length() - 1);
                    char letra = codigo.charAt(codigo.length() - 1);
                    
                    // Verificar se a parte numérica contém apenas dígitos
                    boolean apenasDigitos = true;
                    for (char c : numeroStr.toCharArray()) {
                        if (!Character.isDigit(c)) {
                            apenasDigitos = false;
                            break;
                        }
                    }
                    
                    if (!apenasDigitos) {
                        System.out.println("Erro no código '" + codigo + "': A parte numérica deve conter apenas números.");
                        continue;
                    }
                    
                    if (!Character.isLetter(letra)) {
                        System.out.println("Erro no código '" + codigo + "': O último caractere deve ser uma letra.");
                        continue;
                    }
                    
                    int repeticoes = Integer.parseInt(numeroStr);
                    
                    System.out.println("Processando: '" + codigo + " - " + repeticoes + " repetições da letra " + letra + " ");
                    
                    for (int i = 0; i < repeticoes; i++) {
                        mensagem.append(letra);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Código inválido: " + codigo + " - Não foi possível converter a parte numérica.");
                }
            } else {
                System.out.println("Código muito curto: " + codigo + "' - Deve ter pelo menos um número e uma letra.");
            }
        }
        
        return mensagem.toString();
    }
}