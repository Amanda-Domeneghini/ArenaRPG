package amanda;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome, int rank, double vida, double poder, Classe classe) {
        super(nome, rank, 50, 30, Classe.GUERREIRO);
    }

    @Override
    public double acao(Personagem alvo, int poder) {
        if (alvo.getVida() > 0 && (alvo.getVida() - poder) > 0) {
            alvo.setVida(alvo.getVida() - poder);
        } else {
            alvo.setVida(0);
        }
        return alvo.getVida();
    }
}
