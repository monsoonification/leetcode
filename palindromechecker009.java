
class Solution {
    public boolean isPalindrome(int x) {
        String xString = Integer.toString(x);
        char[] testArray = xString.toCharArray();
        int midpoint = Math.floorDiv(xString.length(), 2);
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] != testArray[xString.length() - i - 1]) {
                return false;
            }
            if (i == midpoint) {
                break;
            }
        }
        return true;
        
    }
}
// for some reason the leetcode website compiles my code but vscode hates me, hm.
public class palindromechecker009{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
    }
}