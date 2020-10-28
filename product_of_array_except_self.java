// Time Complexity : O(n), where n is the size of nums array;
// Space Complexity :O(1), as we are doing all the calculations in the output array
// Did this code successfully run on Leetcode : Yes

// Three line explanation of solution in plain english
//1. At every index in the result array, calculate the product of all the elements to the left of each element in the nums array
//2. Now, Simply calculate the product of all the elements to the right of each element in the nums array
//3. The multiplication of above 2 is the product of array except self

// Your code here along with comments explaining your approach

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //return empty array if nums is null or empty
        if(nums == null || nums.length ==0 ) return new int[0];
        int [] result = new int[nums.length];
        
        //add 1 to the first index of result, because there is nothing in the  left side of the 1st index in the nums array
        result[0] = 1;
        
        //calculate every numbers product to the left
        for(int i=0; i<nums.length -1; i++){
            result[i+1] = nums[i]*result[i];
        }
        
        //to calculate the runningSum of all the elements to the right
        int runningSum = 1;
        //as we have product of all the elements to the left
        //now calculate product of all the elements to the right
        for(int i= nums.length -1; i>0; i--){
            runningSum *= nums[i];
            result[i-1] = runningSum * result[i-1];
        }
        
        //return result
        return result;
    }
}