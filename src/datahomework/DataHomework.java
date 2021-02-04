package datahomework;

import java.io.*;
import java.util.*;

public class DataHomework {

    public static void main(String[] args) {
        try (
                FileInputStream fisA = new FileInputStream("inputA.txt");
                Reader frA = new InputStreamReader(fisA, "UTF-8");
                BufferedReader brA = new BufferedReader(frA);
                FileInputStream fisB = new FileInputStream("inputB.txt");
                Reader frB = new InputStreamReader(fisB, "UTF-8");
                BufferedReader brB = new BufferedReader(frB);
                FileInputStream fisC = new FileInputStream("inputC.txt");
                Reader frC = new InputStreamReader(fisC, "UTF-8");
                BufferedReader brC = new BufferedReader(frC);

                // Writer
                FileOutputStream fos = new FileOutputStream("output.txt", true);
                Writer fw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bfr = new BufferedWriter(fw)

        ) {

            String currentLine;
            String[] splitWords;

            List<String> sentences = new ArrayList();


            // Reads the file , splits the line read to words and adds them to a list.
            while ((currentLine = brA.readLine()) != null) {
                splitWords = currentLine.split(" ");
                sentences.addAll(Arrays.asList(splitWords));
            }

            while ((currentLine = brB.readLine()) != null) {
                splitWords = currentLine.split(" ");
                sentences.addAll(Arrays.asList(splitWords));
//                for (String word : splitWords) {
//                    sentences.add(word);
//                }
            }

            while ((currentLine = brC.readLine()) != null) {
                splitWords = currentLine.split(" ");
                Collections.addAll(sentences, splitWords);
            }

            // Sorts in descending order
            sentences.sort((s1, s2) -> s2.length() - s1.length());

            // Writes to an output file
            for (String word : sentences) {
                bfr.write(word + ",\n");
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }
}