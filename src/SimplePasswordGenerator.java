
import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jack Ullery
 */
public class SimplePasswordGenerator {

    private static String[] getDictionary(String filename) throws FileNotFoundException {
        File fi = new File(filename);
        Scanner scan = new Scanner(fi);

        List<String> li = new LinkedList<>();
        while (scan.hasNextLine()) {
            li.add(scan.nextLine());
        }

        return li.toArray(new String[li.size()]);
    }

    public static String random(String[] dictionary, int min_size, int min_words) {
        StringBuilder sb = new StringBuilder();
        SecureRandom rand = new SecureRandom();

        for (int i = 0; i < min_words; i++) {
            sb.append(dictionary[rand.nextInt(dictionary.length)]);
            sb.append('_');
        }
        while (sb.length() < min_size) {
            sb.append(dictionary[rand.nextInt(dictionary.length)]);
        }

        sb.append(rand.nextInt(1000));
        return sb.toString();
    }

    public static String random(int size) {
        SecureRandom sc = new SecureRandom();
        char[] arr = new char[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (sc.nextInt('z' - '0') + '0');
            if (!Character.isLetterOrDigit(arr[i])) {
                i--;
            }
        }

        return new String(arr);
    }

    private static void printHelp() {
        System.out.println("Expected argument of type [int] [int]?.");
        System.out.println("java SimplePasswordGenerator minPasswordLength");
        System.out.println("\t or");
        System.out.println("java SimplePasswordGenerator minPasswordLength minNumWords");
    }

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 1 && args.length != 2) {
            printHelp();
            return;
        }

        try {
            int len;
            int num_words;
            if (args.length == 1) {
                len = Integer.parseInt(args[0]);
                num_words = 0;
            } else {
                len = Integer.parseInt(args[0]);
                num_words = Integer.parseInt(args[1]);
            }
            String[] dict = getDictionary("dictionary.txt");
            System.out.println(random(dict, len, num_words));
        } catch (NumberFormatException ex) {
            System.out.println("Error: argument was not an integer.");
            printHelp();
        }
    }
}
