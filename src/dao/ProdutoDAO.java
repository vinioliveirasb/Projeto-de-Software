package dao;

import model.Produto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProdutoDAO {

    private static final String ARQUIVO = "produtos.csv";

    public void salvarProduto(Produto produto) {

        File file = new File(ARQUIVO);
        boolean arquivoExiste = file.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {

            // Se o arquivo não existir, escreve o cabeçalho
            if (!arquivoExiste) {
                writer.write("Código,Nome,Descrição,Preço,Quantidade");
                writer.newLine();
            }

            writer.write(produto.toCSV());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}