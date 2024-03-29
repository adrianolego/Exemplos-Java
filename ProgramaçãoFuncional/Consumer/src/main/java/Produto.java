public class Produto {
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

    public static void atualizacao(Produto p) {
        p.setPreco(p.getPreco() * 1.1);
    }

    public void atualizacaoNaoEstatica() {
        preco = preco * 1.1;
    }

    @Override
    public String toString() {
        return "Produto = " + produto + " - " + "preço = " + String.format("%.2f", preco);
    }
}
