/** 406. Queue Reconstruction by Height
 *  https://leetcode.com/problems/queue-reconstruction-by-height/
 *  
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
class reconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {

        int[][] output = new int[people.length][2];
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) return 1;
                else if (o1[1] < o2[1])return -1;
                return 0;
            };
            return Integer.compare(o2[0],o1[0]);
        });

        List<int[]> links = new LinkedList<>();

        for (int[] toAdd : people) {
            links.add(toAdd[1],toAdd);
        }

        for (int i = 0; i < links.size(); i++) {
            output[i] = links.get(i);
        }

        return output;
    }
}
