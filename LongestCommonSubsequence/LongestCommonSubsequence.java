package LongestCommonSubsequence;
class LongestCommonSubSequence{
    private static Integer[][] dp;
    public static void main(String[] args) {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String x = "abcdfgh";
        String y = "abedfhr";

        dp = new Integer[x.length()+1][y.length()+1];

        int length = lcs.lcs_length_memo(x, y, x.length(), y.length());
        System.out.println("Length of longest common subsequence is "+length);

        length = lcs.lcs_length_topDown(x, y, x.length(), y.length());
        System.out.println("Length of longest common subsequence(topDown) is "+length);
    }

    private int lcs_length_memo(String x, String y, int n, int m){
        // base condition -> smallest valid input -> 0 length String
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != null) return dp[n][m];

        // if last char of both String match then count and proceed
        if(x.charAt(n-1) == y.charAt(m-1)){
            dp[n][m] = 1 + lcs_length_memo(x, y, n-1, m-1);
        } else {
            dp[n][m] = Math.max(lcs_length_memo(x, y, n-1, m), lcs_length_memo(x, y, n, m-1));
        }
        return dp[n][m];
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