package exercicios19MaioJavaFiama;

import java.util.Scanner;

/**
 * Ranking de Super-Heróis (Versão Simplificada)
 * Este programa permite cadastrar alguns heróis com atributos 
 * e calcula o poder total de cada um para criar um ranking.
 */
public class RankingHerois {
    public static void main(String[] args) {
        // Scanner para ler entrada do usuário
        Scanner scanner = new Scanner(System.in);
        
        // Arrays para armazenar os dados dos heróis
        // Podemos armazenar até 10 heróis
        String[] nomes = new String[10];
        int[] forcas = new int[10];
        int[] inteligencias = new int[10];
        int[] velocidades = new int[10];
        double[] poderes = new double[10];
        
        // Contador de heróis cadastrados
        int totalHerois = 0;
        
        // Boas-vindas
        System.out.println("=== RANKING DE SUPER-HERÓIS ===");
        
        // Definir pesos dos atributos
        System.out.println("\nDefina os pesos para a fórmula de poder:");
        System.out.print("Peso para Força: ");
        double pesoForca = scanner.nextDouble();
        
        System.out.print("Peso para Inteligência: ");
        double pesoInteligencia = scanner.nextDouble();
        
        System.out.print("Peso para Velocidade: ");
        double pesoVelocidade = scanner.nextDouble();
        
        scanner.nextLine(); // Limpar o buffer
        
        // Menu principal
        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar herói");
            System.out.println("2 - Ver ranking");
            System.out.println("3 - Comparar dois heróis");
            System.out.println("4 - Sair");
            System.out.print("Sua escolha: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1: // Cadastrar herói
                    if (totalHerois < 10) {
                        System.out.println("\n=== CADASTRO DE HERÓI ===");
                        
                        System.out.print("Nome do herói: ");
                        nomes[totalHerois] = scanner.nextLine();
                        
                        System.out.print("Força (1-100): ");
                        forcas[totalHerois] = scanner.nextInt();
                        
                        System.out.print("Inteligência (1-100): ");
                        inteligencias[totalHerois] = scanner.nextInt();
                        
                        System.out.print("Velocidade (1-100): ");
                        velocidades[totalHerois] = scanner.nextInt();
                        
                        // Calcular o poder total usando a fórmula
                        poderes[totalHerois] = (forcas[totalHerois] * pesoForca) + 
                                             (inteligencias[totalHerois] * pesoInteligencia) + 
                                             (velocidades[totalHerois] * pesoVelocidade);
                        
                        System.out.printf("\nHerói cadastrado! Poder total: %.2f\n", 
                                         poderes[totalHerois]);
                        
                        totalHerois++;
                        scanner.nextLine(); // Limpar o buffer
                    } else {
                        System.out.println("Limite máximo de heróis atingido (10)!");
                    }
                    break;
                    
                case 2: // Ver ranking
                    if (totalHerois == 0) {
                        System.out.println("\nNenhum herói cadastrado ainda.");
                    } else {
                        System.out.println("\n=== RANKING DE HERÓIS ===");
                        System.out.printf("Fórmula: (Força × %.1f) + (Inteligência × %.1f) + (Velocidade × %.1f)\n", 
                                         pesoForca, pesoInteligencia, pesoVelocidade);
                        
                        // Ordenar heróis pelo poder (do maior para o menor)
                        ordenarHeroisPorPoder(nomes, forcas, inteligencias, velocidades, poderes, totalHerois);
                        
                        // Exibir o ranking
                        System.out.println("\nPosição | Nome           | Força | Inteligência | Velocidade | Poder");
                        System.out.println("------------------------------------------------------------------");
                        
                        for (int i = 0; i < totalHerois; i++) {
                            System.out.printf("%-8d| %-15s| %-6d| %-12d| %-10d| %.2f\n", 
                                            (i+1), nomes[i], forcas[i], inteligencias[i], 
                                            velocidades[i], poderes[i]);
                        }
                    }
                    break;
                    
                case 3: // Comparar dois heróis
                    if (totalHerois < 2) {
                        System.out.println("\nPrecisa ter pelo menos 2 heróis para comparar.");
                    } else {
                        System.out.println("\n=== COMPARAÇÃO DE HERÓIS ===");
                        
                        // Mostrar lista de heróis
                        System.out.println("\nHeróis disponíveis:");
                        for (int i = 0; i < totalHerois; i++) {
                            System.out.println((i+1) + " - " + nomes[i]);
                        }
                        
                        // Selecionar primeiro herói
                        System.out.print("\nEscolha o número do primeiro herói: ");
                        int indice1 = scanner.nextInt() - 1; // Ajusta para o índice do array
                        
                        // Selecionar segundo herói
                        System.out.print("Escolha o número do segundo herói: ");
                        int indice2 = scanner.nextInt() - 1; // Ajusta para o índice do array
                        
                        // Verificar se os índices são válidos
                        if (indice1 >= 0 && indice1 < totalHerois && 
                            indice2 >= 0 && indice2 < totalHerois && 
                            indice1 != indice2) {
                            
                            System.out.println("\nComparação:");
                            System.out.println("Atributo      | " + nomes[indice1] + " | " + nomes[indice2]);
                            System.out.println("----------------------------------");
                            System.out.println("Força         | " + forcas[indice1] + " | " + forcas[indice2]);
                            System.out.println("Inteligência  | " + inteligencias[indice1] + " | " + inteligencias[indice2]);
                            System.out.println("Velocidade    | " + velocidades[indice1] + " | " + velocidades[indice2]);
                            System.out.printf("Poder Total   | %.2f | %.2f\n", 
                                             poderes[indice1], poderes[indice2]);
                            
                            // Identificar o mais poderoso
                            if (poderes[indice1] > poderes[indice2]) {
                                System.out.println("\n" + nomes[indice1] + " é mais poderoso!");
                            } else if (poderes[indice2] > poderes[indice1]) {
                                System.out.println("\n" + nomes[indice2] + " é mais poderoso!");
                            } else {
                                System.out.println("\nAmbos têm o mesmo poder!");
                            }
                            
                        } else {
                            System.out.println("Seleção inválida!");
                        }
                        scanner.nextLine(); // Limpar o buffer
                    }
                    break;
                    
                case 4: // Sair
                    sair = true;
                    System.out.println("\nObrigado por usar o Ranking de Heróis!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Ordena os arrays de heróis com base no poder total (do maior para o menor)
     * Usando o algoritmo de ordenação por seleção (simples de entender)
     */
    private static void ordenarHeroisPorPoder(String[] nomes, int[] forcas, int[] inteligencias, 
                                             int[] velocidades, double[] poderes, int totalHerois) {
        for (int i = 0; i < totalHerois - 1; i++) {
            // Encontrar o índice do herói mais poderoso
            int indiceMaiorPoder = i;
            
            for (int j = i + 1; j < totalHerois; j++) {
                if (poderes[j] > poderes[indiceMaiorPoder]) {
                    indiceMaiorPoder = j;
                }
            }
            
            // Trocar os heróis de posição (todos os atributos)
            if (indiceMaiorPoder != i) {
                // Trocar nomes
                String tempNome = nomes[i];
                nomes[i] = nomes[indiceMaiorPoder];
                nomes[indiceMaiorPoder] = tempNome;
                
                // Trocar forças
                int tempForca = forcas[i];
                forcas[i] = forcas[indiceMaiorPoder];
                forcas[indiceMaiorPoder] = tempForca;
                
                // Trocar inteligências
                int tempInteligencia = inteligencias[i];
                inteligencias[i] = inteligencias[indiceMaiorPoder];
                inteligencias[indiceMaiorPoder] = tempInteligencia;
                
                // Trocar velocidades
                int tempVelocidade = velocidades[i];
                velocidades[i] = velocidades[indiceMaiorPoder];
                velocidades[indiceMaiorPoder] = tempVelocidade;
                
                // Trocar poderes
                double tempPoder = poderes[i];
                poderes[i] = poderes[indiceMaiorPoder];
                poderes[indiceMaiorPoder] = tempPoder;
            }
        }
    }
}
/**Explicação Passo a Passo
1. Estrutura de Dados
Em vez de usar classes e objetos mais complexos, estou usando arrays simples para armazenar os dados:

nomes: Array para os nomes dos heróis
forcas, inteligencias, velocidades: Arrays para os atributos
poderes: Array para armazenar o poder total calculado
2. Funcionalidades
Menu Principal
O programa oferece 4 opções básicas:

Cadastrar herói
Ver ranking
Comparar dois heróis
Sair
Cadastro de Heróis
Limita o cadastro a 10 heróis para simplicidade
Solicita nome e os três atributos (força, inteligência, velocidade)
Calcula automaticamente o poder total usando a fórmula personalizada
Visualização do Ranking
Mostra a fórmula de poder utilizada
Ordena os heróis do mais poderoso para o menos poderoso
Exibe uma tabela com todos os atributos
Comparação de Heróis
Permite selecionar dois heróis pelo número
Mostra lado a lado os atributos para comparação
Identifica qual herói é mais poderoso
3. Algoritmo de Ordenação
O método ordenarHeroisPorPoder usa um algoritmo simples de ordenação por seleção:

Encontra o herói com maior poder
Troca a posição dele com o primeiro da lista não ordenada
Repete o processo para o resto da lista
Este código é mais simples que o anterior por várias razões:

Usa arrays em vez de classes e objetos
Tem um limite fixo de heróis (10)
Implementa menos verificações de erros
Usa um algoritmo de ordenação mais simples de entender
Não permite alterar a fórmula de poder depois de definida inicialmente*/