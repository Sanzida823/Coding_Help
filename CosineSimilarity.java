package VSM;

public class CosineSimilarity {

    public double cosineSimilarity(double[] docvec1, double[] docvec2) {
        double dotproduct = 0;
        double magnitude1 = 0;
        double magnitude2 = 0;
        double cosinesim = 0;
        double cos = 0;
        for (int i = 0; i < docvec1.length; i++) {
            /*   for (int j = 0; j < docvec2.length; j++) {
             double x = Array.getDouble(docvec1, i);
              System.out.println("x " + x);
                double y = Array.getDouble(docvec2, j);
              System.out.println("y "+docvec2.length);
if(x==y){
if(docvec1[i]==docvec2[i]){
              System.out.println("x= "+x);
              System.out.println("y= "+y);
               System.out.println("vec2 " + docvec2[i]);*/
          //  System.out.println("doc1 " + docvec1[i]);
            //System.out.println("doc2 " + docvec2[i]);
            dotproduct += docvec1[i] * docvec2[i];
            //System.out.println("dotproduct=" + dotproduct);
            magnitude1 += Math.pow(docvec1[i], 2);//square a

            magnitude2 += Math.pow(docvec2[i], 2);    //square b

        }
        // System.out.println("ko"+magnitude1);
        //  magnitude1 = Math.sqrt(magnitude1);
        // System.out.println("mag1 " + magnitude1);
        //   magnitude2 = Math.sqrt(magnitude2);
        //  System.out.println("mag2 " + magnitude2);

        if (magnitude1 != 0 && magnitude2 != 0) {
            cosinesim = dotproduct / Math.sqrt(magnitude1 + magnitude2);
        

        } else {
            return 0;
        }
    System.out.println("cosimeSimilarity="+cosinesim);
        return cosinesim;
    }
}
