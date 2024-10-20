public class LCSPrintSCS {
    public static void main(String[] args) {
        LCSPrintSCS obj = new LCSPrintSCS();

        String x = "abcdef";
        String y = "deabf";

        /**
         * problem statement : print the shortest common supersequence;
        */

        int[][] t = new int[x.length()+1][y.length()+1];
        int i = x.length();
        int j = y.length();

        obj.lcs_length_topDown(x, y, x.length(), y.length(), t);

        String scs = "";
        while(i > 0 && j > 0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                scs += x.charAt(i-1);
                i--;
                j--;
            } else {
                //scs += x.charAt(i-1) + y.charAt(j-1);
                if(t[i][j-1] > t[i-1][j]){
                    scs += y.charAt(j-1);
                    j--;
                } else {
                    scs += x.charAt(i-1);
                    i--;
                }
            }
        }
        while(i>0){
            scs += x.charAt(i-1);
            i--;
        }
        while(j>0){
            scs += y.charAt(j-1);
            j--;
        }

        System.out.println("Shortest common supersequence is "+scs);

    }

    private void lcs_length_topDown(String x, String y, int n, int m, int[][] t){
        // base condition -> smallest valid input -> 0 length String
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // if last char of both String match then count and proceed
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
    }
}
