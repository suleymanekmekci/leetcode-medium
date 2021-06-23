/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.

*/
class Solution {
    public int countSquares(int[][] matrix) {
        int[][] squareMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    squareMatrix[i+1][j+1] = 0;
                }
                else {
                     squareMatrix[i+1][j+1] =Math.min(squareMatrix[i+1][j],Math.min(squareMatrix[i][j],squareMatrix[i][j+1]) ) + matrix[i][j] ;
                }
                
               

            }
        }
        int total = 0;
        for (int i = 0; i < squareMatrix.length; i++) {
            for (int j = 0; j < squareMatrix[i].length; j++) {
                total += squareMatrix[i][j];
            }
        }
        return total;
        
        
    }
}
