import java.util.HashMap;

public class RomanToInteger013 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III") == 3);
        System.out.println(solution.romanToInt("LVIII") == 58);
        System.out.println(solution.romanToInt("MCMXCIV") == 1994);
    }
}


class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> valueMap = new HashMap<>();
        valueMap.put("I", 1);
        valueMap.put("V", 5);
        valueMap.put("X", 10);
        valueMap.put("L", 50);
        valueMap.put("C", 100);
        valueMap.put("D", 500);
        valueMap.put("M", 1000);
        // s.replace("IV", "IIII");
        // s.replace("IX", "VIIII");
        // s.replace("XL", "XXXX");
        // s.replace("CL", "LXXXX");
        // s.replace("CD", "CCCC");
        // s.replace("CM", "DCCCC");
        int sum = 0;
        int currVal, preval = 0;
        for (char c : s.toCharArray()) {
            currVal = valueMap.get(c + "");
            if (currVal > preval && preval != 0) {
                sum -= 2 * preval;
            } 
            sum += currVal;
            preval = currVal;
        }
        return sum;
    }
}

