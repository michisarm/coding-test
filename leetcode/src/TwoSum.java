import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 1. Two Sum
 * Easy

 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */


public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                for (int j = i; j < nums.length; j++) {
                    if(i != j){
                        if(x + nums[j] == target){
                            result.add(i);
                            result.add(j);
                        }
                    }
                }
            }
            return result.stream().mapToInt(i->i).toArray();
        }

        public int[] twoSum2(int[] nums, int target) {
            Map<Integer,Integer> obj = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int value = nums[i];
                int diff = target - value;
                if (obj.containsKey(diff)) {
                    int prevIndx = obj.get(diff);
                    return new int[] {prevIndx , i };
                } else {
                    obj.put(value, i);
                }
            }

            return new int[]{-1,-1};
        }

        // 중복된 숫자의 배열 들어오면 fail
        public int[] twoSum3(int[] nums, int target) {
            Map<Integer,Integer> obj = new HashMap<>();
            IntStream.rangeClosed(0,nums.length-1).mapToObj(i->obj.put(nums[i],i)).toArray();
            // {2=1, 7=2, 11=3, 15=4}
            // {2=1, 3=0, 4=2}

            for (int i = 0; i < nums.length; i++) {
                int value = nums[i];
                int diff = target - value;
                 //System.out.println(obj +" " + value+ " " +diff);
                if (obj.containsKey(diff) && obj.get(diff) != i) {
                    return new int[]{obj.get(value), obj.get(diff)};
                }
            }
            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum2(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum3(new int[]{2,7,11,15}, 9)));
        System.out.println("---");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum2(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum3(new int[]{3,2,4}, 6)));
        System.out.println("---");
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(solution.twoSum2(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(solution.twoSum3(new int[]{3,3}, 6)));
    }
}



/**
 * hint 1
 * A really brute force way would be to search for all possible pairs of numbers but that would be too slow. Again, it's best to try out brute force solutions for just for completeness. It is from these brute force solutions that you can come up with optimizations.
 *
 * hint2
 * So, if we fix one of the numbers, say
 * x
 * , we have to scan the entire array to find the next number
 * y
 * which is
 * value - x
 * where value is the input parameter. Can we change our array somehow so that this search becomes faster?
 *
 * hint3
 * The second train of thought is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?
 */