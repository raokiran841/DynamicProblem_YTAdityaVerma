public class Knapsack {

    private static Integer[][] dp;
    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        int[] wt = new int[]{2,3,4,5};
        int[] val = new int[]{4,4,5,6};
        int cap = 7;

        dp = new Integer[wt.length+1][cap+1];

        int profit = k.knapsack_memo(wt, val, cap, wt.length);
        System.out.println("Profit: "+profit);

        profit = k.knapsack_topDown(wt, val, cap, wt.length);
        System.out.println("Profit (topDown): "+profit);
    }

    private int knapsack_memo(int[] wt, int[] val, int W, int n){
        // base condition -> minimum valid input -> W can be 0 and array can be empty i.e, wt.length = 0
        if(n == 0 || W == 0){
            return 0;
        }

        if(dp[n][W] != null){
            return dp[n][W];
        }

        // choices: if wt[i] <= W that mean we can either add it or not add it, 
        // But if wt[i] > W then for sure we cannot add it to sack.
        if(wt[n-1] <= W){
            // returning optimal(max) value possible of all the choices
            dp[n][W] = Math.max(val[n-1] + knapsack_memo(wt, val, W - wt[n-1], n-1),
                                    knapsack_memo(wt, val, W, n-1));
        } else {
            dp[n][W] = knapsack_memo(wt, val, W, n-1);
        }
        return dp[n][W];
    }

    private int knapsack_topDown(int[] wt, int[] val, int W, int n){
        int[][] t = new int[n+1][W+1];
        // base condition -> minimum valid input -> W can be 0 and array can be empty i.e, wt.length = 0
        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        // choices: if wt[i] <= W that mean we can either add it or not add it, 
        // But if wt[i] > W then for sure we cannot add it to sack.
        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        
        return t[n][W];
    }
}
