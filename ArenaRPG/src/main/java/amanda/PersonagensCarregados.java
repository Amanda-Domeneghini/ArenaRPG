package amanda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagensCarregados {
    private static final String CAMINHO_ARQUIVO = "personagens.csv";

    // Carrega a lista de personagens a partir do CSV
    public static List<Personagem> carregar() {
        List<Personagem> lista = new ArrayList<>();
        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty())
                    continue;
                String[] partes = linha.split(";");

                String nome = partes[0];
                Classe classe = Classe.valueOf(partes[1]);
                double vida = Double.parseDouble(partes[2]);
                double forca = Double.parseDouble(partes[3]);

                switch (classe) {
                    case GUERREIRO:
                        lista.add(new Guerreiro(nome, vida, forca));
                        break;
                    case MAGO:
                        lista.add(new Mago(nome, vida, forca));
                        break;
                    case ARQUEIRO:
                        lista.add(new Arqueiro(nome, vida, forca));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo CSV: " + e.getMessage());
        }
        return lista;
    }

    // Salva a lista atual de personagens no CSV
    public static void salvar(List<Personagem> personagens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Personagem p : personagens) {
                writer.write(p.getNome() + ";" + p.getClasse() + ";" + p.getVida() + ";" + p.getForca());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo CSV: " + e.getMessage());
        }
    }
}
