package VSM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.Scanner;

public class Compress {

    public void comdcom() {
        System.out.println("Compress");
        System.out.println("Decompress");

    }

    Scanner scan = new Scanner(System.in);

    //   String binaryString ="";
    public void compress() throws IOException {
        try{
        System.out.println("write the file name");
        String name = scan.next();
        String s = "";
        String test = "";
      
        try {

            test = new String(Files.readAllBytes(Paths.get("H://java//" + name))); //first read the java file as a string
        } catch (IOException e) {

            e.printStackTrace();
        }
        File old = new File("H:\\java\\" + name);
        File newfile = new File("H:\\java\\" + "hfm_" + name);
        old.renameTo(newfile);
        //  old.delete();
      //  System.out.println(newfile);
        Encode ob = new Encode();
        s = ob.encode(test);
        BitSet bitset = new BitSet(s.length());

        int bitcounter = 0;
        for (Character c : s.toCharArray()) {
            if (c.equals('1')) {
                bitset.set(bitcounter);
            }
            bitcounter++;
        }

        FileOutputStream t = new FileOutputStream(newfile, false);
      

        t.write(bitset.toByteArray());
        System.out.println("file successfully compressed");

        String binaryString = "";
        for (int i = 0; i <= bitset.length(); i++) {
            if (bitset.get(i)) {
                binaryString += "1";
            } else {
                binaryString += "0";
            }
       } 
    
    
    
   } catch(FileNotFoundException e){
            System.out.println("File not found");
   } } 
      //  System.out.println("" + bitset.length());
      //  System.out.println("    " + binaryString);

    }


