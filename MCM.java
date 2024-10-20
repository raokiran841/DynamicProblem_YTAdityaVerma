public class MCM {

    private static Integer[][] dp;
    public static void main(String[] args) {
        MCM mcm = new MCM();
        int[] arr = new int[]{40, 20, 30, 10, 30};

        dp = new Integer[arr.length+1][arr.length+1];

        int result = mcm.solve(arr, 1, arr.length-1);
        System.out.println("minimum cost of matrix multiplication is "+result);
    }

    private int solve(int[] arr, int i, int j){
        // base case
        if( i >= j){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for(int k=i; k<j; k++){
            int temp = solve(arr, i, k)
                    + solve(arr, k+1, j)
                    + (arr[i-1] * arr[k] * arr[j]);
            if(temp < min){
                min = temp;
            }
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}
