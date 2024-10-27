package KnapSack;
public class KSEqualSumPartition {
    public static void main(String[] args) {
        KSEqualSumPartition esp = new KSEqualSumPartition();
        boolean isPossible = esp.equalSumPartition(new int[]{5,1,11,5});
        System.out.println("Equal sum partition possible? "+isPossible);
    }

    /**
     * Problem is to find if the given array of numbers can be divided into 2 subsets both of which
     * will have the same sum
     * 
     * Example:
     * 
     * {1,5,11,5} -> {1,5,5} & {11} 👍
     * 
     * catch is, for the array to be dividd into 2 equal halfs the sum of all numbers of array should
     * be even (only even can be divided equally) ....... (1)
     * 
     * Example:
     * {1,5,5, 10} -> {1,5,5} & {10} 👎
     * 
     * This problem is similar to subset problem where we need to find if the 
     * subset of array with given sum is present or not, but sum is not provided. ...... (2)
     * 
     * As per (1) and (2), we know that if the array has a subset with sum as half the total sum
     * then the array can be divided into 2 equal sum partition.
     * 
    */

    private boolean equalSumPartition(int[] arr){
        int sum = 0;
        for(int val : arr){
            sum += val;
        }

        return sum%2 == 0 && subsetSum(arr, sum/2);
    }

    private boolean subsetSum(int[] arr, int t){

        boolean[][] dp = new boolean[arr.length+1][t+1];

        for(int i=0; i<arr.length+1; i++){
            for(int j=0; j<t+1; j++){
                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1; i<arr.length+1; i++){
            for(int j=1; j<t+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][t];
    }
}
