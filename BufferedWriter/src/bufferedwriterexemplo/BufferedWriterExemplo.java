package bufferedwriterexemplo;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author adriano
 */
public class BufferedWriterExemplo {

    public static void main(String[] args) throws Exception {
        String[] lines = new String[]{"Bom Dia", " Boa Tarde", "Boa Noite"};

        String caminho = "/home/adriano/gitAdriano/BufferedWriterExemplo/arquivo.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
