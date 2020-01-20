class Solution {
    public int search(int[] nums, int target) {
        return search(0, nums.length-1,nums, target);
    }
    
    int search(int start, int end, int[] nums, int target){
        int midIndex = start+((end-start+1)/2);
        if(start > end){
            return -1;
        } else if(nums[midIndex] == target){
            return midIndex;
        } else if(nums[midIndex] < target){
            return search(midIndex+1, end, nums, target);
        } else {
            return search(start, midIndex-1, nums, target);
        } 
    }
}
