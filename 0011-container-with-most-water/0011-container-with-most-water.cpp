class Solution {
public:
    int maxArea(vector<int>& height) {
    
    int lb=0,ub=height.size()-1,ans=0,water;  
        
        
    while(lb<ub){
        
        water=(ub-lb)*(min(height[ub],height[lb])); 
        
        if(ans<water)       
            ans=water;
        
        if(height[ub]>height[lb]) 
            lb++;
        
        
        else            
            ub--;
        }
        
        
        return ans;
    }
};