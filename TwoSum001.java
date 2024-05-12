import java.util.Hashtable;

/**
 * solution for the leetcode problem
 */
class Solution {
    /**
     * i wrote like 90% i just looked at the hint for debugging, kinda neat
     * @param nums the array of values input
     * @param target the sum we need to achieve
     * @return the indexes of the values
     */
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> valueMap = new Hashtable<>();
        int[] val = new int[2];
        for (int i = 0; i < nums.length; i++) {
            valueMap.put(nums[i], i);
            // who up mapping they values
        }
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (valueMap.containsKey(remainder) && valueMap.get(remainder) != i) {
                // If found, return the indices of current element and its complement
                val[0] = valueMap.get(remainder); // Index of complement
                val[1] = i; // Current index
                return val;
            }
        }
        return val;
    }
}

public class TwoSum001 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {2,7,11,15};
        int[] test2 = {3,2,4};
        int[] test3 = {3,3};
        System.out.println(solution.twoSum(test1, 9));
        System.out.println(solution.twoSum(test2, 6));
        System.out.println(solution.twoSum(test3, 6));
    }
}