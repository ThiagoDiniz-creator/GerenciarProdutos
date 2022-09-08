package model;

public class Produto {
    private String nome = "PRODUTO_PADRÃO";
    private double preco = 0;
    private int quantidade = 0;

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
        if (quantidade >= 0)
            this.quantidade = this.quantidade + quantidade;
    }

    public boolean removeQuantidade(int quantidade) {
        if (this.quantidade - quantidade > 0) {
            this.quantidade -= quantidade;
            return true;
        } else {
            return false;
        }
    }


    public double getTotal() {
        return this.quantidade * this.preco;
    }
}
