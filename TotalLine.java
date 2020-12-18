package VSM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class TotalLine {

    int number = 0;
    int space = 0;

    public void count() {

        try {
            String str;
            BufferedReader f = new BufferedReader(new FileReader("H:/java/a.java"));
            // Scanner scanner=new Scanner(f);
            LineNumberReader l = new LineNumberReader(f);

            int count = 0;

            while ((str = l.readLine()) != null) {

                number++;

                if (str.isEmpty()) {
                    number--;
                }
            }

            System.out.println("Total number of line " + number);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
