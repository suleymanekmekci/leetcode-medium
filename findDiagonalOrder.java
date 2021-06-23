/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.


Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
*/
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // two directions: up or down
        // up: check for the top right position, if exists go there.
        // if there isn't any element in top right, first check right, 
        // if there is an element go, if there isn't any element in right, go down
        
        // down: check for the bottom left position. 
        // if does not exist: check for the bottom
        // if does not exist: check for the right
        
        int[] output = new int[mat.length * mat[0].length];
        int index = 0;
        
        String direction = "up";
        
        int i = 0;
        int j = 0;
        
        int temp = 0;
        
        while (temp < output.length) {

            output[index++] = mat[i][j];
            if (direction.equals("up")) {
                int nextI = i - 1;
                int nextJ = j + 1;
                if (nextI >= 0 && nextJ < mat[i].length) {
                    i = nextI;
                    j = nextJ;
                } 
                else {
                    if (nextJ < mat[i].length) {
                        j = nextJ;
                        direction = "down";
                    }
                    else {
                        i++;
                        direction = "down";
                    }
                    
                }
                
            } 
            else {
                int nextI = i + 1;
                int nextJ = j - 1;
                
                if (nextI < mat.length && nextJ >= 0) {
                    i = nextI;
                    j = nextJ;
                } 
                else {
                    if (nextI < mat.length) {
                        i = nextI;
                        direction = "up";
                    }
                    else {
                        j++;
                        direction = "up";
                    }
                }
                
            }
            
            
            temp++;
        }
        return output;
        
    }
}
