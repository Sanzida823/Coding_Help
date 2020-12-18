package VSM;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

public class Test {

    Map<String, Map<String, Double>> tfidfDoc = new HashMap<>();

    Map<String, Double> idfmap = new HashMap<>();
    Map<String, Double> cosmap = new HashMap<>();
  
    //   Map<String, Map<String, Integer>> output = new HashMap<>();
    //  Map<String, Integer> map = new HashMap<>();
    //  Map<String, Vector<Double>> vectorHashMap = new HashMap<String, Vector<Double>>();
    List<String> filename = new ArrayList<>();
    List<String> method = new ArrayList<>();
    List<String> m = new ArrayList<>();
    List<String> allterm = new ArrayList<>();
    List<String> queryterm = new ArrayList<>();
    List<double[]> tfidfVector = new ArrayList<>();
    List<double[]> queryVector = new ArrayList<>();
    // Map<String, List<Double>> DoctoVector = new HashMap<>();
    int totalword;
    String content;
    double tf = 0;
    double term = 0;
    double k = 0;

    public void CaptureFileMethod() throws FileNotFoundException {
        File file = new File("H:/java"); //folder name
        File[] files = file.listFiles();
        for (File f : files) {
            //   List<String> method = new ArrayList<>();
            //   List<String> filename = new ArrayList<>();
            // File ff = new File("H://java//a.java");

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
            classContents = null;
            in.close();

        }
        // catch (FileNotFoundException e) {
        for (int i = 0; i < method.size(); i++) {
            //    System.out.println(""+filename.get(i));
            String content = method.get(i);
            //   System.out.println("content="+content);
            String filemethod = filename.get(i);
            //
            //  System.out.println("kk="+filename.get(i)); //filename with method
            m.add(content);
            String[] allterms = content.replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");
            for (String term : allterms) {
                // k++;
                if (!allterm.contains(term)) {
                    allterm.add(term);
                }
            }
        }

        //     } 
    }

    public void getIdf() {
        double tf;
        double idf;
        double tfidf = 0;
        int j = 0;
        for (int i = 0; i < m.size(); i++) {
            //   double[] tfidfvector = new double[allterm.size()];
            int count = 0;
            //   String[] file = m.get(i).replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");
            for (String terms : allterm) {
                String[] file = m.get(i).replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");

                //  tf = new Tfidf().TF(file, terms);
                idf = new Tfidf().idf(m, terms);
                if (Double.isNaN(idf)) {
                    idf = 0;
                }
                //   System.out.println(terms+" k "+idf);
                idfmap.put(terms, idf);

            }

        }

    }

    public void Queryvector(String qu) {
        double Tf;
        double idf = 0;
        double quetfidf;
        String[] que = qu.replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");
        int length = que.length;
        for (String s : que) {
            if (!queryterm.contains(s)) {
                queryterm.add(s);
            }
        }//System.out.println(""+length);
        //  for(int i=0;i<que.length;i++)  {
        double[] queryvector = new double[queryterm.size()];
        int count = 0;
        for (String q : queryterm) {

            Tf = new Tfidf().TF(que, q);
            // System.out.println(q + " " + Tf);
            //  Tf=length/ 
            if (idfmap.containsKey(q)) {
                idf = idfmap.get(q);

            }
            //  System.out.println(q+" idf " + idf);
            quetfidf = Tf * idf;
            // System.out.println("po " + quetfidf);
            queryvector[count] = quetfidf;
            count++;
        }

        queryVector.add(queryvector);
        // System.out.println(""+queryVector);
    }

    public void TfIdf(String qu) {
        double tf = 0;
        double idf = 0;
        double tfidf = 0;
        //   System.out.println(""+qu);
        String[] que = qu.replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");
        for (String s : que) {
            if (!queryterm.contains(s)) {
                queryterm.add(s);
            }
        }
        for (int i = 0; i < m.size(); i++) {
            double[] tfidfvector = new double[queryterm.size()];
            String[] file = m.get(i).replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");
            int count = 0;
            for (String terms : que) {

                tf = new Tfidf().TF(file, terms);
                if (Double.isNaN(tf)) {
                    tf = 0;
                }
                idf = new Tfidf().idf(m, terms);
                if (Double.isNaN(idf)) {
                    idf = 0;
                }
                tfidf = tf * idf;

                if (Double.isNaN(tfidf)) {
                    tfidf = 0;
                }//   System.out.println(terms+" "+tfidf);
                tfidfvector[count] = tfidf;
                count++;
                //    System.out.println("tf="+tf);
// System.out.println("h "+tfidfvector.length);
            }
            //  System.out.println("tfidf "+tfidf);
            for (double d : tfidfvector) {
                //   System.out.println("k"+d);
            }
            tfidfVector.add(tfidfvector);
            // System.out.println("kl "+tfidfVector);

        }
    }

    public void getCosSim() {

        double cos;
        int count = 0;
        double[] sim = new double[filename.size()];
        for (int i = 0; i < queryVector.size(); i++) {
            for (int j = 0; j < tfidfVector.size(); j++) {
                cos = new CosineSimilarity().cosineSimilarity(queryVector.get(i), tfidfVector.get(j));

                sim[count] = cos;
                count++;
            }
        }
        /* for (double d : sim) {
            System.out.println(" p " + d);
        }*/

        for (int i = 0; i < filename.size(); i++) {
            //  System.out.println("file="+filename.get(i));
            cosmap.put(filename.get(i), sim[i]);
        }
        System.out.println("cosimeSimilarity mapping with file and methodName: " + cosmap);
        
    }

    /*  for (Map.Entry entry : cosmap.entrySet()) {
            double value = (double) entry.getValue();
        
        
        
     SortedSet<String> keySet = new TreeSet<>(cosmap.keySet());
        System.out.println(""+keySet);
        Iterator<String> iterate = keySet.iterator();
       
        Accessing elements
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.println("");
        }
       

   public double TfIdf() {
        double tf;
        double idf;
        double tfidf;
        for (int i = 0; i < m.size(); i++) {

            String[] file = m.get(i).replaceAll("[^a-zA-Z0-9 ]", " ").trim().replaceAll(" +", " ").toLowerCase().split(" ");
    System.out.println(""+m);
       System.out.println("" + m.get(i));
         idf = new Tfidf().idf(m, allterm);
            for (String term : allterm) {
            
          
            
                if (m.get(i).toLowerCase().contains(term)) {
                     System.out.println(""+term);

                   System.out.println("" + term);
                      tf=new Tfidf().TF(file, term);
                  

                }
            }

        }

        return 0;
    }*/
    public  void search() throws FileNotFoundException {
        Test ob = new Test();
        Scanner scan = new Scanner(System.in);
        System.out.println("give a query:");
        String query = scan.nextLine();
        ob.CaptureFileMethod();
        ob.TfIdf(query);
        ob.getIdf();
        ob.Queryvector(query);
        ob.getCosSim();

    }
}
