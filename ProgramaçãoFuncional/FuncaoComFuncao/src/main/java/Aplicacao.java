import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Aplicacao {

    public static void main(String[] args) {
        //criando uma Stream a partir de uma lista
        List<Integer> lista = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st1 = lista.stream().map(x -> x * 10);

        System.out.println(Arrays.toString(st1.toArray()));
        //criando uma Stream direto
        Stream<String> st2 = Stream.of("Maria", "Joao", "Alex");
        System.out.println(Arrays.toString(st2.toArray()));

        //Stream infinita, limitando a impressão utilizando limit
        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(20).toArray()));

        //Stream para mostrar sequencia de fibonacci
        /*
         * trecho new Long[]{0l, 1l} é para conseguir usar dois numeros porque no parametro do iterate só poderia ser um único parametro
         * trecho p -> new Long[]{p[1], p[0] + p[1] serve para atribuir a posição 1 o valor do primeiro mais o segundo (0+ 1 = 1 na posição 1)
         * trecho .map(p -> p[0]) recebe o resultado da soma armazenado em p[1]
         * Squencia fica 0+1 = 1, 1+1 = 2, 1+2 =3 , 2+3 =5, 3+5=8 somando sempre os dois ultimos resultados
         * */
        Stream<Long> st4 = Stream.iterate(new Long[]{0l, 1l}, p -> new Long[]{p[1], p[0] + p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));
    }
}
