package model;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String nome, String descricao, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String toCSV() {
        return codigo + "," + nome + "," + descricao + "," + preco + "," + quantidade;
    }
}