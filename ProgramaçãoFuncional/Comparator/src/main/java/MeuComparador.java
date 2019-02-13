import java.util.Comparator;

public class MeuComparador implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getProduto().toUpperCase().compareTo(p2.getProduto().toUpperCase());
    }
}
