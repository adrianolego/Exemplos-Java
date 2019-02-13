package service;

import java.util.List;

public class CalculoService {
    // como somente o método utiliza um tipo genérico e não a classe toda precisa indicar com <T>
    // para utilizar o compareTo é preciso dizer que ele é do tipo Comparable utilizando o <T extends Comparable>
    public static <T extends Comparable> T maximo(List<T> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista esta vazia !");
        }

        T maximo = lista.get(0);
        for (T item : lista) {
            if (item.compareTo(maximo) > 0) {
                maximo = item;
            }
        }

        return maximo;
    }
}
