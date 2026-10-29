package amanda;

public abstract class Personagem {
    private String nome;
    private int rank;
    private double vida;
    private double poder;
    private Classe classe;

    public Personagem(String nome, int rank, double vida, double poder, Classe classe) {
        this.nome = nome;
        this.rank = rank;
        this.vida = vida;
        this.poder = poder;
        this.classe = classe;
    }

    public String getNome() {
        return nome;
    }

    public int getRank() {
        return rank;
    }

    public double getVida() {
        return vida;
    }

    public double getPoder() {
        return poder;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setVida(double vida) {
        if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    public abstract double acao(Personagem alvo, int atacar);
}
