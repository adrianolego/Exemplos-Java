import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Aplicacao {

    // exercício
    /* Fazer um programa para ler um conjunto de produtos a partir de um arquivo .csv
     * Em seguida mostrar o preço médido dos produtos, depois mostrar os nomes em ordem decrescente dos produtos
     * que possuem o valor menor que o preço médio */
    public static void main(String[] args) throws Exception {

        String caminhoArquivo = "/home/adriano/gitAdriano/ProgramaçãoFuncional/ExeciciosUsandoPipeLines/src/main/resources/arquivo.csv";

        List<Produto> produtos = lerArquivo(caminhoArquivo);
        Double precoMedio = calcularPrecoMedio(produtos);
        System.out.println(formatarDouble(precoMedio));
        List<String> ordenacao = ordenarProdutos(produtos, precoMedio);
        ordenacao.forEach(System.out::println);
    }

    private static List<Produto> lerArquivo(String caminho) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine();
            List<Produto> ret = new ArrayList<>();

            while (linha != null) {
                String[] campos = linha.split(";");
                Produto p = new Produto(campos[0], Double.parseDouble(campos[1]));
                ret.add(p);
                linha = br.readLine();
            }

            return ret;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private static Double calcularPrecoMedio(List<Produto> p) {
        return p.stream()
                .map(x -> x.getPreco()) // retorna apenas os preços dos produtos
                .reduce(0.0, (x, y) -> x + y) / p.size(); // faz a soma dos preços dividindo pela quantidade (tamanho da lista)
    }

    private static String formatarDouble(Double v) {
        return String.format("%.2f", v);
    }

    private static List<String> ordenarProdutos(List<Produto> p, Double precoMedio) {
        Comparator<String> c = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        return p.stream()
                .filter(x -> x.getPreco() < precoMedio)// obtem produtos com valor abaixo do preço médio
                .map(x -> x.getProduto()) //  obtem apenas o nome dos produtos
                .sorted(c.reversed()).collect(Collectors.toList()); // compara os nomes e ordena de forma reversa
    }
}
