package model;

/* foi necessário implementar o Comparable<Produto> para poder utilizar o compareTo que será especificado abaixo a
 forma de comparação */
public class Produto implements Comparable<Produto> {

    private String produto;
    private Double preco;

    public Produto(String produto, Double preco) {
        this.produto = produto;
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto = " + produto + "Preço = " + String.format("%.2f", preco);
    }

    @Override// implementação obrigatória do Comparable especificando como a comparação será realizada
    public int compareTo(Produto outro) {
        return preco.compareTo(outro.getPreco());
    }
}
