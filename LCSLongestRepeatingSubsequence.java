public class LCSLongestRepeatingSubsequence {
    public static void main(String[] args) {
        LCSLongestRepeatingSubsequence obj = new LCSLongestRepeatingSubsequence();
        String x = "AABEBCDD";

        int length = obj.longestRepeatingSubsequence(x, x, x.length(), x.length());
        System.out.println("length of longest repeating subsequence is "+length);
    }

    private int longestRepeatingSubsequence(String x, String y, int n, int m){
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
                // Notice "i != j",
                // Basically same String LCS with repeating characters taken once only will give the
                // no of repeating subsequence
                if(x.charAt(i-1) == y.charAt(j-1) && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[n][m];
    }
}
