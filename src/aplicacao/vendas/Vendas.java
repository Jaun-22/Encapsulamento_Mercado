package aplicacao.vendas;

import aplicacao.produtos.Produtos;

import java.util.ArrayList;

public class Vendas {

    private ArrayList<Produtos> itensVendidos; //lista para armazenar as vendas
    private Double valorTotal; //Armazenar o valor total das vendas


    // Construtor para inicialiar os atributos

    public Vendas() {
        this.itensVendidos = new ArrayList<>(); // Inicialia a lista de itens vendidos
        this.valorTotal = 0.0; // valor total inicializado com 0

    }


    // Metodo para adicionar um produto a venda

    public boolean adicionarVenda(Produtos produtos, Integer quantidade) {
        if (produtos == null) {
            System.out.println("Erro: Produto invalido");
            return false; // Se o produto não existe, não faz nada
        }

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida!");
        }

        if (produtos.getQuantidade() < quantidade) {
            System.out.println("Erro: Estoque insuficiente para o produto" + produtos.getNome());
            return false; // Verifica se há quantidade suficiente no estoque
        }

        // Atualiza o estoque e adiciona o produto a lista de itens vendidos
        produtos.setQuantidade(produtos.getQuantidade() - quantidade); // Atualiza a quantidade no estoque
        Produtos vendido = new Produtos(produtos.getId(), produtos.getNome(), produtos.getPreco(), quantidade);
        itensVendidos.add(vendido); // Adiciona o produto vendido à lista
        valorTotal += produtos.getPreco() * quantidade; // Atualiza o valor total da venda
        System.out.println("Produto " + produtos.getNome() + " adicionado à venda.");
        return true;

    }


    // Metodo para exibir o status da venda
    public void exibirResumoVenda() {
        System.out.println("\n--- Resumo da Venda ---");
        if (itensVendidos.isEmpty()) {
            System.out.println("Nenhum produto vendido.");
        } else {
            for (Produtos item : itensVendidos) {
                System.out.println("Produto: " + item.getNome() +
                        ", Quantidade: " + item.getQuantidade() +
                        ", Preço Unitário: " + item.getPreco() +
                        ", Total: " + (item.getPreco() * item.getQuantidade()));
            }
            System.out.println("Valor total da venda: R$ " + valorTotal);
        }
    }

}
