package VSM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Tfidf {

    Map<String, Map<String, Integer>> output = new HashMap<>();
    Map<String, Integer> tfmap = new HashMap<>();
    Map<String, Vector<Double>> vectorHashMap = new HashMap<String, Vector<Double>>();
    List<String> filename = new ArrayList<>();
    List<String> method = new ArrayList<>();
    List<String> m = new ArrayList<>();
    int totalword;
    String content;
    double tf = 0;
    double term = 0;


    /* public double[] main(String query) throws FileNotFoundException {

        //   Map<String, Map<String, Integer>> wordToDocumentMap = new HashMap<String, Map<String, Integer>>();
        List<String> method = new ArrayList<>();
        //   List<String> filename = new ArrayList<>();
        File f = new File("H://java//a.java");
        Scanner in = new Scanner(f);
        String fileMethodName = null;
        String classContents = in.useDelimiter("\\Z").next().trim();

        JavaMethodParser jmp = new JavaMethodParser(classContents);
        String p = f.getName();

        while (jmp.hasMoreMethods()) {
            fileMethodName = jmp.getMethodName() + " " + p;
            filename.add(fileMethodName);
            method.add(jmp.getMethod());

        }
        double tff[] = new double[(method.size())];
        //  String term[] = new String[method.size()];
        for (int i = 0; i < method.size(); i++) {

            content = method.get(i);
            m.add(content);
            //   System.out.println("" + filename.get(i));
            // output.put(filename.get(i), createFreqMap(content, query));
            k = tf;
            tff[i] = k;
            //  System.out.println("k is " + tff[i]);
        }
        // System.out.println("k is"+tf);
        //     System.out.println(""+tff);
        return tff;
    }*/
    public double TF(String[] filemethod, String term) {
        double value = 0;
        for (String s : filemethod) {

            if (s.equalsIgnoreCase(term)) {

                tfmap.put(s, tfmap.getOrDefault(term, 0) + 1);
                for (Map.Entry entry : tfmap.entrySet()) {
                    value = (int) entry.getValue();

                }
            }

        }//System.out.println("  "+value / filemethod.length);
// System.out.println(term+" hh "+value);
        return value / filemethod.length;

    }

    public double idf(List m, String term) {
        double b = m.size();
        double count = 0;

        for (int i = 0; i < m.size(); i++) {
            String[] f = m.get(i).toString().replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");

            for (String ss : f) {

                if (ss.equalsIgnoreCase(term)) {
                    count++;

                    break;
                }
            }

        }
        // System.out.println("term "+term+ ""+count);    
        //     System.out.println(term+"  " +( 1+Math.log(b/count)));
        return 1 + Math.log(b / count);
    }
}
