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
// metodo estatico recebe um parametro para trabalhar
    public static boolean predicadoPorReferecia(Produto p) {
        return p.getPreco() > 100.00;
    }
//metodo não estatico trabalha com o objeto corrente onde estiver sendo utilizado
    public boolean predicadoPorRefereciaNaoEstatico() {
        return preco > 100.00;
    }
}
