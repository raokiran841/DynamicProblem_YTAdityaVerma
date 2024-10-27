package LongestCommonSubsequence;
public class LCSubstring {
    public static void main(String[] args) {
        LCSubstring lcSubstring = new LCSubstring();
        String x = "abcdef";
        String y = "fbcdae";
        int length = lcSubstring.lcString(x, y, x.length(), y.length());
        System.out.println("Length of logest common substring is "+length);
    }

    private int lcString(String x, String y, int n, int m){
        // base condition -> smallest valid input -> 0 length String
        
        int[][] t = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // if last char of both String match then count and proceed
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(max < t[i][j]){
                    max = t[i][j];
                }
            }
        }
        return max;
    }
}
