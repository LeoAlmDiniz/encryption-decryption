package encryptdecrypt;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    private static final String BASEPATH = "C:\\Users\\leonardo.diniz\\OneDrive - Accenture\\Desktop\\Portfolio\\Java\\springDemo\\Encryption-Decryption\\Encryption-Decryption\\task\\src\\";

    @Parameter(names = {"-m", "-mode"})
    static String mode;
    @Parameter(names = {"-k", "-key"})
    static int key;
    @Parameter(names = {"-d", "-data"})
    static String data;
    @Parameter(names = {"-in"})
    static String in;
    @Parameter(names = {"-out"})
    static String out;
    @Parameter(names = {"-a", "-alg"})
    static String alg;


    public static void main(String[] args) {

        String dataToSend;

        Main main = new Main();
        JCommander.newBuilder().addObject(main).build().parse(args);

        if (mode == null) {
            mode = "enc";
        }
        if (data == null && in == null) {
            dataToSend = "";
        } else if (data == null) {
            try {
//                String path = BASEPATH+in;
                String path = in;
                Scanner scanner = new Scanner(new File(path));
                StringBuilder sb = new StringBuilder("");
                while (scanner.hasNext()) {
                    sb.append(scanner.nextLine());
                }
                scanner.close();
                dataToSend = sb.toString();
                System.out.println(dataToSend);
            } catch (Exception e) {
                System.out.println("Error: a problem occurred whilst trying to receive input from file");
                return;
            }
        } else if (in == null) {
            dataToSend = data;
        } else {
            System.out.println("Error: the two types of input information (data and in) were given and the program was shutdown due to conflict. Run the program with only one type of input information.");
            return;
        }
        if (alg == null) {
            mode = "shift";
        } else if ( !"UNICODE".equals(alg.toUpperCase()) && !"SHIFT".equals(alg.toUpperCase()) ) {
            System.out.println("Error: the specified type of alg does not exist. Choose either shift or unicode");
            return;
        }

        String outputData = "";

        if ("ENC".equals(mode.toUpperCase())) {
            if ("UNICODE".equalsIgnoreCase(alg)) {
                outputData = CryptoUtils.encryptUnicode(dataToSend, key);
            } else if ("SHIFT".equalsIgnoreCase(alg)) {
                outputData = CryptoUtils.encryptShift(dataToSend, key);
            }
        } else if ("DEC".equals(mode.toUpperCase())) {
            if ("UNICODE".equalsIgnoreCase(alg)) {
                outputData = CryptoUtils.decryptUnicode(dataToSend, key);
            } else if ("SHIFT".equalsIgnoreCase(alg)) {
                outputData = CryptoUtils.decryptShift(dataToSend, key);
            }
        } else {
            System.out.println("Error: operation not recognized. Please type as first entry 'enc' (for encryption) or 'dec' (for decryption).");
        }

        if (out == null) {
            System.out.print(outputData);
        } else {
            try {
//                String path = BASEPATH+out;
                String path = out;
                FileWriter myWriter = new FileWriter(path);
                System.out.println(outputData);
                myWriter.write(outputData);
                myWriter.close();
            } catch (Exception e) {
                System.out.println("Error: a problem occurred whilst trying to store output in file");
            }
        }

    }

}
