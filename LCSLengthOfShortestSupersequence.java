public class LCSLengthOfShortestSupersequence {
    public static void main(String[] args) {
        LCSLengthOfShortestSupersequence loss = new LCSLengthOfShortestSupersequence();
        String x = "AGGTAB";
        String y = "GXTXAYB";

        /**
         * Problem statement : from given x and y, find the length of the shortest supersequence.
         * 
         * Supersequence -> x + y is the lastest super sequence
         * Example: x = abcd, y = cdef
         * 
         * Supersequence = x+y => abcdcdef (length 8)
         * but shortest supersequence can be -> abcdef (length 6)
         * 
         * here in given question shortest super sequence will be AGGXTXAYB (length 9)
         * 
         * we observe that if subtract the length of LCS from the largest supersequence because
         * LCS is common in both String so removing one time will give us the length of optimal shorter version.
         * 
        */

        int len = x.length() + y.length() - loss.lcs_length_topDown(x, y, x.length(), y.length());
        System.out.println("Length of shortest supersequence is "+len);
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
