public class UKSCoinChangeII {
    public static void main(String[] args) {
        UKSCoinChangeII cc2 = new UKSCoinChangeII();
        int[] coins = new int[]{1,2,5};
        int sum = 17;
        int minNoOfCoins = cc2.coinChange2(coins, sum);
        System.out.println("Min number of coins required for "+sum+" is "+minNoOfCoins);
    }

    private int coinChange2(int[] coins, int sum){
        int[][] t = new int[coins.length+1][sum+1];

        for(int i=0; i<coins.length+1; i++){
            for(int j=0; j<sum+1; j++){
                if(j==0){
                    t[i][j] = 0; // for sum 0 with whatever coins, 0 coins are needed.
                }
                // for 0 sum and empty coins the num of coins needed will be INFINITY
                if(i==0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }
            }
        }
        // 2nd row also need to be filled with same logic. 
        // for sum of 4 with coin 3 Infinite coins are needed.
        for(int i=1, j=1; j<sum+1; j++){
            if(j % coins[i] == 0){
                t[i][j] = j / coins[i];
            } else {
                t[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        for(int i=2; i<coins.length+1; i++){
            for(int j=1; j<sum+1; j++){
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];
    }
}
