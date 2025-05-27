package exercicios19MaioJavaFiama;

import java.util.Scanner;
import java.util.Random;


public class JogoPePaTeLaSp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        boolean jogarNovamente = true;
        int vitoriasUsuario = 0;
        int vitoriasComputador = 0;
        int empates = 0;
        
        System.out.println("Bem-vindo ao Jogo de Pedra, Papel, Tesoura, Lagarto e Spock!");
        System.out.println("\nRegras:");
        System.out.println("- Tesoura corta Papel");
        System.out.println("- Papel cobre Pedra");
        System.out.println("- Pedra esmaga Lagarto");
        System.out.println("- Lagarto envenena Spock");
        System.out.println("- Spock quebra Tesoura");
        System.out.println("- Tesoura decapita Lagarto");
        System.out.println("- Lagarto come Papel");
        System.out.println("- Papel refuta Spock");
        System.out.println("- Spock vaporiza Pedra");
        System.out.println("- Pedra quebra Tesoura");
        
        while (jogarNovamente) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.println("4 - Lagarto");
            System.out.println("5 - Spock");
            System.out.print("\nDigite o número da sua escolha: ");
            
            int escolhaUsuario = 0;
            boolean entradaValida = false;
            
            while (!entradaValida) {
                try {
                    escolhaUsuario = sc.nextInt();
                    if (escolhaUsuario >= 1 && escolhaUsuario <= 5) {
                        entradaValida = true;
                    } else {
                        System.out.print("Opção inválida! Digite um número entre 1 e 5: ");
                    }
                } catch (Exception e) {
                    System.out.print("Entrada inválida! Digite um número: ");
                    sc.next(); 
                }
            }
            
            int escolhaComputador = random.nextInt(5) + 1;
            
            System.out.println("\nSua escolha: " + converterNumeroParaOpcao(escolhaUsuario));
            System.out.println("Escolha do computador: " + converterNumeroParaOpcao(escolhaComputador));
            
            String resultado = determinarVencedor(escolhaUsuario, escolhaComputador);
            System.out.println("\nResultado: " + resultado);
            
            if (resultado.contains("Você venceu")) {
                vitoriasUsuario++;
            } else if (resultado.contains("Computador venceu")) {
                vitoriasComputador++;
            } else {
                empates++;
            }
            
            System.out.println("\nPlacar:");
            System.out.println("Você: " + vitoriasUsuario);
            System.out.println("Computador: " + vitoriasComputador);
            System.out.println("Empates: " + empates);
            
            System.out.print("\nDeseja jogar novamente? (S/N): ");
            String resposta = sc.next().toUpperCase();
            jogarNovamente = resposta.equals("S") || resposta.equals("SIM");
        }
        
        System.out.println("\nObrigado por jogar! Placar final:");
        System.out.println("Você: " + vitoriasUsuario);
        System.out.println("Computador: " + vitoriasComputador);
        System.out.println("Empates: " + empates);
        
        sc.close();
    }
    
   
    private static String converterNumeroParaOpcao(int numero) {
        switch (numero) {
            case 1: return "Pedra";
            case 2: return "Papel";
            case 3: return "Tesoura";
            case 4: return "Lagarto";
            case 5: return "Spock";
            default: return "Desconhecido";
        }
    }
    
    
    private static String determinarVencedor(int escolhaUsuario, int escolhaComputador) {
        if (escolhaUsuario == escolhaComputador) {
            return "Empate!";
        }
        
        // regras do jogo
        // 1: Pedra, 2: Papel, 3: Tesoura, 4: Lagarto, 5: Spock
        
        switch (escolhaUsuario) {
            case 1: // Pedra
                if (escolhaComputador == 3 || escolhaComputador == 4) {
                    return escolhaComputador == 3 ? 
                           "Você venceu! Pedra quebra Tesoura" : 
                           "Você venceu! Pedra esmaga Lagarto";
                } else {
                    return escolhaComputador == 2 ? 
                           "Computador venceu! Papel cobre Pedra" : 
                           "Computador venceu! Spock vaporiza Pedra";
                }
                
            case 2: // Papel
                if (escolhaComputador == 1 || escolhaComputador == 5) {
                    return escolhaComputador == 1 ? 
                           "Você venceu! Papel cobre Pedra" : 
                           "Você venceu! Papel refuta Spock";
                } else {
                    return escolhaComputador == 3 ? 
                           "Computador venceu! Tesoura corta Papel" : 
                           "Computador venceu! Lagarto come Papel";
                }
                
            case 3: // Tesoura
                if (escolhaComputador == 2 || escolhaComputador == 4) {
                    return escolhaComputador == 2 ? 
                           "Você venceu! Tesoura corta Papel" : 
                           "Você venceu! Tesoura decapita Lagarto";
                } else {
                    return escolhaComputador == 1 ? 
                           "Computador venceu! Pedra quebra Tesoura" : 
                           "Computador venceu! Spock quebra Tesoura";
                }
                
            case 4: // Lagarto
                if (escolhaComputador == 2 || escolhaComputador == 5) {
                    return escolhaComputador == 2 ? 
                           "Você venceu! Lagarto come Papel" : 
                           "Você venceu! Lagarto envenena Spock";
                } else {
                    return escolhaComputador == 1 ? 
                           "Computador venceu! Pedra esmaga Lagarto" : 
                           "Computador venceu! Tesoura decapita Lagarto";
                }
                
            case 5: // Spock
                if (escolhaComputador == 1 || escolhaComputador == 3) {
                    return escolhaComputador == 1 ? 
                           "Você venceu! Spock vaporiza Pedra" : 
                           "Você venceu! Spock quebra Tesoura";
                } else {
                    return escolhaComputador == 2 ? 
                           "Computador venceu! Papel refuta Spock" : 
                           "Computador venceu! Lagarto envenena Spock";
                }
                
            default:
                return "Erro ao determinar o vencedor.";
        }
    }
  
}