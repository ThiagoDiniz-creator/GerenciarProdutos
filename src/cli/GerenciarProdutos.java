package cli;

import model.Produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GerenciarProdutos {
    private final ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarProdutos gp = new GerenciarProdutos();
        Scanner sc = new Scanner(System.in);

        int opt = 0;
        while (opt != 5) {
            exibirMenu();

            opt = Integer.parseInt(sc.nextLine());
            switch (opt) {
                // Cadastro de produto.
                case 1:
                    Produto produto = new Produto();
                    System.out.println("Digite o nome do produto: ");
                    produto.setNome(sc.nextLine());
                    System.out.printf("Digite o preço do produto (%s): ", produto.getNome());
                    produto.setPreco(Double.parseDouble(sc.nextLine()));
                    gp.addProduto(produto);
                    break;
                // Entrada de produtos.
                case 2:
                    gp.printProdutos();
                    System.out.println("Digite o código do produto: ");
                    int idx = Integer.parseInt(sc.nextLine());

                    if (gp.produtos.size() > idx) {
                        Produto prod = gp.produtos.get(idx);
                        System.out.printf("Digite a quantidade de itens (%s) que serão adicionados: ", prod.getNome());
                        int amount = Integer.parseInt(sc.nextLine());

                        prod.addQuantidade(amount);
                    } else {
                        System.out.println("O código digitado é inválido!");
                    }
                    break;
                // Saída de produtos.
                case 3:
                    gp.printProdutos();
                    System.out.println("Digite o código do produto: ");
                    int idx1 = Integer.parseInt(sc.nextLine());
                    if (gp.produtos.size() > idx1) {
                        Produto prod = gp.produtos.get(idx1);
                        System.out.printf("Digite a quantidade de itens (%s) que serão adicionados: ", prod.getNome());
                        int amount = Integer.parseInt(sc.nextLine());

                        prod.removeQuantidade(amount);
                    } else {
                        System.out.println("O código digitado é inválido!");
                    }
                    break;
                // Estoque atual
                case 4:
                    double total = 0;
                    for (Produto prod : gp.produtos) {
                        System.out.printf("%s -- Preço: %.2f -- Quantidade: %d -- Valor estimado:" +
                                " %.2f\n", prod.getNome(), prod.getPreco(), prod.getQuantidade(), prod.getTotal());
                        total += prod.getTotal();
                    }
                    System.out.println("Valor total estimado no estoque: " + total);
                    break;
                case 5:
                    System.out.println("FINALIZANDO SISTEMA!");
                    break;
                default:
                    System.out.println(opt + " não é um número válido");
                    break;
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("Sistema de gerenciamento de produtos");
        System.out.println("1 => Cadastrar produtos;");
        System.out.println("2 => Entrada de produtos;");
        System.out.println("3 => Saída de produtos;");
        System.out.println("4 => Estoque atual;");
        System.out.println("5 => Sair.");
        System.out.println("Digite a operação desejada: ");
    }

    public void printProdutos() {
        Iterator<Produto> iterable = this.produtos.iterator();
        for (int i = 0; i < this.produtos.toArray().length; i++) {
            Produto prod = iterable.next();
            System.out.printf("Código: %d -- Produto: %s -- Quantidade: %d \n", i, prod.getNome(), prod.getQuantidade());
        }
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }
}