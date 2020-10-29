// Time Complexity O(m*n), m and n represent the row and column length of the matrix respectively
// Space Complexity : O(1), no extra space is being used
// Did this code successfully run on Leetcode : Yes

// Three line explanation of solution in plain english
//1. Starting at first index traverse the matrix in upward direction diagonally till you reach the top
//2. Then increase the column (if last column increase row) and start traversing the matrix in dowmward direction diagonally till you reach the bottom
//3. Then increase the row (if last row, increase the column),and start traversing the matrix in upward direction diagonally till you reach top 
    //keep doing this to complete traversal of the entire matrix

// Your code here along with comments explaining your approach

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        
        //return empty array, if matrix is null or empty
        if(matrix == null || matrix.length ==0) return new int[0];
        
        //direction variable, 1 is upwards and -1 is downwards
        int dir =1;
        //index for result array
        int k=0;
        //row
        int i=0;
        //column
        int j=0;
        //row length
        int m = matrix.length;
        //column length 
        int n = matrix[0].length;
        //output array
        int []result = new int[m*n];
        
        //iterate over the matrix, while i and j are inside their upper limits
        while(i<m && j<n){
            //insert the cell value in the output array
            result[k] = matrix[i][j];
            //and increment the output array index
            k++;
            
            //moving upward
            if(dir == 1){
                //if j is at the last column, and i is not at the last row
                if(j==n-1 && i < m-1){
                    i++; dir = -1;
                }
                else if(i==0){
                    j++; dir = -1;
                }
                else{
                    i--; j++;
                }
                
            }else{ //moving downward
                //if i is at the last row, and j is not at the last column
                if(i == m-1 && j < n-1){
                    j++; dir=1;
                }
                else if(j == 0){
                    i++; dir=1;
                }
                else{
                    i++; j--;
                }
            }
        }
        return result;
    }
}