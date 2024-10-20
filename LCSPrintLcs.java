public class LCSPrintLcs {
    public static void main(String[] args) {
        LCSPrintLcs printLcs = new LCSPrintLcs();
        String x = "abcdefg";
        String y = "bcdafg";
        String lcs = printLcs.lcs_length_topDown(x, y, x.length(), y.length());
        System.out.println("Longest common subsequence -> "+ lcs);
    }

    private String lcs_length_topDown(String x, String y, int n, int m){
        // base condition -> smallest valid input -> 0 length String
        
        String[][] t = new String[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0){
                    t[i][j] = "";
                }
                if(j==0){
                    t[i][j] = "";
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // if last char of both String match then count and proceed
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = t[i-1][j-1] + x.charAt(i-1);
                } else {
                    t[i][j] = t[i-1][j].length() > t[i][j-1].length() ? t[i-1][j] : t[i][j-1];
                }
            }
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }

        return t[n][m];
    }
}
