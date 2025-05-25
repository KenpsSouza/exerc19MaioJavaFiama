package exercicios19MaioJavaFiama;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Ranking de Super-Heróis
 * Este programa permite gerenciar super-heróis com diferentes atributos,
 * criar um ranking baseado em uma fórmula de poder personalizada e
 * comparar heróis entre si.
 */
public class RankingHerois {
    
    // Lista para armazenar os heróis cadastrados
    private static ArrayList<Heroi> herois = new ArrayList<>();
    
    // Pesos dos atributos para o cálculo do poder total (personalizáveis)
    private static double pesoForca = 1.0;
    private static double pesoInteligencia = 1.0;
    private static double pesoVelocidade = 1.0;
    
    // Scanner para entrada de dados do usuário
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Cadastra alguns heróis iniciais para exemplo
        cadastrarHeroisIniciais();
        
        boolean continuar = true;
        
        // Menu principal
        System.out.println("=== RANKING DE SUPER-HERÓIS ===\n");
        
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Ver ranking de heróis");
            System.out.println("2 - Cadastrar novo herói");
            System.out.println("3 - Comparar dois heróis");
            System.out.println("4 - Personalizar fórmula de poder");
            System.out.println("5 - Sair");
            
            System.out.print("\nDigite sua escolha: ");
            
            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer
                continue;
            }
            
            switch (opcao) {
                case 1:
                    exibirRanking();
                    break;
                case 2:
                    cadastrarNovoHeroi();
                    break;
                case 3:
                    compararHerois();
                    break;
                case 4:
                    personalizarFormula();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("\nObrigado por usar o Ranking de Super-Heróis!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Cadastra alguns heróis iniciais para exemplo
     */
    private static void cadastrarHeroisIniciais() {
        herois.add(new Heroi("Superman", 95, 70, 90));
        herois.add(new Heroi("Batman", 70, 100, 65));
        herois.add(new Heroi("Mulher Maravilha", 85, 80, 75));
        herois.add(new Heroi("Flash", 60, 75, 100));
        herois.add(new Heroi("Hulk", 100, 60, 50));
    }
    
    /**
     * Exibe o ranking completo de heróis ordenado pelo poder total
     */
    private static void exibirRanking() {
        if (herois.isEmpty()) {
            System.out.println("Não há heróis cadastrados ainda.");
            return;
        }
        
        // Atualiza o poder total de todos os heróis com base nos pesos atuais
        for (Heroi heroi : herois) {
            heroi.calcularPoderTotal(pesoForca, pesoInteligencia, pesoVelocidade);
        }
        
        // Ordena a lista de heróis pelo poder total (do maior para o menor)
        Collections.sort(herois, Comparator.comparing(Heroi::getPoderTotal).reversed());
        
        System.out.println("\n=== RANKING DE SUPER-HERÓIS ===");
        System.out.println("Fórmula atual: " + 
                          String.format("(Força × %.1f) + (Inteligência × %.1f) + (Velocidade × %.1f)", 
                          pesoForca, pesoInteligencia, pesoVelocidade));
        
        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-15s %-15s %-10s\n", 
                         "Pos.", "Nome", "Força", "Inteligência", "Velocidade", "Poder Total");
        System.out.println("---------------------------------------------------------------");
        
        int posicao = 1;
        for (Heroi heroi : herois) {
            System.out.printf("%-5d %-20s %-10d %-15d %-15d %-10.2f\n", 
                             posicao++, heroi.getNome(), heroi.getForca(), 
                             heroi.getInteligencia(), heroi.getVelocidade(), 
                             heroi.getPoderTotal());
        }
        System.out.println("---------------------------------------------------------------");
    }
    
    /**
     * Permite ao usuário cadastrar um novo herói
     */
    private static void cadastrarNovoHeroi() {
        System.out.println("\n=== CADASTRO DE NOVO HERÓI ===");
        
        System.out.print("Nome do herói: ");
        String nome = scanner.nextLine();
        
        int forca = lerAtributo("Força (1-100): ");
        int inteligencia = lerAtributo("Inteligência (1-100): ");
        int velocidade = lerAtributo("Velocidade (1-100): ");
        
        Heroi novoHeroi = new Heroi(nome, forca, inteligencia, velocidade);
        novoHeroi.calcularPoderTotal(pesoForca, pesoInteligencia, pesoVelocidade);
        herois.add(novoHeroi);
        
        System.out.println("\nHerói cadastrado com sucesso!");
        System.out.printf("%s possui poder total de: %.2f\n", nome, novoHeroi.getPoderTotal());
    }
    
    /**
     * Lê um valor de atributo do usuário, garantindo que esteja entre 1 e 100
     */
    private static int lerAtributo(String mensagem) {
        int valor;
        while (true) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                
                if (valor >= 1 && valor <= 100) {
                    return valor;
                } else {
                    System.out.println("O valor deve estar entre 1 e 100.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }
    
    /**
     * Permite ao usuário comparar dois heróis
     */
    private static void compararHerois() {
        if (herois.size() < 2) {
            System.out.println("É necessário ter pelo menos 2 heróis cadastrados para comparar.");
            return;
        }
        
        System.out.println("\n=== COMPARAÇÃO DE HERÓIS ===");
        
        // Listar heróis disponíveis
        listarHerois();
        
        // Selecionar o primeiro herói
        System.out.print("\nEscolha o número do primeiro herói: ");
        int index1 = selecionarHeroi();
        
        // Selecionar o segundo herói
        System.out.print("Escolha o número do segundo herói: ");
        int index2 = selecionarHeroi();
        
        if (index1 == index2) {
            System.out.println("Você selecionou o mesmo herói duas vezes. Tente novamente.");
            return;
        }
        
        Heroi heroi1 = herois.get(index1);
        Heroi heroi2 = herois.get(index2);
        
        // Atualiza os poderes totais
        heroi1.calcularPoderTotal(pesoForca, pesoInteligencia, pesoVelocidade);
        heroi2.calcularPoderTotal(pesoForca, pesoInteligencia, pesoVelocidade);
        
        // Exibe a comparação
        System.out.println("\n=== RESULTADO DA COMPARAÇÃO ===");
        
        System.out.println("\n--------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s\n", "Atributo", heroi1.getNome(), heroi2.getNome());
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s %-10d %-10d %s\n", "Força", heroi1.getForca(), heroi2.getForca(),
                         compararAtributos(heroi1.getForca(), heroi2.getForca()));
        System.out.printf("%-20s %-10d %-10d %s\n", "Inteligência", heroi1.getInteligencia(),
                         heroi2.getInteligencia(), compararAtributos(heroi1.getInteligencia(), heroi2.getInteligencia()));
        System.out.printf("%-20s %-10d %-10d %s\n", "Velocidade", heroi1.getVelocidade(), 
                         heroi2.getVelocidade(), compararAtributos(heroi1.getVelocidade(), heroi2.getVelocidade()));
        System.out.printf("%-20s %-10.2f %-10.2f %s\n", "Poder Total", heroi1.getPoderTotal(),
                         heroi2.getPoderTotal(), compararAtributos(heroi1.getPoderTotal(), heroi2.getPoderTotal()));
        System.out.println("--------------------------------------------------");
        
        // Determinando o vencedor
        if (heroi1.getPoderTotal() > heroi2.getPoderTotal()) {
            System.out.printf("\n%s é mais poderoso que %s por %.2f pontos!\n",
                             heroi1.getNome(), heroi2.getNome(), heroi1.getPoderTotal() - heroi2.getPoderTotal());
        } else if (heroi2.getPoderTotal() > heroi1.getPoderTotal()) {
            System.out.printf("\n%s é mais poderoso que %s por %.2f pontos!\n",
                             heroi2.getNome(), heroi1.getNome(), heroi2.getPoderTotal() - heroi1.getPoderTotal());
        } else {
            System.out.printf("\n%s e %s têm exatamente o mesmo poder total!\n",
                             heroi1.getNome(), heroi2.getNome());
        }
    }
    
    /**
     * Lista todos os heróis com seus índices
     */
    private static void listarHerois() {
        System.out.println("\nHeróis disponíveis:");
        for (int i = 0; i < herois.size(); i++) {
            System.out.printf("%d - %s\n", i, herois.get(i).getNome());
        }
    }
    
    /**
     * Seleciona um herói da lista validando a entrada
     */
    private static int selecionarHeroi() {
        int index;
        while (true) {
            try {
                index = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                
                if (index >= 0 && index < herois.size()) {
                    return index;
                } else {
                    System.out.print("Índice inválido. Tente novamente: ");
                }
            } catch (Exception e) {
                System.out.print("Entrada inválida. Digite um número: ");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }
    
    /**
     * Compara dois valores e retorna uma indicação visual de qual é maior
     */
    private static String compararAtributos(double valor1, double valor2) {
        if (valor1 > valor2) {
            return "(↑)";  // Seta para cima indica primeiro valor maior
        } else if (valor2 > valor1) {
            return "(↓)";  // Seta para baixo indica segundo valor maior
        } else {
            return "(=)";  // Iguais
        }
    }
    
    /**
     * Permite ao usuário personalizar a fórmula de poder
     */
    private static void personalizarFormula() {
        System.out.println("\n=== PERSONALIZAR FÓRMULA DE PODER ===");
        System.out.println("Defina os pesos para cada atributo (valores decimais permitidos)");
        
        try {
            System.out.print("Peso para Força (atual: " + pesoForca + "): ");
            pesoForca = scanner.nextDouble();
            
            System.out.print("Peso para Inteligência (atual: " + pesoInteligencia + "): ");
            pesoInteligencia = scanner.nextDouble();
            
            System.out.print("Peso para Velocidade (atual: " + pesoVelocidade + "): ");
            pesoVelocidade = scanner.nextDouble();
            
            scanner.nextLine(); // Limpa o buffer
            
            System.out.println("\nFórmula atualizada: " + 
                               String.format("(Força × %.1f) + (Inteligência × %.1f) + (Velocidade × %.1f)", 
                               pesoForca, pesoInteligencia, pesoVelocidade));
            
            // Recalcula os poderes totais
            for (Heroi heroi : herois) {
                heroi.calcularPoderTotal(pesoForca, pesoInteligencia, pesoVelocidade);
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. A fórmula não foi alterada.");
            scanner.nextLine(); // Limpa o buffer
        }
    }
}

/**
 * Classe que representa um super-herói com seus atributos
 */
class Heroi {
    private String nome;
    private int forca;
    private int inteligencia;
    private int velocidade;
    private double poderTotal;
    
    /**
     * Construtor da classe Heroi
     */
    public Heroi(String nome, int forca, int inteligencia, int velocidade) {
        this.nome = nome;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.velocidade = velocidade;
        // O poder total será calculado separadamente
    }
    
    /**
     * Calcula o poder total com base nos pesos de cada atributo
     */
    public void calcularPoderTotal(double pesoForca, double pesoInteligencia, double pesoVelocidade) {
        this.poderTotal = (this.forca * pesoForca) + 
                          (this.inteligencia * pesoInteligencia) + 
                          (this.velocidade * pesoVelocidade);
    }
    
    // Getters
    public String getNome() {
        return nome;
    }
    
    public int getForca() {
        return forca;
    }
    
    public int getInteligencia() {
        return inteligencia;
    }
    
    public int getVelocidade() {
        return velocidade;
    }
    
    public double getPoderTotal() {
        return poderTotal;
    }
}