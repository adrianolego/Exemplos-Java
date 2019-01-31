package trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author adriano
 */
public class TryWithResources {

    public static void main(String[] args) throws Exception {
        String caminho = "/home/adriano/gitAdriano/TryWithResources/arquivo.txt";
        //caso ocorra algum problema o try faz o .close() dos objetos declarados e do tipo throwable
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
