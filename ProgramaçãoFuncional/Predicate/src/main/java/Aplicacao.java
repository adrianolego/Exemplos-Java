import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Aplicacao {

    public static void main(String[] args) {

        List<Produto> lista = new ArrayList<>();

        double valMinimo = 100.00;

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Mouse", 50.00));
        lista.add(new Produto("Tablet", 350.00));
        lista.add(new Produto("Case HD", 80.90));

        //existem algumas formas de fazer essa remoção usando expressões lambda com classes anônimas ou métodos abastratos

        /*
         * 1 - Criando uma classe que implementa Predicate<SuaClasse> e passando uma nova instância dessa classe
         * 2 - Expressão lambda declarada
         * 3 - Criando um método estático e passando-o como referência
         * 4 - Criando método comum e passando como referência
         * 5 - Expressão lambda inline
         * */

        // 2 - implementação manual com classe anônima
        Predicate<Produto> p1 = new Predicate<Produto>() {
            @Override
            public boolean test(Produto p) {
                return p.getPreco() > valMinimo;
            }
        };
        lista.removeIf(p1);

        // 3 - utilizando método estático como referência
        lista.removeIf(Produto::predicadoPorReferecia);

        // 4 - utilizando método comum como referência
        lista.removeIf(Produto::predicadoPorRefereciaNaoEstatico);

        // 5 - utilizando expressão inline
        lista.removeIf(p -> p.getPreco() > valMinimo);

        for (Produto p : lista) {
            System.out.println("\n" + p.getProduto() + " " + p.getPreco());
        }
    }
}
