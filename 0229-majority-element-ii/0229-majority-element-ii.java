class Solution {
    public List<Integer> majorityElement(int[] nums) {
      ArrayList <Integer> ans=new ArrayList<>();
      int n=nums.length; 
      int c=1;
      Arrays.sort(nums);
   
      for(int i=0;i<n-1;i++){
        
          if(nums[i]==nums[i+1]){
              c++;
              
          }
          else{
              if(c>n/3){
              ans.add(nums[i]);
             } 
              c=1;
          }
        
      }
       if(c>n/3){
           ans.add(nums[n-1]);
       }

      return ans;
    }
}