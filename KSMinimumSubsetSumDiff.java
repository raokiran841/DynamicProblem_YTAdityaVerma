public class KSMinimumSubsetSumDiff {
    public static void main(String[] args) {
        KSMinimumSubsetSumDiff mssd = new KSMinimumSubsetSumDiff();
        int diff = mssd.minSubsetSumDiff(new int[]{1,2,7});
        System.out.println("min subset diff: "+diff);
    }

    private int minSubsetSumDiff(int[] arr){
        int range = 0;
        for(int val : arr){
            range += val;
        }
        boolean[][] dp = new boolean[arr.length+1][range+1];

        subsetSum(arr, range, dp);

        // for(int i=0; i<arr.length+1; i++){
        //     for(int j=0; j<range+1; j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<range/2; i++){
            if(dp[arr.length][i]){
                min = Math.min(min, range - 2*i);
                //System.out.println(i+" "+min);
            }
        }
        return min;
    }

    private void subsetSum(int[] arr, int t, boolean[][] dp){

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
    }
}
