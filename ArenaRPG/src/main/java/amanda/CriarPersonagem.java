package amanda;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CriarPersonagem {
    private static final Map<String, Personagem> mapaPersonagens = new HashMap<>();

    public void adicionarPersonagem(Personagem personagem) {
        if (personagem != null && personagem.getNome() != null && !mapaPersonagens.containsKey(personagem.getNome())) {
            mapaPersonagens.put(personagem.getNome(), personagem);
        }
    }

    public Personagem getPorNome(String nome) {
        return mapaPersonagens.get(nome);
    }

    public Map<String, Personagem> getMapaPersonagens() {
        return mapaPersonagens;
    }

    public Collection<Personagem> getTodosPersonagems() {
        return mapaPersonagens.values();
    }
}
