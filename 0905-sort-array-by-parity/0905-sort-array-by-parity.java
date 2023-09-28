class Solution {
    public int[] sortArrayByParity(int[] nums) {
       int index=0;
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]%2==0)
           {
               int x=nums[index];
               nums[index]=nums[i];
               index++;
               nums[i]=x;
           }

       }
       return nums;
    }
}