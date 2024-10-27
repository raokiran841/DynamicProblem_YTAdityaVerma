package MatrixChainMultiplication;
public class MCMPalindromPartition {
    private static Integer[][] dp;
    public static void main(String[] args) {

        String s = "nitinabb";
        dp = new Integer[s.length()+1][s.length()+1];

        int result = new MCMPalindromPartition().solve(s, 0, s.length()-1);
        System.out.println("number of palindrom partinions is :"+result);
        
    }

    private int solve(String s, int i, int j){
        // base case
        if( i >= j){
            return 0;
        }

        if(isPalindrom(s, i, j)) return 0;

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            int temp = solve(s, i, k) + solve(s, k+1, j) + 1;
            if(temp < min){
                min = temp;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    private boolean isPalindrom(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
