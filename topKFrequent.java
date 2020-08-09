/** 347. Top K Frequent Elements
 *  https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        int[] output = new int[k];
        Map<Integer,Integer> numFreq = new HashMap<>();

        for (int num : nums) {
            if (numFreq.containsKey(num)) {
                numFreq.put(num,numFreq.get(num) + 1);
            }
            else {
                numFreq.put(num,1);
            }
        }
        int index = 0;
        while (k > 0) {
            int max = Integer.MIN_VALUE;
            int key = 0;

            for (Map.Entry<Integer,Integer> entry : numFreq.entrySet()) {
                if (entry.getValue() > max){
                    max = entry.getValue();
                    key = entry.getKey();

                }
            }
            numFreq.remove(key);
            output[index] = key;
            index++;
            k--;
        }
        return output;

    }
}
