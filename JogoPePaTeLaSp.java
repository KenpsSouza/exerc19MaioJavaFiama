package exercicios19MaioJavaFiama;

import java.util.Scanner;
import java.util.Random;


public class JogoPePaTeLaSp {
    public static void main(String[] args) {
        // Criando objetos para entrada do usuário e geração de números aleatórios
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Variáveis para controlar o jogo
        boolean jogarNovamente = true;
        int vitoriasUsuario = 0;
        int vitoriasComputador = 0;
        int empates = 0;
        
        // Mensagem de boas-vindas e explicação do jogo
        System.out.println("===== JOGO DE PEDRA, PAPEL, TESOURA, LAGARTO E SPOCK =====");
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
        
        // Loop principal do jogo
        while (jogarNovamente) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.println("4 - Lagarto");
            System.out.println("5 - Spock");
            System.out.print("\nDigite o número da sua escolha: ");
            
            // Lê a escolha do usuário
            int escolhaUsuario = 0;
            boolean entradaValida = false;
            
            // Verifica se a entrada é válida (entre 1 e 5)
            while (!entradaValida) {
                try {
                    escolhaUsuario = scanner.nextInt();
                    if (escolhaUsuario >= 1 && escolhaUsuario <= 5) {
                        entradaValida = true;
                    } else {
                        System.out.print("Opção inválida! Digite um número entre 1 e 5: ");
                    }
                } catch (Exception e) {
                    System.out.print("Entrada inválida! Digite um número: ");
                    scanner.next(); // Limpa o buffer do scanner
                }
            }
            
            // Gera a escolha do computador (1 a 5)
            int escolhaComputador = random.nextInt(5) + 1;
            
            // Mostra as escolhas
            System.out.println("\nSua escolha: " + converterNumeroParaOpcao(escolhaUsuario));
            System.out.println("Escolha do computador: " + converterNumeroParaOpcao(escolhaComputador));
            
            // Determina o resultado do jogo
            String resultado = determinarVencedor(escolhaUsuario, escolhaComputador);
            System.out.println("\nResultado: " + resultado);
            
            // Atualiza o placar
            if (resultado.contains("Você venceu")) {
                vitoriasUsuario++;
            } else if (resultado.contains("Computador venceu")) {
                vitoriasComputador++;
            } else {
                empates++;
            }
            
            // Mostra o placar atual
            System.out.println("\nPlacar:");
            System.out.println("Você: " + vitoriasUsuario);
            System.out.println("Computador: " + vitoriasComputador);
            System.out.println("Empates: " + empates);
            
            // Pergunta se o usuário deseja jogar novamente
            System.out.print("\nDeseja jogar novamente? (S/N): ");
            String resposta = scanner.next().toUpperCase();
            jogarNovamente = resposta.equals("S") || resposta.equals("SIM");
        }
        
        System.out.println("\nObrigado por jogar! Placar final:");
        System.out.println("Você: " + vitoriasUsuario);
        System.out.println("Computador: " + vitoriasComputador);
        System.out.println("Empates: " + empates);
        
        // Fecha o scanner para evitar vazamento de recursos
        scanner.close();
    }
    
    /**
     * Converte o número da opção para o nome correspondente
     */
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
    
    /**
     * Determina quem venceu o jogo com base nas escolhas
     */
    private static String determinarVencedor(int escolhaUsuario, int escolhaComputador) {
        // Se as escolhas forem iguais, é empate
        if (escolhaUsuario == escolhaComputador) {
            return "Empate!";
        }
        
        // Implementação das regras do jogo
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
    
    /**Explicação Passo a Passo
Importações: Importamos as classes Scanner para leitura de entrada do usuário e Random para gerar números aleatórios para a escolha do computador.

Classe Principal: Criamos a classe JogoPPTLS (PPTLS = Pedra, Papel, Tesoura, Lagarto, Spock).

Método Main:

Criamos os objetos Scanner e Random
Inicializamos as variáveis para controlar o jogo (placar e controle de loop)
Exibimos as regras do jogo
Iniciamos o loop principal
Loop do Jogo:

Mostramos o menu de opções
Validamos a entrada do usuário (deve ser um número entre 1 e 5)
Geramos uma escolha aleatória para o computador
Convertemos as escolhas numéricas para texto
Determinamos o vencedor usando o método auxiliar
Atualizamos o placar
Perguntamos se o jogador quer jogar novamente
Método converterNumeroParaOpcao:

Converte o número (1 a 5) para a string correspondente ("Pedra", "Papel", etc.)
Usa uma estrutura switch-case para fazer a conversão
Método determinarVencedor:

Primeiro verifica se é empate (ambos escolheram a mesma opção)
Usa uma estrutura switch-case aninhada para implementar todas as regras do jogo
Retorna uma string descrevendo o resultado (quem venceu e por quê)
     */
}