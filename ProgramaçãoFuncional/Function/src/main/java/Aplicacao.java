import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Aplicacao {

    public static void main(String[] args) {

        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Mouse", 50.00));
        lista.add(new Produto("Tablet", 350.00));
        lista.add(new Produto("Case HD", 80.90));

        /*
         * 1 - Expressão lambda declarada
         * 2 - Criando um método estático e passando-o como referência
         * 3 - Criando método comum e passando como referência
         * 4 - Expressão lambda inline
         * */

        //1 - classe implementada manualmente
        Function<Produto, String> f = new Function<Produto, String>() {
            @Override
            public String apply(Produto p) {
                return p.getProduto().toUpperCase();
            }
        };

        List<String> resultado = lista.stream().map(f).collect(Collectors.toList());

        // 2 - passando método estático
        resultado = lista.stream().map(Produto::upper).collect(Collectors.toList());

        // 3 - passando método não estático
        resultado = lista.stream().map(Produto::upperNaoEstatico).collect(Collectors.toList());

        // 4 - expressão lambda inline
        resultado = lista.stream().map(p -> p.getProduto().toUpperCase()).collect(Collectors.toList());

        // precisa implementar o toString na classe senão ele mostra o endereço de memória
        resultado.forEach(System.out::println);
    }
}
