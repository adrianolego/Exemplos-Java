import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Notbook", 1500.00));
        lista.add(new Produto("Tablet", 450.00));

        // abaixo uma forma de implementação usando uma classe
        lista.sort(new MeuComparador());

        // abaixo uma outra forma de implementação usando classe anônima
        Comparator<Produto> c1 = new Comparator<Produto>() {
            @Override
            public int compare(Produto p1, Produto p2) {
                return p1.getProduto().toUpperCase().compareTo(p2.getProduto().toUpperCase());
            }
        };

        lista.sort(c1);

        // abaixo usando expressão lambda podendo apagar {} e return e deixar em uma linha apenas
        // ou pegar toda implementação depois do = ( e colocar como parâmetro dentro do sot da lista
        Comparator<Produto> c2 = (p1, p2) -> {
            return p1.getProduto().toUpperCase().compareTo(p2.getProduto().toUpperCase());
        };

        lista.sort(c2);

        for (Produto p : lista) {
            System.out.println(p.getProduto() + p.getPreco());
        }
    }
}
