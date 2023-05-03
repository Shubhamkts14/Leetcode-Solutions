class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Add elements from nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }
        
        List<Integer> list1 = new ArrayList<>(set1);
        List<Integer> list2 = new ArrayList<>(set2);
        
        // Find distinct elements in nums1
        list1.removeAll(set2);
        
        // Find distinct elements in nums2
        list2.removeAll(set1);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        
        return result;
    }
}
