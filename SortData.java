import java.io.*;
import java.util.*;

public class SortData {   // classname

    public static void main(String[] args) {     //mainmethod
        if (args.length != 3) {                   //checks program for correct argument length if not shows error
            System.out.println("Usage: java SortData <input_file> <temp_directory> <output_file>");
            return;
        }

        String inputFile = args[0];
        String _tempDirectory = args[1];
        String outputFile = args[2];

        try { 
            List<String> data = readData(inputFile);     //    calls read data method  from the input file specified
            Collections.sort(data, new Comparator<String>() {     //sorts the datalist
                public int compare(String entry1, String entry2) {
                    String[] parts1 = entry1.split("_");
                    String[] parts2 = entry2.split("_");
                    return Integer.parseInt(parts1[0]) - Integer.parseInt(parts2[0]);
                }
            });

            writeSortedData(data, outputFile);         //calls the writeSortedData method to write the sortes data back to outputfile
            System.out.println("Data sorted and saved to " + outputFile);  //shows the data has been sorted and saved to output file
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static List<String> readData(String inputFile) throws IOException { // reads data from input file  and stores it ina list of strings
        List<String> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while ((line = reader.readLine()) != null) {
            data.add(line);
        }

        reader.close();
        return data;
    }

    private static void writeSortedData(List<String> data, String outputFile) throws IOException { // writes sorted data to a specified output file
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        for (String entry : data) {
            writer.write(entry);
            writer.newLine();
        }

        writer.close();
    }
}
