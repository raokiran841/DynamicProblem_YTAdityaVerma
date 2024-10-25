
import java.util.HashMap;

public class MCMEvaluateExprTrue {

    /**
     * Problem statement is that given a String of expression having T(true) and F(false) and operators (|, &, ot ^).
     * return the number of ways possible to add paranthesis around them so that the expression evaluates to true.
     * 
     * Example: 
     * The given expression is "T | T & F ^ T", it evaluates true 
     * in 4 ways 
     * ((T|T)&(F^T)), 
     * (T|(T&(F^T))), 
     * (((T|T)&F)^T) and 
     * (T|((T&F)^T))
     * 
     * The given expression is "T ^ F | F", it evaluates true 
     * in 2 ways 
     * ( (T ^ F) | F ) and 
     * ( T ^ (F | F) )
     * 
     */

    private static HashMap<String, Integer> dp = new HashMap<>();
    public static void main(String[] args) {
        MCMEvaluateExprTrue obj = new MCMEvaluateExprTrue();
        String s = "T^F|F";
        dp = new HashMap<>();
        int result = obj.solve(s.toLowerCase(), 0, s.length()-1, true);
        System.out.println(result);
    }

    private int solve(String s, int i, int j, boolean isTrue){
        // base condition
        if(i > j) return 0;
        if(i == j){
            if(isTrue){
                if(s.charAt(i) == 't'){
                    return 1;
                } else {
                    return 0;
                }
            }
            if(!isTrue){
                if(s.charAt(i) == 'f'){
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        String key = i+","+j+","+isTrue;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int ans = 0;

        // k loop : divide string by operators
        for(int k = i+1; k<=j-1; k+=2){
            int lt = solve(s, i, k-1, true);
            int lf = solve(s, i, k-1, false);
            int rt = solve(s, k+1, j, true);
            int rf = solve(s, k+1, j, false);
            
            if(s.charAt(k) == '^'){
                /**
                 * T^T = F
                 * F^F = F
                 * T^F = T
                 * F^T = T
                */
                if(isTrue) ans += lt*rf + lf*rt;
                else ans += lt*rt + lf*rf;
            } else if(s.charAt(k) == '|'){
                /**
                 * T|T = T
                 * F|F = F
                 * T|F = T
                 * F|T = T
                */
                if(isTrue) ans += lt*rt + lf*rt + lt*rf;
                else ans += lf*rf;
            } else if(s.charAt(k) == '&'){
                /**
                 * T&T = T
                 * F&F = F
                 * T&F = F
                 * F&T = F
                */
                if(isTrue) ans += lt*rt;
                else ans += lf*rf + lf*rt + lt*rf;
            }
        }

        dp.put(key, ans);

        return ans;
    }
}
