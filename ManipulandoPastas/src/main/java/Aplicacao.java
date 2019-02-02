import java.io.File;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Caminho do arquivo");
            String caminho = sc.nextLine();

            File pasta = new File(caminho);
            // expressao para filtrar apenas diretorios
            File[] pastas = pasta.listFiles(File::isDirectory);

            System.out.println("Pastas");
            for (File f : pastas) {
                System.out.println(f);
            }

            // expressao para filtrar apenas arquivos
            File[] arquivos = pasta.listFiles(File::isFile);

            System.out.println("\n Arquivos");
            for (File f : arquivos) {
                System.out.println(f);
            }

            boolean criado = new File(caminho + "/subDiretorio").mkdir();

            File[] subDir = pasta.listFiles(File::isDirectory);
            if (criado) {
                System.out.println("\n Pastas com Sub Diretorio");
                for (File f : subDir) {
                    System.out.println(f);
                }
                System.out.println("\n Apagando Sub Diretorio ...");

                new File(caminho + "/subDiretorio").delete();
            }

            sc.close();

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
