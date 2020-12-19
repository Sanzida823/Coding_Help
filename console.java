package VSM;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

public class console {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        while (true) {
            System.out.println("------------------------");
            System.out.println("ENTER YOUR CHOICE");
            Scanner scan = new Scanner(System.in);
            String choice = scan.next();

            if (choice.equalsIgnoreCase("help")) {
                System.out.println("1.clone");
                System.out.println("2.File_Compression");
                System.out.println("3.Matrics");
                System.out.println("4.Search");
                System.out.println("5.exit");

            } else if (choice.equalsIgnoreCase("Clone") || choice.equals("1")) {
                new Clone().CodeClone();
            } else if (choice.equalsIgnoreCase("File_Compression") || choice.equals("2")) {

                new Compress().comdcom();

            } else if (choice.equalsIgnoreCase("compress") || choice.equals("")) {
                new Compress().compress();
            } else if (choice.equalsIgnoreCase("decompress") || choice.equals("")) {
                new Decompress().decompress();
            } else if (choice.equalsIgnoreCase("matrics") || choice.equals("3")) {
                new Matrics().matrics();
            } else if (choice.equalsIgnoreCase("search") || choice.equals("4")) {
                new Test().search();
            } else if (choice.equalsIgnoreCase("class_count") || choice.equals("")) {
                new ClassCount().classcount();

            } else if (choice.equalsIgnoreCase("Method_Count") || choice.equals("")) {
                new MethodCount().methodcount();

            } else if (choice.equalsIgnoreCase("Total_Line") || choice.equals("")) {
                new LineCount().Total();

            } else if (choice.equalsIgnoreCase("exit") || choice.equals("5")) {
                exit(0);
            } else {
                System.out.println("Wrong Input");
            

        }

    }
}}
