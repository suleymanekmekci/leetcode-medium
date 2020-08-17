/** 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int counter = 0;

        while (counter < k) {
            for (int i = 0; i < nums.length-1;i++) {
                if (nums[i] > nums[i+1]) {
                    swapValues(i,i+1,nums);
                }
            }
            counter++;
        }
        return nums[nums.length - k];
    }

    public void swapValues(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
