package aplicacao;

import aplicacao.estoque.Estoque;
import aplicacao.produtos.Produtos;
import aplicacao.vendas.Vendas;

import java.util.Scanner;

public class Aplicacao{
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Vendas vendas = new Vendas();
        Scanner scanner = new Scanner(System.in);

        boolean executar = true;

        while (executar) {
            System.out.println("\n--- Sistema de Gestão de Estoque e Vendas ---");
            System.out.println("1. Adicionar Produto ao Estoque");
            System.out.println("2. Remover Produto do Estoque");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Realizar Venda");
            System.out.println("5. Exibir Resumo de Vendas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = scanner.nextInt();

                    Produtos produto = new Produtos(id, nome, preco, quantidade);
                    estoque.adicionarItem(produto);
                }
                case 2 -> {
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int id = scanner.nextInt();
                    estoque.removerItem(id);
                }
                case 3 -> estoque.exibirEstoque();
                case 4 -> {
                    System.out.print("Digite o ID do produto para venda: ");
                    int id = scanner.nextInt();

                    Produtos produto = estoque.bucarId(id);
                    if (produto == null) {
                        System.out.println("Produto não encontrado no estoque.");
                        break;
                    }

                    System.out.print("Digite a quantidade a ser vendida: ");
                    int quantidade = scanner.nextInt();

                    if (vendas.adicionarVenda(produto, quantidade)) {
                        System.out.println("Venda realizada com sucesso.");
                    }
                }
                case 5 -> vendas.exibirResumoVenda();
                case 6 -> {
                    System.out.println("Saindo do sistema...");
                    executar = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
