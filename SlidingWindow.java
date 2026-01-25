import java.util.HashSet;

public class SlidingWindow {

    static int maxSumSubarray(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }
            if (!hs.contains(s.charAt(right))) {
                hs.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

    static int lengthOfLongestSubarrayWithSumLessThanOrEqualToK(int[] arr, int k) {
        int left = 0, currentSum = 0, maxLength = 0;
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            while (currentSum > k) {
                currentSum -= arr[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    static int minSubArrayLen(int target, int[] nums) {
        int left = 0, currentSum = 0, minArray = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minArray = Math.min(minArray, right - left + 1);
                currentSum -= nums[left];
                left++;
            }

        }
        return minArray == Integer.MAX_VALUE ? 0 : minArray;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSumSubarray(arr, k));

        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters in \"" + s + "\" is: "
                + lengthOfLongestSubstring(s));

        int[] arr2 = { 2, 5, 1, 8, 2, 1 };
        int k2 = 5;
        System.out.println("Length of the longest subarray with sum less than or equal to" + k2 + " is: "
                + lengthOfLongestSubarrayWithSumLessThanOrEqualToK(arr2, k2));

        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println("Minimum length of a subarray with sum at least " + target + " is: "
                + minSubArrayLen(target, nums));
    }
}
