package KnapSack;
public class KSCountOfSubsetSum {
    public static void main(String[] args) {
        KSCountOfSubsetSum coss = new KSCountOfSubsetSum();
        int count = coss.countOfSumsetSum(new int[]{2,5,8,3,10}, 10);
        System.out.println("total numner of subsets with sum: "+10+" are: "+count);
    }

    private int countOfSumsetSum(int[] arr, int sum){
        int[][] dp = new int[arr.length+1][sum+1];
        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                if(j == 0){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=1; i<arr.length+1; i++){
            for(int j=1; j<sum+1; j++){
                // the number should be less than or equal to sum
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
}
