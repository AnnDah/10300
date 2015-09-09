import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by annikamagnusson on 08/09/15.
 *
 */
class Main {
    static Scanner in;
    static PrintWriter printer;
    float budget;
    static String data;

    public static void main (String args[]) {
        data = "3\n" +
                "5\n" +
                "1 1 1\n" +
                "2 2 2\n" +
                "3 3 3\n" +
                "2 3 4\n" +
                "8 9 2\n" +
                "3\n" +
                "9 1 8\n" +
                "6 12 1\n" +
                "8 1 1\n" +
                "3\n" +
                "10 30 40\n" +
                "9 8 5\n" +
                "100 1000 70";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        in = new Scanner(System.in);
        PrintWriter printer = new PrintWriter(System.out, true);

        Main main = new Main();
        main.calcPremium();
    }

    void calcPremium() {
        int firstLine = 0;
        int cases = 0;
        float premium;
        String strBudget = "";

        while (in.hasNext()) {
            if (firstLine == 0) {
                cases = Integer.parseInt(in.nextLine());
                firstLine++;
            }

            for (int i = 0; i < cases; i++) {
                int farmers = in.nextInt();

                System.out.println("----------------");
                System.out.println("farmers: " + farmers);

                for(int y = 0; y < farmers; y++) {
                    float size = in.nextFloat();
                    float animals = in.nextFloat();
                    float ecoFriendly = in.nextFloat();
                    System.out.println("s= " + size + " a= " + animals + " e= " + ecoFriendly);

                    premium = Math.round(size/animals*ecoFriendly*animals);
                    System.out.println("premium: " + premium);

                    budget += premium;
                    System.out.println("budget: " + budget);

                }

                strBudget += ((Integer.toString((int)budget)) + "\n");
                budget = 0;
            }
        }
        System.out.println(strBudget);
        //printer.print(strBudget);

    }


}
