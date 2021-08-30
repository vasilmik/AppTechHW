package org.company;

import java.io.*;
import java.util.*;

public class FilterBigFile {

    static private String pathToFile;
    static private Map<Integer, Integer> mapLineStorage = new HashMap<Integer, Integer>();
    static private BitSet bitSetStorage;

    static public String filterFile(String pathToFile) {

        readFile(pathToFile);
        return writeResultFiles();

    }

    static private void readFile(String path) {

        pathToFile = path;

        File file = new File(pathToFile);

        try (Scanner scanner = new Scanner(file)) {
           bitSetStorage = filterText(scanner);
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }
    }

    static protected BitSet filterText(Scanner scanner){

        int counter = 0;
        BitSet bitSet = new BitSet();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Integer hashLine = line.hashCode();
            if (mapLineStorage.containsKey(hashLine)) {
                bitSet.set(mapLineStorage.get(hashLine), false);
                bitSet.set(counter, false);
            } else {
                mapLineStorage.put(hashLine, counter);
                bitSet.set(counter);
            }
            counter++;
        }

        return bitSet;
    }

    static private String writeResultFiles(){

        int counter = 0;
        File fileIn  = new File(pathToFile);
        File fileOut = new File(System.getProperty("user.dir") + "\\"+"result.txt");

        try (Scanner scanner = new Scanner(fileIn);
             PrintWriter writer = new PrintWriter(fileOut);
             ) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if(bitSetStorage.get(counter)){
                    writer.println(line);
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }

        return fileOut.getAbsolutePath();

    }
}
