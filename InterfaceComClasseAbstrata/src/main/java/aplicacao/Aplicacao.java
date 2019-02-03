package aplicacao;

import enuns.Cor;
import model.AbstractForma;
import model.Circulo;
import model.Forma;
import model.Retangulo;

public class Aplicacao {
    // esclarecimentos no README.md  no diretório RESOURCES
    public static void main(String[] args) {

        AbstractForma af1 = new Circulo(Cor.PRETO, 2.0);
        AbstractForma af2 = new Retangulo(Cor.BRANCO, 5.0, 3.2);

        Forma f1 = new Circulo(Cor.PRETO,2.0);
        Forma f2 = new Retangulo(Cor.PRETO,5.0,3.2);

        System.out.println("Formas com cores");
        System.out.println("Cor do circulo: " + af1.getCor());
        System.out.println("Área do círculo: " + String.format("%.3f", af1.area()));
        System.out.println("Cor do retânculo: " + af2.getCor());
        System.out.println("Área do retângulo: " + String.format("%.3f", af2.area()));

        System.out.println("\n Formas sem cores pois Forma não possui implementação de cor");
        System.out.println("Área do círculo: " + String.format("%.3f", f1.area()));
        System.out.println("Área do retângulo: " + String.format("%.3f", f2.area()));


    }
}
