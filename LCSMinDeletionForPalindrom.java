public class LCSMinDeletionForPalindrom {
    public static void main(String[] args) {
        LCSMinDeletionForPalindrom minDeleteForPalindrom = new LCSMinDeletionForPalindrom();

        String x = "agbcba";

        /**
         * Problem statement : minimum no if delete operations in given string x to make it a palindrom
         * 
         * Example : agbcba -> abcba (1 deletion of g)
        */

        String y = new StringBuilder(x).reverse().toString();

        int count = x.length() - minDeleteForPalindrom.lcs_length_topDown(x, y, x.length(), y.length());
        System.out.println("minimum no if delete operations in given string x to make it a palindrom "+count);
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
