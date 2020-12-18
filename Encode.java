
package VSM;
import static VSM.HuffcodeSol.buildTree;
import static VSM.HuffcodeSol.charPrefixHashMap;
import static VSM.HuffcodeSol.root;
import static VSM.HuffcodeSol.setPrefixCodes;
import java.util.HashMap;
import java.util.Map;


public class Encode {
  
   
     public  String encode(String test) {
          
   
         
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            if (!freq.containsKey(test.charAt(i))) {
                freq.put(test.charAt(i), 0);
            }
            freq.put(test.charAt(i), freq.get(test.charAt(i)) + 1);
        }

      //  System.out.println("Character Frequency Map = " + freq);
        root = buildTree(freq);

        setPrefixCodes(root, new StringBuilder());
                StringBuilder s = new StringBuilder();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            s.append(charPrefixHashMap.get(c));
        }

        return s.toString();
      
    }

}