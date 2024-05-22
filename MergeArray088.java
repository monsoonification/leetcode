import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp.add(nums1[i]);
                i++;
            } else {
                temp.add(nums2[j]);
                j++;
            }
        }
        while (i < m) {
            temp.add(nums1[i]);
            i++;
        }
        while (j < n) {
            temp.add(nums2[j]);
            j++;
        }
        for (int k = 0; k < temp.size(); k++) {
            nums1[k] = temp.get(k);
        }
    }
}

public class MergeArray088 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = {1,2,3,0,0,0};
        int[] test2 = {2,5,6};
        solution.merge(test1, 3, test2, 3);
        System.out.println(test1);
    }
}