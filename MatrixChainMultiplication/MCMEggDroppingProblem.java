package MatrixChainMultiplication;
public class MCMEggDroppingProblem {
    /**
     * Given N eggs and F floors, return the no of attempts needed to identify the floor
     * from which if the egg is dropped it will break.
    */

    public static void main(String[] args) {
        int n = 1;
        int f = 10;

        Integer[][] dp = new Integer[n+1][f+1];

        int result = new MCMEggDroppingProblem().eggDrop(n, f, dp);
        System.out.println("Egg broke with attempts = "+result);
    }

    private int eggDrop(int e, int f, Integer[][] dp){
        if(f == 0 || f == 1){
            return f;
        }
        if(e == 1){
            return f;
        }

        if(dp[e][f] != null){
            return dp[e][f];
        }

        int minAttempts = Integer.MAX_VALUE;

        for(int k=1; k<=f; k++){
            int eBreak = dp[e-1][k-1] != null ? dp[e-1][k-1] : eggDrop(e-1, k-1, dp);
            int eNotBreak = dp[e][f-k] != null ? dp[e][f-k] : eggDrop(e, f-k, dp);
            int temp = 1 + Math.max(eBreak, eNotBreak);
            minAttempts = Math.min(minAttempts, temp);
        }

        dp[e][f] = minAttempts;

        return minAttempts;
    }
}
