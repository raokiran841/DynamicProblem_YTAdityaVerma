package LongestCommonSubsequence;
public class LCSMinOnOfInsertionDeletion {
    public static void main(String[] args) {
        LCSMinOnOfInsertionDeletion minInsertDelete = new LCSMinOnOfInsertionDeletion();
        String x = "heap";
        String y = "pea";

        /**
         * Problem statement : convert string x to y with minimum number of insertions and deletion
         * operations.
         * 
         * heap -> pea
         * 
         * Solution : lcs of both is "ea" which is not changing.
         * 
         * So we convert x -> lcs by deleting then lcs -> y by inserting
         * 
         * heap -> ea (2 delete ops h and p) -> pea (1 insert op of p)
         * 
        */

        int lcs = minInsertDelete.lcs_length_topDown(x, y, x.length(), y.length());

        System.out.println("deletions: " + (x.length() - lcs) + " and insertions "+ (y.length() - lcs));
    }

    private int lcs_length_topDown(String x, String y, int n, int m){
        // base condition -> smallest valid input -> 0 length String
        
        int[][] t = new int[n+1][m+1];

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

        return t[n][m];
    }
}
