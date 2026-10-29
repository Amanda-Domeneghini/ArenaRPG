package amanda;

import java.util.*;
import java.util.stream.Collectors;

public class Arena {
    private List<Personagem> personagens;

    public Arena() {
        this.personagens = PersonagensCarregados.carregar();
    }

    public void adicionarPersonagem(Personagem p) {
        personagens.add(p);
        PersonagensCarregados.salvar(personagens);
        System.out.println("Personagem " + p.getNome() + " adicionado com sucesso!");
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public List<Personagem> listarVivos() {
        return personagens.stream()
                .filter(p -> p.getVida() > 0)
                .collect(Collectors.toList());
    }

    public double vidaMedia() {
        return personagens.stream()
                .mapToDouble(Personagem::getVida)
                .average()
                .orElse(0.0);
    }

    public Optional<Personagem> maisForte() {
        return personagens.stream()
                .max(Comparator.comparingDouble(Personagem::getPoder));
    }

    public long contarPorClasse(Classe classe) {
        return personagens.stream()
                .filter(p -> p.getClasse() == classe)
                .count();
    }

    public void lutar(Personagem p1, Personagem p2) {
        if (p1.getVida() <= 0 || p2.getVida() <= 0) {
            System.out.println("Ambos os personagens precisam ter vida maior que 0 para lutar!");
            return;
        }

        System.out.println("\n=== INÍCIO DO COMBATE: " + p1.getNome() + " VS " + p2.getNome() + " ===");

        p1.acao(p2, (int) p1.getPoder());

        if (p1 instanceof Curavel && p1.getVida() > 0) {
            p1.setVida(p1.getVida() + 15);
            System.out.println(p1.getNome() + " usou cura e agora tem " + p1.getVida() + " de vida.");
        }

        if (p2.getVida() > 0) {
            p2.acao(p1, (int) p2.getPoder());

            if (p2 instanceof Curavel && p2.getVida() > 0) {
                p2.setVida(p2.getVida() + 15);
                System.out.println(p2.getNome() + " usou cura e agora tem " + p2.getVida() + " de vida.");
            }
        }

        PersonagensCarregados.salvar(personagens);
    }
}
