import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        List<Integer> meusInts = Arrays.asList(1, 2, 3, 4);
        List<Double> meusDoubs = Arrays.asList(3.01, 2.2, 3.5);
        List<Object> meusObjs = new ArrayList<>();

        copiar(meusInts, meusObjs);
        imprimirLista(meusObjs);
        copiar(meusDoubs, meusObjs);
        imprimirLista(meusObjs);
    }

    //origem recebe qualquer objeto que extende number ou seja Double, Integer, BigDecimal, etc
    //destino recebe qualquer objeto acima de number que nesse caso é a classe object
    private static void copiar(List<? extends Number> origem, List<? super Number> destino) {
        for (Number n : origem) {
            destino.add(n);
        }
    }

    private static void imprimirLista(List<Object> lista) {
        for (Object o : lista) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
