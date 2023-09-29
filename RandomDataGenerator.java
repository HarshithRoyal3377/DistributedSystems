import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.lang.management.ManagementFactory;

public class RandomDataGenerator {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(
                    "Please give approproate arguments \n java RandomDataGenerator <number_of_input_entries> <output_file_path>");
            return;
        }

        int inputEntriesNumb = Integer.parseInt(args[0]);
        String outputFilePath = args[1];
        long startWallTime = System.currentTimeMillis();
        try {
            FileWriter fw = new FileWriter(outputFilePath);

            BufferedWriter writer = new BufferedWriter(fw);
            for (int i = 0; i < inputEntriesNumb; i++) {
                String randomInteger = generateRandomInteger();
                String sequenceNumber = String.format("%010d", i);
                String randomString = generateRandomString();

                String entry = randomInteger + "_" + sequenceNumber + "_" + randomString;
                writer.write(entry);

            }

            writer.close();
            long cpuTime = ManagementFactory.getThreadMXBean().getThreadCpuTime(Thread.currentThread().getId());
            long cpuTimeMillis = cpuTime / 1000000;
            System.out.println("CPU time: " + cpuTimeMillis + " ms");

            System.out.println("Dataset Generated at " + outputFilePath);

            long endWallTime = System.currentTimeMillis();
            long elapsedWallTime = endWallTime - startWallTime;
            System.out.println("Wall time: " + elapsedWallTime + " milliseconds");
            double datasetSizeMiB = calculateDatasetSize(inputEntriesNumb);
            calculateDiskSpeed(datasetSizeMiB, elapsedWallTime);
            calculateDiskThroughput(datasetSizeMiB, cpuTimeMillis);
//            influenceOfDatasetSizeAndEntries();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    
    private static double calculateDatasetSize(int inputEntriesNumb) {
        int entrySize = 45 + 10 + 9; 
        double datasetSizeMB = (double) inputEntriesNumb * entrySize / (1024 * 1024); 
        double datasetSizeMiB = (double) inputEntriesNumb * entrySize / (1000 * 1024); 
        System.out.println("Dataset Size :" + datasetSizeMB + " (MB)");
        System.out.println("Dataset Size : " + datasetSizeMiB + " (MiB)");
        return datasetSizeMiB;
    }

   
    private static void calculateDiskThroughput(double datasetSizeMiB, long seconds) {
        double throughput = (datasetSizeMiB) / seconds; // in MiB/second
        System.out.println("Throughput: " + throughput * 1000 + " MiB/s");
    }
    
    private static void calculateDiskSpeed(double datasetSizeMiB, long seconds) {
        double diskSpeed = (datasetSizeMiB) / seconds; // in MiB/second
        System.out.println("Disk Speed: " + diskSpeed * 1000 + " MiB/s");
    }

    
    
    private static String generateRandomInteger() {
        Random random = new Random();
        return Integer.toString(random.nextInt(1000000000));
    }

    private static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder(45);

        Random random = new Random();
        for (int i = 0; i < 45; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            stringBuilder.append(randomChar);
        }

        stringBuilder.append('\n');
        return stringBuilder.toString();
    }
}
