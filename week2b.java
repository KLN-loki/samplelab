import java.io.*;
import java.util.Scanner;
class week2b
{
    public static void main(String arg[]) throws IOException
    {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the file name: ");
            String fname = s.next();
            File f = new File(fname);
            System.out.println(f.exists() ? "File Found" :  "File Not Found");
            System.out.println("Name: " + f.getName());
            FileInputStream in = new FileInputStream(f);
            FileOutputStream out = new FileOutputStream("output.txt");
            int i, icnt = 0, ncnt = 0, scnt = 0;
            while ((i = in.read()) != -1)
            {
                char c = (char) i;
                if ((c >= 'A'
                        && c <= 'Z') || (c >= 'a' && c <= 'z'))
                    icnt += 1;
                else if (c >= '0' && c <= '9')
                    ncnt += 1;
                else if (c != ' '
                        && c != '.' && c != '\n')
                    scnt += 1;
                out.write(c);
            }
            String str = new String("\nAlphabets = " + icnt + "\nNumbers = " + ncnt + "\nSpecial = " + scnt);
            System.out.println(str);
            byte b[] = str.getBytes();
            out.write(b);
            in.close();
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception: " + e);
        }
    }
}
