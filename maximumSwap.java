/** 670. Maximum Swap
 *  https://leetcode.com/problems/maximum-swap/
 *  
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 *
 */
class maximumSwap {
    public int maximumSwap(int num) {
        String number = String.valueOf(num);
        String[] numberArray = number.split("");

        int maxValue = Integer.MIN_VALUE;

        int maxValueIndex = 0;

        int[] pairs =new int[2];


        for (int i = number.length() - 1 ; i >=0 ; i-- ){

            int currentNumber = Integer.parseInt(numberArray[i]);


            if (maxValue < currentNumber) {
                maxValue = currentNumber;
                maxValueIndex = i;
            }



            if (currentNumber < maxValue) {
                // hold or change pairs here
                pairs[0] = i;
                pairs[1] = maxValueIndex;

            }


        }

        String temp = numberArray[pairs[1]];
        numberArray[pairs[1]] = numberArray[pairs[0]];
        numberArray[pairs[0]] = temp;


        String output = "";
        for(String digit : numberArray) {
            output += digit;
        }
        return Integer.parseInt(output);
    }
}
