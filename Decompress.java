package VSM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.Scanner;

public class Decompress {

    String decodee = "";

    public void decompress() throws IOException {
        System.out.println("pls write the filename");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();

        try {

            decodee = new String(Files.readAllBytes(Paths.get("H://java//" + name))); //first read the java file as a string
        } catch (IOException e) {

            e.printStackTrace();
        }

        String[] newname = name.split("_");

        File file = new File("H://java//" + name);
        File newfilee = new File("H://java//" + newname[1]);
        file.renameTo(newfilee);//use for rename the file
        String binaryString = "";

        FileInputStream fin = null;
        try {
            // create FileInputStream object
            fin = new FileInputStream(file);

            byte fileContent[] = new byte[(int) file.length()];

            fin.read(fileContent);
         //   System.out.println("" + BitSet.valueOf(fileContent));
           // System.out.println("" + BitSet.valueOf(fileContent).length());
            BitSet bit = new BitSet(BitSet.valueOf(fileContent).length());
            for (int i = 0; i <= BitSet.valueOf(fileContent).length(); i++) {
                if (BitSet.valueOf(fileContent).get(i)) {
                    binaryString += "1";
                } else {
                    binaryString += "0";
                }
            }
            //System.out.println("");
            // System.out.println(""+fileContent.length);

        //    System.out.println("" + binaryString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Decode ddecode = new Decode();
        String k = ddecode.decode(binaryString);
        FileWriter fw = new FileWriter(file, false);
       // System.out.println("");
        for (int j = 0; j < k.length(); j++) {
            fw.write(k.charAt(j));
        }

        System.out.println("successful");
        fw.close();
    }

}
