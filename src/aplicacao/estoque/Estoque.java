package aplicacao.estoque;

import aplicacao.produtos.Produtos;

import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produtos> itens; //lista de itens


    //Contrutor que inicializa o ArrayList

    public Estoque() {
        this.itens = new ArrayList<>();
    }


    //Metodo para adicionar Itens para o estoque

    public void adicionarItem(Produtos item) {
        if (item != null) {
            itens.add(item);
            System.out.println("Produto adicionado ao estoque" + item.getNome());
        } else {
            System.out.println("Produto inválido, não pode ser adicionado");
        }

    }


    //Medoto para remover um item pelo ID

    public boolean removerItem(Integer id) {
        for (Produtos item : itens) { // Percorre o ArrayList
            if (item.getId() == id) { // Verifica se o id existe
                itens.remove(item); // Remove o item do estoque
                System.out.println("Produto removido do estoque" + item.getNome());
                return true;
            }

        }
        System.out.println("Produto com Id: " + id + " não encontrado.");
        return false;
    }


    //Metodo para exibir estoque

    public void exibirEstoque() {
        System.out.println("---Etoque atual---");
        if (itens.isEmpty()) { //Verifica se o estoque esta vazio
            System.out.println("O estoque está vazio");
        } else {
            for (Produtos item : itens) { //Percorre o ArrayList

                System.out.println("Id: " + item.getId() + "\n" +
                        "Produto: " + item.getNome() + "\n" +
                        "Preço: " + item.getPreco() + "\n" +
                        "Quantidade em estoque: " + item.getQuantidade() + "\n");

            }
        }

    }

    //Metodo para buscar um Item pelo Id

    public Produtos bucarId(Integer id) {
        for (Produtos item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Retorna null
    }

}
