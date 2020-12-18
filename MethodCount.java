
package VSM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MethodCount{
   
    public  void methodcount() throws FileNotFoundException {
            int count = 0;
        System.out.println("Enter the filename");
        Scanner scan =new Scanner(System.in);
        String name=scan.next();
        try{
        File file = new File("H://java//"+name);  //you can change your file location 

        Scanner in = new Scanner(file);
        String classContents = in.useDelimiter("\\Z").next().trim();
        Pattern method= Pattern.compile("[a-zA-Z]*\\s*[a-zA-Z]+\\s+([_a-zA-Z]+)\\s*?\\(.*?\\)\\s*?\\{");
        Matcher methodmatch=method.matcher(classContents);
        while(methodmatch.find()){
            System.out.println("methodname="+methodmatch.group(1));
           
        
            count++;
        }
        System.out.println("total number of methods "+count);
        
    }catch(Exception e){
    e.printStackTrace();
    }
    }
    
}
