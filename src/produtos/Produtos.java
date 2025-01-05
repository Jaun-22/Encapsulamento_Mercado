package produtos;

import java.security.PublicKey;

public class Produtos {

    //ATRIBUTOS
    private Integer id;
    private String nome;
    private Double preco;
    private Integer quantidade;

    //METODO SEM ARGUMENTO

    public Produtos() {

    }


    //METODO COM ARGUMENTO

    public Produtos(Integer id, String nome, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }


    //--- GET- ID---//

    public Integer getId() {
        return this.id;
    }


    //---GET - NOME---//

    public String getNome() {
        return this.nome;
    }


    //---GETTERS E SETTERS - PRECO---//

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


    //---GETTERS E SETTERS - QUANTIDADE---//

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida");
        }

    }

    public void exibirStatus() {
        System.out.println("Id do produto: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Preço: " + preco + "\n" +
                "Quantidade: " + quantidade);
    }

}



