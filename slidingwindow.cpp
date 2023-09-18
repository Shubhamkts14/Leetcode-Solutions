#include <bits/stdc++.h>

using namespace std;
class Solution {
public:
    vector<int> maxSlidingWindow(std::vector<int>& nums, int k) {
        deque<int> dq;
        vector<int> ans;
        
        for (int i = 0; i < nums.size(); i++) {
            // Remove elements that are out of the current window
            if (!dq.empty() && dq.front() == i - k) {
                dq.pop_front();
            }
            
            // Remove elements from the back of the deque that are smaller than the current element
            while (!dq.empty() && nums[dq.back()] < nums[i]) {
                dq.pop_back();
            }
            
            // Add the current element's index to the deque
            dq.push_back(i);
            
            // If we have processed at least k elements, add the maximum of the current window to the result
            if (i >= k - 1) {
                ans.push_back(nums[dq.front()]);
            }
        }
        
        return ans;
    }
};
int main() {
    Solution solution;
    std::vector<int> nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    std::vector<int> result = solution.maxSlidingWindow(nums, k);

    // Print the result
    std::cout << "Maximum elements in sliding windows of size " << k << ": ";
    for (int num : result) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}






