public class KSSubsetSum {
    public static void main(String[] args) {
        KSSubsetSum ss = new KSSubsetSum();
        boolean isPresent = ss.subsetSum(new int[]{2,3,7,8,10}, 11);
        System.out.println("subset : "+isPresent);
    }

    /**
     *  Given a array of numbers, find if there is a subset of the array possible 
     *  with sum of elements equal to given target.
     * 
     * Similar to knapsack we have choice of either take the element for subset or not take.
     * 
    */

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
