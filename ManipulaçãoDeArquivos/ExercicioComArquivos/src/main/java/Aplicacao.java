import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    /*
     * Exercicio
     * 1 Criar um arquivo com dados de produtos
     * 2 Ler o arquivo separando os produtos, preço e quantidade
     * 3 Realizar os calculos
     * 4 Escrever o resultado em um arquivo em outra pasta
     * 5 Apagar arquivos e diretorios
     * */

    public static void main(String[] args) throws Exception {

        String caminhoEntrada = "/tmp/exercicio/";
        String caminhoSaida = "/tmp/exercicio/saida/";
        String arquivoEntrada = "produtos.csv";
        String arquivoSaida = "valorTotal.csv";
        List<String> dadosProdutos = new ArrayList<>();

        dadosProdutos.add("TV LED,1290.99,1 \n");
        dadosProdutos.add("Video Game Chair,350.50,3 \n");
        dadosProdutos.add("Iphone X,900.00,2 \n");
        dadosProdutos.add("Samsung Galaxy 9,850.00,2 \n");


        try {
            boolean arquivoCriado = criarArquivoEntrada(caminhoEntrada, arquivoEntrada, dadosProdutos);

            if (arquivoCriado) {

                List<Produto> listProdutos = lerArquivo(caminhoEntrada + arquivoEntrada);

                boolean saida = escreverArquivoSaida(caminhoSaida, arquivoSaida, listProdutos);

                if (saida) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Aperte alguma tecla para apagar os arquivos e diretórios");
                    sc.nextLine();
                }
                deletarArquivo(caminhoSaida + arquivoSaida);
                deletarArquivo(caminhoSaida);
                deletarArquivo(caminhoEntrada + arquivoEntrada);
                deletarArquivo(caminhoEntrada);
            }

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private static boolean criarArquivoEntrada(String caminhoEntrada, String arquivoEntrada,
                                               List<String> dados) throws Exception {
        new File(caminhoEntrada).mkdir();
        try (FileWriter fw = new FileWriter(new File(caminhoEntrada + arquivoEntrada))) {
            for (String s : dados) {
                fw.write(s);
            }
            fw.flush();
            return true;
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    private static List<Produto> lerArquivo(String caminho) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            List<String> dados = new ArrayList<>();
            String linha;

            while ((linha = br.readLine()) != null) {
                dados.add(linha.trim());
            }

            List<Produto> listProdutos = new ArrayList<>();
            Produto produto;
            for (String s : dados) {
                produto = new Produto();
                String[] linhaDados = s.split(",");
                produto.setProduto(linhaDados[0]);
                produto.setValor(Double.valueOf(linhaDados[1]));
                produto.setQuantidade(Integer.valueOf(linhaDados[2]));

                listProdutos.add(produto);
            }

            return listProdutos;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    private static boolean escreverArquivoSaida(String caminhoSaida, String arquivoSaida,
                                                List<Produto> listProdutos) throws Exception {
        new File(caminhoSaida).mkdir();
        try (FileWriter fw = new FileWriter(new File(caminhoSaida + arquivoSaida))) {
            for (Produto p : listProdutos) {
                fw.write(p.getProduto() + "-" + somarValores(p.getValor(), p.getQuantidade()) + "\n");
            }
            fw.flush();
            return true;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    private static String somarValores(Double valor, int quantidade) {
        DecimalFormat formato = new DecimalFormat("R$#.##");
        return formato.format(valor * quantidade);
    }

    private static void deletarArquivo(String caminho) throws Exception {
        try {
            new File(caminho).delete();
            System.out.println("\n Apagado " + caminho);
        } catch (Exception e) {
            throw new Exception("Delete no caminho " + caminho + " falhou !");
        }
    }
}
