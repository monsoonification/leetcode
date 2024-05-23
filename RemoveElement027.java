import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class BadSolution {
    public int removeElement(int[] nums, int val) {
        HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length - 1; i++) {
            valueMap.put(nums[i], (int) valueMap.getOrDefault(nums[i], 0) + 1);
            nums[i] = 0;
            //put all da values in da hashmap
        }
        int k = nums.length - 1 - Integer.parseInt(valueMap.get(val).toString());
        valueMap.remove(val);

        Set<Integer> keySet = valueMap.keySet();
        //uhhhh
        List<Integer> result = keySet.stream()
                .flatMap(key -> {
                    int value = valueMap.get(key);
                    return Arrays.stream(new Integer[value]).map(v -> value);
                }).collect(Collectors.toList());

        for (int i = 0; i < result.size(); i++) {
            nums[i] = Integer.valueOf(result.get(i).toString());
        }
        return k;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == val) {
                swapRemove(nums, i, end);
                end--;
                i--; // re-check the current index after the swap
            }
        }
        return end + 1;
    }

    private void swapRemove(int[] nums, int index, int end) {
        nums[index] = nums[end];
        nums[end] = -1; // Optional: Mark end element as removed (for clarity)
    }
}


public class RemoveElement027 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {0,1,2,2,3,0,4,2};
        int[] test2 = {3,2,2,3};
        solution.removeElement(test1, 2);
        System.out.println(Arrays.toString(test1));
        solution.removeElement(test2, 3);
        System.out.println(Arrays.toString(test2));
    }
}