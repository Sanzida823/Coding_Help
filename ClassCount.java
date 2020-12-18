package VSM;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassCount{

    public  void classcount() throws FileNotFoundException {
        int count = 0;
        System.out.println("Enter the filename");
        Scanner scan =new Scanner(System.in);
        String name=scan.next();
        try{
        File file = new File("H://java//"+name);  //you can change your location 

        Scanner in = new Scanner(file);
        String classContents = in.useDelimiter("\\Z").next().trim();
        Pattern classfind = Pattern.compile("([a-zA-Z]*)\\s*class\\s*([_a-zA-Z]+)\\s*\\{");
        Matcher classmatcher = classfind.matcher(classContents);
        //   Pattern classpattern=Pattern.compile("(.*)}$",Pattern.DOTALL);
        //   Matcher classmatcher=classpattern.matcher(classContents);

        while (classmatcher.find()) {
            count++;
            System.out.println("classname =" + classmatcher.group(2));
        }
        System.out.println("Total numberof class=" + count);
    }catch(Exception e){
    e.printStackTrace();
}
    }

}
