package KnapSack;
public class KSCountOfSubsetWithDiff {
    public static void main(String[] args) {
        KSCountOfSubsetWithDiff coswd = new KSCountOfSubsetWithDiff();
        int[] arr = new int[]{1,1,2,3};
        int diff = 1;
        int count = coswd.countOfSubsetsWithGivenDiff(arr, diff);
        System.out.println("count of subsets with diff "+diff+" are:"+count);
    }

    private int countOfSubsetsWithGivenDiff(int[] arr, int diff){
        // s1 - s2 = diff & s1 + s2 = sumOfArrayElements(range);
        int range = 0;
        for(int val : arr){
            range += val;
        }

        int s1 = (range+diff)/2;

        return countOfSumsetSum(arr, s1);
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