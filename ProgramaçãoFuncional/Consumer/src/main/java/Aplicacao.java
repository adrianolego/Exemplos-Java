import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Aplicacao {

    public static void main(String[] args) {

        List<Produto> lista = new ArrayList<>();

        double val = 1.1;

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Mouse", 50.00));
        lista.add(new Produto("Tablet", 350.00));
        lista.add(new Produto("Case HD", 80.90));

        //existem algumas formas de fazer essa remoção usando expressões lambda com classes anônimas ou métodos abastratos

        /*
         * 1 - Criando uma classe que implementa Consumer<SuaClasse> e passando uma nova instância dessa classe
         * 2 - Expressão lambda declarada
         * 3 - Criando um método estático e passando-o como referência
         * 4 - Criando método comum e passando como referência
         * 5 - Expressão lambda inline
         * */

        //2 - classe implementada manualmente
        Consumer<Produto> c1 = new Consumer<Produto>() {
            @Override
            public void accept(Produto p) {
                p.setPreco(p.getPreco() * val);
            }
        };

        lista.forEach(c1);

        // 3 - passando método estático
        lista.forEach(Produto::atualizacao);

        // 4 - passando método não estático
        lista.forEach(Produto::atualizacaoNaoEstatica);

        //5 - expressão lambda inline
        lista.forEach(p -> p.setPreco(p.getPreco() * val));

        // precisa implementar o toString na classe senão ele mostra o endereço de memória
        lista.forEach(System.out::println);
    }
}
