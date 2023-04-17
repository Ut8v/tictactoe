import java.util.Scanner;
public class safeInput {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retRangedInt = 0;
        boolean returnInt = false;
        do {
            System.out.print("\n" + prompt + ":");
            if (pipe.hasNextInt()) {
                retRangedInt = pipe.nextInt();
                if (retRangedInt >= low && retRangedInt <= high) {
                    returnInt = true;
                } else {
                    System.out.println("Invalid Input");
                }
            } else {
                System.out.println("Invalid input.");
                pipe.nextLine();
            }
        } while (!returnInt);
        return retRangedInt;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        while (true)  //enters the loop
        {
            System.out.print(prompt + "Y/N");
            String retYNConfirm = pipe.nextLine();
            if (retYNConfirm.equalsIgnoreCase("y") || retYNConfirm.equalsIgnoreCase("yes")) {
                return true;
            } else if (retYNConfirm.equalsIgnoreCase("n") || retYNConfirm.equalsIgnoreCase("no")) {
                return false;
            }
        }
    }
}
