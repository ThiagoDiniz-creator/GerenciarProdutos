package model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void addQuantidade(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
        System.out.printf("%d novos itens (%s) adicionados. Estoque atual: %d.\n", quantidade, this.nome, this.quantidade);
    }

    public void removeQuantidade(int quantidade) {
        if (this.quantidade - quantidade > 0) {
            this.quantidade -= quantidade;
            System.out.printf("%d itens (%s) foram retirados. Estoque atual: %d.\n", quantidade, this.nome, this.quantidade);
        } else {
            System.out.printf("O estoque atual (%d) não permite a retirada de %d itens.", this.quantidade, quantidade);
        }
    }


    public double getTotal() {
        return this.quantidade * this.preco;
    }
}
