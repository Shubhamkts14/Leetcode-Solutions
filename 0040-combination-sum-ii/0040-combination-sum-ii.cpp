class Solution {
    private:
        vector<vector<int>>ans;
public:
    void check(vector<int>&candi,int tar,int n,int index,vector<int>&test){
        if(tar==0){
            ans.push_back(test);
            return;
        }
        for(int i=index;i<n;i++)
        {
            if(i>index && candi[i]==candi[i-1])
                continue;
            if(candi[i]>tar)
                break;
            test.push_back(candi[i]);    
            check(candi,tar-candi[i],n,i+1,test);
            test.pop_back();    
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candi, int tar) {
        vector<int>test;
        int n=candi.size();
        sort(candi.begin(),candi.end());        
        check(candi,tar,n,0,test);
        return ans;
    }
};