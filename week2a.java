import java.util.Scanner;
import java.io.*;

class week2a {

    public static void main(String arg[]) throws FileNotFoundException, IOException

    {

        Scanner s = new Scanner(new File("market.csv"));
        int total_revenue = 0, i = 0;

        String[][] products = new String[10][4];
        while (s.hasNext()) {
            products[i] = s.next().split(",");

            total_revenue += Integer.parseInt(products[i][2]) * Integer.parseInt(products[i][3]);
            i += 1;

        }

        System.out.println("Total revenue of the Super Market is: " + total_revenue);
        for (int x = 0; x < i; x++) {

            for (int y = x + 1; y < i; y++) {
                if (Integer.parseInt(products[y][3]) > Integer.parseInt(products[x][3])) {
                    String temp[] = products[y];

                    products[y] = products[x];
                    products[x] = temp;

                }

            }

        }

        FileOutputStream out = new FileOutputStream("output.csv");
        for (int x = 0; x < i; x++) {

            for (int y = 0; y < 4; y++) {
                out.write((products[x][y] + ",").getBytes());
            }
            out.write("\n".getBytes());
        }

    }

}

