
package missingpersonproject;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scanner = new Scanner(System.in);

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static int getInt(String message) {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
    }
}