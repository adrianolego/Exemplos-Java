package manipulandoarquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author adriano
 */
public class ManipulandoArquivos {

    public static void main(String[] args) throws Exception {
        File f = new File("/home/adriano/gitAdriano/ManipulandoArquivos/arquivo.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new Exception(e);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
