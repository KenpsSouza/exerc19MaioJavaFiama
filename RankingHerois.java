package exercicios19MaioJavaFiama;

import java.util.Scanner;


public class RankingHerois {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Arrays para armazenar os dados dos heróis
        // Podemos armazenar até 10 heróis
        String[] nomes = new String[10];
        int[] forcas = new int[10];
        int[] inteligencias = new int[10];
        int[] velocidades = new int[10];
        double[] poderes = new double[10];
        
        int totalHerois = 0;
        
        System.out.println("Bem-vindo ao Sistema de Ranking de Super-Heróis!");
        System.out.println("       === RANKING DE SUPER-HERÓIS ===");
        
        System.out.println("\nDefina os pesos para a fórmula de poder:");
        System.out.print("Peso para Força: ");
        double pesoForca = sc.nextDouble();
        
        System.out.print("Peso para Inteligência: ");
        double pesoInteligencia = sc.nextDouble();
        
        System.out.print("Peso para Velocidade: ");
        double pesoVelocidade = sc.nextDouble();
        
        sc.nextLine(); 
        
        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar herói");
            System.out.println("2 - Ver ranking");
            System.out.println("3 - Comparar dois heróis");
            System.out.println("4 - Sair");
            System.out.print("Sua escolha: ");
            
            int opcao = sc.nextInt();
            sc.nextLine(); 
            
            switch (opcao) {
                case 1: 
                    if (totalHerois < 10) {
                        System.out.println("\n=== CADASTRO DE HERÓI ===");
                        
                        System.out.print("Nome do herói: ");
                        nomes[totalHerois] = sc.nextLine();
                        
                        System.out.print("Força (1-100): ");
                        forcas[totalHerois] = sc.nextInt();
                        
                        System.out.print("Inteligência (1-100): ");
                        inteligencias[totalHerois] = sc.nextInt();
                        
                        System.out.print("Velocidade (1-100): ");
                        velocidades[totalHerois] = sc.nextInt();
                        
                        poderes[totalHerois] = (forcas[totalHerois] * pesoForca) + 
                                             (inteligencias[totalHerois] * pesoInteligencia) + 
                                             (velocidades[totalHerois] * pesoVelocidade);
                        
                        System.out.printf("\nHerói cadastrado! Poder total: %.2f\n", 
                                         poderes[totalHerois]);
                        
                        totalHerois++;
                        sc.nextLine(); 
                    } else {
                        System.out.println("Limite máximo de heróis atingido (10)!");
                    }
                    break;
                    
                case 2: 
                    if (totalHerois == 0) {
                        System.out.println("\nNenhum herói cadastrado ainda.");
                    } else {
                        System.out.println("\n=== RANKING DE HERÓIS ===");
                        System.out.printf("Fórmula: (Força × %.1f) + (Inteligência × %.1f) + (Velocidade × %.1f)\n", 
                                         pesoForca, pesoInteligencia, pesoVelocidade);
                        
                        ordenarHeroisPorPoder(nomes, forcas, inteligencias, velocidades, poderes, totalHerois);
                        
                        System.out.println("\nPosição | Nomees           | Força | Inteligência | Velocidade | Poder");
                        System.out.println("------------------------------------------------------------------");
                        
                        for (int i = 0; i < totalHerois; i++) {
                            System.out.printf("%-8d| %-15s| %-6d| %-12d| %-10d| %.2f\n", 
                                            (i+1), nomes[i], forcas[i], inteligencias[i], 
                                            velocidades[i], poderes[i]);
                        }
                    }
                    break;
                    
                case 3:
                    if (totalHerois < 2) {
                        System.out.println("\nPrecisa ter pelo menos 2 heróis para comparar.");
                    } else {
                        System.out.println("\n=== COMPARAÇÃO DE HERÓIS ===");
                        
                        System.out.println("\nHeróis disponíveis:");
                        for (int i = 0; i < totalHerois; i++) {
                            System.out.println((i+1) + " - " + nomes[i]);
                        }
                        
                        System.out.print("\nEscolha o número do primeiro herói: ");
                        int indice1 = sc.nextInt() - 1; 
                        
                        System.out.print("Escolha o número do segundo herói: ");
                        int indice2 = sc.nextInt() - 1; 
                        
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
                        sc.nextLine(); 
                    }
                    break;
                    
                case 4: 
                    sair = true;
                    System.out.println("\nObrigado por usar o Ranking de Heróis!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        sc.close();
    }
    
    
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
            
            if (indiceMaiorPoder != i) {
                String tempNome = nomes[i];
                nomes[i] = nomes[indiceMaiorPoder];
                nomes[indiceMaiorPoder] = tempNome;
                
                int tempForca = forcas[i];
                forcas[i] = forcas[indiceMaiorPoder];
                forcas[indiceMaiorPoder] = tempForca;
                
                int tempInteligencia = inteligencias[i];
                inteligencias[i] = inteligencias[indiceMaiorPoder];
                inteligencias[indiceMaiorPoder] = tempInteligencia;
                
                int tempVelocidade = velocidades[i];
                velocidades[i] = velocidades[indiceMaiorPoder];
                velocidades[indiceMaiorPoder] = tempVelocidade;
                
                double tempPoder = poderes[i];
                poderes[i] = poderes[indiceMaiorPoder];
                poderes[indiceMaiorPoder] = tempPoder;
            }
        }
    }
}
