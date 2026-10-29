package amanda;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Arena arena = new Arena();
        CriarPersonagem criador = new CriarPersonagem();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== ARENA RPG ===");
            System.out.println("1. Criar Personagem");
            System.out.println("2. Listar Personagens Vivos");
            System.out.println("3. Lutar");
            System.out.println("4. Ver Ranking e Estatísticas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    Personagem novo = criador.criar();
                    arena.adicionarPersonagem(novo);
                    break;

                case 2:
                    System.out.println("\n--- Personagens Vivos ---");
                    List<Personagem> vivos = arena.listarVivos();
                    if (vivos.isEmpty()) {
                        System.out.println("Nenhum personagem vivo na arena.");
                    } else {
                        vivos.forEach(p -> System.out
                                .println(p.getNome() + " | Vida: " + p.getVida() + " | Classe: " + p.getClasse()));
                    }
                    break;

                case 3:
                    List<Personagem> disponiveis = arena.listarVivos();
                    if (disponiveis.size() < 2) {
                        System.out.println("É necessário ter pelo menos 2 personagens vivos para lutar!");
                        break;
                    }

                    System.out.println("\nEscolha o atacante:");
                    for (int i = 0; i < disponiveis.size(); i++) {
                        System.out.println(i + ". " + disponiveis.get(i).getNome());
                    }
                    int idx1 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Escolha o alvo:");
                    for (int i = 0; i < disponiveis.size(); i++) {
                        if (i != idx1) {
                            System.out.println(i + ". " + disponiveis.get(i).getNome());
                        }
                    }
                    int idx2 = Integer.parseInt(scanner.nextLine());

                    arena.lutar(disponiveis.get(idx1), disponiveis.get(idx2));
                    break;

                case 4:
                    System.out.println("\n--- ESTATÍSTICAS DA ARENA ---");
                    System.out.println("Vida Média: " + String.format("%.2f", arena.vidaMedia()));

                    Optional<Personagem> maisForte = arena.maisForte();
                    maisForte.ifPresent(
                            p -> System.out.println("Mais Forte: " + p.getNome() + " (Força: " + p.getForca() + ")"));

                    System.out.println("Guerreiros: " + arena.contarPorClasse(Classe.GUERREIRO));
                    System.out.println("Magos: " + arena.contarPorClasse(Classe.MAGO));
                    System.out.println("Arqueiros: " + arena.contarPorClasse(Classe.ARQUEIRO));
                    break;

                case 5:
                    executando = false;
                    System.out.println("Saindo da Arena RPG. Até a próxima!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
