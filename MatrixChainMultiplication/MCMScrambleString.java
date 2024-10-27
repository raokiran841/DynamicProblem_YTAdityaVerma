package MatrixChainMultiplication;
import java.util.HashMap;
import java.util.Map;

public class MCMScrambleString {

    /**
     * Problem statement: given 2 Strings (say "great", "rgeat"), return whether the 2 are scrambled or not.
     * what is scrambled String ?
     * if you draw binary tree of the chars of string
     
            gr|eat
              / \
            gr   eat
            / \   / \
            g  r  e  at
                     / \
                    a   t

    and try to swap non leaf nodes like [gr] and [eat] and merge them again -> [eatgr]
    then [great] and [eatgr] are scrambled String.
    you can either swap them or leave it as is that means [great] and [great] are also scrambled.
    */

    public static void main(String[] args) {
        MCMScrambleString obj = new MCMScrambleString();
        String x = "great";
        String y = "rtaeg";
        Map<String, Boolean> dp = new HashMap<>();
        boolean result = (x.length() != y.length()) ? false : obj.solve(x, y, dp);
        System.out.println(result);
    }

    private boolean solve(String x, String y, Map<String, Boolean> dp){
        if(x.equals(y)) return true;
        if(x.length() <= 1 || y.length() <= 1) return false;

        String key = x+","+y;

        if(dp.containsKey(key)) return dp.get(key);

        boolean flag = false;
        int n = x.length();

        for(int i = 1; i<=n-1; i++){
            // no swap a|b = a|b
            boolean cond1 = solve(x.substring(0, i), y.substring(0, i), dp) 
                        && solve(x.substring(i), y.substring(i), dp);
            // swap strings a|b = b|a
            boolean cond2 = solve(x.substring(0, i), y.substring(i), dp) 
                        && solve(x.substring(i), y.substring(0, i), dp);
            if(cond1 || cond2){
                flag = true;
                break;
            }
        }

        dp.put(key, flag);

        return flag;
    }
}
