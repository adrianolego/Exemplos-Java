import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicacao {

    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st1 = lista.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // reduce recebe um parametro inicial(neutro) e uma função com dois elementos e gera o resultado
        int soma = lista.stream().reduce(0, (x, y) -> x + y);// somatório
        // multiplicatório reduce(1, (x, y) -> x * y)
        System.out.println(soma);

        // retorna uma lista dos elementos que atendam o predicado em filter
        // na stream resultante foi usado um map pegando cada resultado e multiplicando por 10
        // no final tudo é transformado em lista
        List<Integer> novaLista = lista.stream()
                .filter(x -> x % 2 == 0)// elementos pares (mod)
                .map(x -> x * 10)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(novaLista.toArray()));
    }
}
