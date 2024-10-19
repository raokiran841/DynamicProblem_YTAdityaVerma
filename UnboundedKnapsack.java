public class UnboundedKnapsack {

    private static int[][] dp;
    public static void main(String[] args) {
        UnboundedKnapsack uks = new UnboundedKnapsack();
        int[] wt = new int[]{2,3,4,5};
        int[] val = new int[]{4,4,5,6};
        int cap = 7;

        dp = new int[wt.length+1][cap+1];

        int profit = uks.unboundedKnapsack_memo(wt, val, cap, wt.length);
        System.out.println("profit: "+profit);

        profit = uks.unboundedKnapsack_topDown(wt, val, cap, wt.length);
        System.out.println("profit: "+profit);
    }

    /**
     * same as Knapsack but here the elements can be taken more than one time. 
     * So minor change will be there in code from that of knapsack.
    */

    private int unboundedKnapsack_memo(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }

        if(wt[n-1] <= W){
            // Notice "n" instead of n-1 in take case !!, 
            // its because in unbounded case you can take it multiple times
            dp[n][W] = Math.max(val[n-1] + unboundedKnapsack_memo(wt, val, W - wt[n-1], n),
                                unboundedKnapsack_memo(wt, val, W, n-1));
        } else {
            dp[n][W] = unboundedKnapsack_memo(wt, val, W, n-1);
        }

        return dp[n][W];
    }

    private int unboundedKnapsack_topDown(int[] wt, int[] val, int W, int n){
        int[][] t = new int[n+1][W+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<W+1; j++){
                if(wt[i-1] <= j){
                    // Notice "i" instead of "i-1" in take case !!, 
                    // its because in unbounded case you can take it multiple times
                    t[i][j] = Math.max(val[i-1] + t[i][j - wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
