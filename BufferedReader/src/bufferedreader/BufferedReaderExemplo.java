package bufferedreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author adriano
 */
public class BufferedReaderExemplo {

    public static void main(String[] args) throws Exception {
        String caminho = "/home/adriano/gitAdriano/BufferedReader/arquivo.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(caminho);
            br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new Exception(e);
        } finally {
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
        }
    }

}
