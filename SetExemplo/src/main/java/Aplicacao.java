import java.util.*;

public class Aplicacao {

    public static void main(String[] args) {
        // mais rapido de todos e não mantém a ordem dos elementos
        Set<String> set1 = new HashSet<>();
        // mais lento e e mantém a ordem de inserção
        Set<String> set2 = new TreeSet<>();
        // velocidade intermediário  mantém a ordem de inserção
        Set<String> set3 = new LinkedHashSet<>();

        System.out.println("\nExemplo de uso do SET");
        exemplo(set1);

        System.out.println("\nExemplo de uso do TREESET");
        exemplo(set2);

        System.out.println("\nExemplo de uso do LINKEDHASHSET");
        exemplo(set3);

        // remove o elemento passado como parâmetro
        set1.remove("");

        // remove baseado em um predicado (filtro) abaixo remove todos que tiverem 3 ou mais caracteres
        System.out.println("\nRemoveIf");
        set1.removeIf(x -> x.length() >= 3);
        System.out.println(set1);

        // remove todos que contenham a letra T
        set1.removeIf(x -> x.charAt(0) == 'T');

        exemploContinuacao();

        /*SET as comparações são feitas pela implementação do toString e hashCode sendo que se não forem implementados em
        uma classe a qual se esta usando a comparação o compilador vai usar o ponteiro como comparação, porém nessa
        comparação será utilizado o endereço de memória portanto se os objetos não forem estanciados no mesmo endereço
        a comparação vai retornar false (contains)*/

        /*TREESET as comparações são feitas usando a interface da classe Comparable portanto as classe que serão
        comparadas devem implementar essa classe Comparable<Classe> e implementar o método compareTo*/
    }

    private static void exemplo(Set<String> set) {
        set.add("TV");
        set.add("NotBook");
        set.add("Tablet");

        System.out.println(set.contains("NotBook \n"));

        for (String s : set) {
            System.out.println(s);
        }
    }


    private static void exemploContinuacao() {
        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        //união
        Set<Integer> uniao = new TreeSet<>(a);
        uniao.addAll(b);
        System.out.println(uniao);

        //intersecção (somente elementos em comum)
        Set<Integer> interseccao = new TreeSet<>(a);
        interseccao.retainAll(b);
        System.out.println(interseccao);

        //diferença
        Set<Integer> diferenca = new TreeSet<>(a);
        diferenca.removeAll(b);
        System.out.println(diferenca);
    }
}
