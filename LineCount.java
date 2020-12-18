
package VSM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineCount extends TotalLine {

    public void commentcount() throws IOException {
        try {
            String str;

            BufferedReader f = new BufferedReader(new FileReader("H:/java/a.java"));
            // Scanner scanner=new Scanner(f);
            LineNumberReader l = new LineNumberReader(f);
            int count = 0;
            int numberline = 0;
            while ((str = l.readLine()) != null) {

                numberline++;
                if (str.startsWith("/*")) {

                    //
                    while ((str = l.readLine()) != null) {
                        count++;
                        if (str.endsWith("*/")) {
                            count++;

                            break;
                        }

                    }

                } else if (str.startsWith("//")) {

                    count++;
                }
            }
            // System.out.println(""+number);
            System.out.println("Total comment line " + count);
            int c = number - count;
            System.out.println("total line without comment line " + c);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void Total() throws IOException {
        LineCount ob = new LineCount();
        ob.count();
        ob.commentcount();

    }

}

