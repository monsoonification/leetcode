import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
/*
 * test test test waaaaa
 */
class Solution {
    /**
     * extremely shitty implementation i cooked up because i forgot hashtables existsed
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramWithLists(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }        int maxLength = 5 * (int)Math.pow(10, 4);
        if (s.length() < 1 || t.length() > maxLength) {
            return false; // given constraint, filter for length
        }
        String regex = "[A-Z]";
        if (s.matches(regex) || t.matches(regex)) {
            return false; //filter for lower cases;
        }
        

        List<Character> inputLetters = convertToList(s.toCharArray());
        List<Character> checkedLetters = convertToList(t.toCharArray());
        int listSize = inputLetters.size();

        Boolean[] letterList = new Boolean[listSize]; // true if used, false otherwise
        for (int i = 0; i < letterList.length; i++) {
            letterList[i] = false;
        }
        boolean matched = false;
        for (Character i : inputLetters) {
            matched = false;
            int tempJIndex = 0;
            for (Character j : checkedLetters) {
                if ((i.compareTo(j)) == 0 && letterList[tempJIndex] == false) {
                    matched = true;
                    letterList[tempJIndex] = true;
                    break;
                }
                tempJIndex++;
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }
    private static List<Character> convertToList(char[] array) {
        List<Character> list = new ArrayList<>();
        for (char c : array) {
            list.add(c);
        }
        return list;
    }

    /**
     * new superior solution
     * based on the stuff i read about hashtables, sadly
     */
    public Boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> valueMap = new Hashtable<>();
        for (char x : s.toCharArray()){
            valueMap.put(x,valueMap.getOrDefault(x, 0) + 1);
        }
        for (char x : t.toCharArray()){
            valueMap.put(x,valueMap.getOrDefault(x, 0) - 1);
        }
        for (int val: valueMap.values()){
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}

public class anagramChecker {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("aacc", "ccac"));
    }
}