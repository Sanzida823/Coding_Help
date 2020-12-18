package VSM;
import static VSM.HuffcodeSol.root;



public class Decode {
     public static String decode(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        HuffmanNode temp = root;
 
         //System.out.println("Encoded: " + s);
        for (int i = 0; i < s.length(); i++) {
            int j = Integer.parseInt(String.valueOf(s.charAt(i)));

            if (j == 0) {
                temp = temp.left;
                if (temp.left == null && temp.right == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
            if (j == 1) {
                temp = temp.right;
                if (temp.left == null && temp.right == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
        }
         //String k=stringBuilder.toString();
        return stringBuilder.toString();
    }
}
