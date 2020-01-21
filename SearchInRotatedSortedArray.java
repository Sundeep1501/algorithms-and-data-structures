class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        } else if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            } else {
                return -1;
            }
        }
        
        int pivot = findPivot(nums,0,nums.length-1);
        int index = search(nums, pivot, nums.length-1, target);
        if(index == -1){
            index = search(nums, 0, pivot, target);
        }
        
        return index;
    }
    
    int search(int[] nums, int start, int end, int target){
        int mid = start + ((end-start)/2);
        System.out.println("search "+start+":"+mid+":"+end);
        if (start>end){
            return -1;
        } else if(nums[mid] == target){
            return mid;
        } else if(target < nums[mid]){
            return search(nums, start, mid-1, target);
        } else {
            return search(nums, mid+1,end, target);
        }
    }
    
    int findPivot(int[] nums, int start, int end){
        int mid = start + ((end-start)/2);
        System.out.println("Pivot "+start+":"+mid+":"+end);
        if(start+1 == end){
            if(nums[start]>nums[end]){
                return end;
            } else{
                return start;
            }
        }if(nums[mid] < nums[start]){
            // pivot is at left
            return findPivot(nums,start,mid);
        } else if(nums[mid]>nums[end]){
            // pivot is at right
            return findPivot(nums, mid, end);
        } else {
            return 0;
        }
    }
}







class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target == nums[i]){
                return i;
            } else if((i+1)<nums.length && nums[i]> nums[i+1]){
                // found pivot
                return search(nums, i+1, nums.length-1, target);        
            }
        }
        return -1;
    }
    
    int search(int[] nums, int start, int end, int target){
        int mid = start + ((end-start)/2);
        System.out.println(start+":"+mid+":"+end);
        if (start>end){
            return -1;
        } else if(nums[mid] == target){
            return mid;
        } else if(target < nums[mid]){
            return search(nums, start, mid-1, target);
        } else {
            return search(nums, mid+1,end, target);
        }
    }
}
