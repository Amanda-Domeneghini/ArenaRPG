package amanda;

public class Mago extends Personagem implements Curavel {

    public Mago(String nome, int rank, double vida, double poder, Classe classe) {
        super(nome, rank, 150, 20, Classe.MAGO);
    }

    @Override
    public double acao(Personagem alvo, int poder) {
        curar(alvo, poder);
        return alvo.getVida();
    }

    public void curar(Personagem alvo, double quantidadeCura) {
        double novaVida = alvo.getVida() + quantidadeCura;
        alvo.setVida(novaVida);
    }

    @Override
    public Classe getClasse() {
        return Classe.MAGO;
    }

    @Override
    public double getPoder() {
        return super.getPoder();
    }
}
