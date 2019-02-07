package main;

import model.Produto;
import service.CalculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        List<Produto> lista = new ArrayList<>();

        String caminho = "../Generics/src/main/resources/arquivo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();

            while (linha != null) {
                String[] produtos = linha.split(",");
                lista.add(new Produto(produtos[0], Double.parseDouble(produtos[1])));
                linha = br.readLine();
            }

            Produto p = CalculoService.maximo(lista);
            System.out.println("\n Mais caro = " + p.getProduto() + " - R$" + p.getPreco());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
