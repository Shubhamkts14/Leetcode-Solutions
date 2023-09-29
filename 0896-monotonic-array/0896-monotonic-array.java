class Solution {
    public boolean isMonotonic(int[] nums) {
       if(nums.length < 2) return true;

       int dir = 0 ;
       for(int i = 1 ;i <nums.length;i++){
           if(nums[i]>nums[i-1]){
               if(dir == 0) dir = 1;
               else if(dir == -1) return false;
           }
           if(nums[i]<nums[i-1]){
               if(dir == 0) dir = -1;
               else if(dir == 1) return false;
           }
       }
       return true;
    }
}