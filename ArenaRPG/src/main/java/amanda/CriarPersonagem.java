package amanda;

import java.util.Scanner;

public class CriarPersonagem {
    private Scanner scanner;

    public CriarPersonagem() {
        this.scanner = new Scanner(System.in);
    }

    public Personagem criar() {
        System.out.println("\n--- Criação de Personagem ---");
        System.out.print("Digite o nome do personagem: ");
        String nome = scanner.nextLine();

        System.out.println("Escolha a classe do personagem:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Mago");
        System.out.println("3. Arqueiro");
        System.out.print("Opção: ");

        int opcao = Integer.parseInt(scanner.nextLine());
        Classe classe;

        switch (opcao) {
            case 1:
                classe = Classe.GUERREIRO;
                break;
            case 2:
                classe = Classe.MAGO;
                break;
            case 3:
                classe = Classe.ARQUEIRO;
                break;
            default:
                System.out.println("Opção inválida! Definindo como Guerreiro por padrão.");
                classe = Classe.GUERREIRO;
                break;
        }

        System.out.print("Digite os pontos de vida (ex: 100): ");
        double vida = Double.parseDouble(scanner.nextLine());

        System.out.print("Digite a força (ex: 20): ");
        double forca = Double.parseDouble(scanner.nextLine());

        switch (classe) {
            case GUERREIRO:
                return new Guerreiro(nome, 1, vida, forca, Classe.GUERREIRO);
            case MAGO:
                return new Mago(nome, 1, vida, forca, Classe.MAGO);
            case ARQUEIRO:
                return new Arqueiro(nome, 1, vida, forca, Classe.ARQUEIRO);
            default:
                return new Guerreiro(nome, 1, vida, forca, Classe.GUERREIRO);
        }
    }
}
