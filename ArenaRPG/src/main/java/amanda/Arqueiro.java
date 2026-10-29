package amanda;

public class Arqueiro extends Personagem {
    public Arqueiro (String nome, int rank, double vida, double poder, Classe classe){
        super(nome, rank, 100, 20, Classe.ARQUEIRO)
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
