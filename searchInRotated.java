public class searchInRotated {//the is no duplicate element in the array
    public static void main(String args[]){
        int[] arr=  {4,5,6,7,1,2,3};
        int target = 2;
        System.out.println(search(arr,target));

    }
    public static int search(int[] nums, int target){
        int pivot= findPivot(nums);
        //4 cases will be formed
        //case 1 where pivot is equal to the target
        //case 2 where pivot is -1 this means that array is not rotated and thus simple binarysearch will give the result
        //case 3 the target is less that the element at start thus all elements from start till pivot will be greater than the target thus search from pivot+1 till end
        //case 4 the target is greater than the start thus we search from start till pivot-1
        if (pivot==-1){
            return binarySearch(nums,target,0,nums.length);
        }
        if(nums[pivot]== target)
            return pivot;
        if (target >= nums[0])
            return binarySearch(nums,target,0,pivot-1);
        else
            return binarySearch(nums,target,pivot+1,nums.length-1);
    }
public static int findPivot(int[] arr) {
        //pivot divides the array in two ascending order arrays
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        //there are four cases here
        if (mid < end && arr[mid] > arr[mid + 1]) {//arr[mid]<arr[end] checking this because what if at some point the last and the mid element is the same
            //if this happens the mid+1 is out of range
            return mid;
        }
        if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[mid] <= arr[start])
            end = mid - 1;
        else
            start = mid + 1;
    }
    return -1;
}
    public static int binarySearch(int[] nums , int target, int start, int end){
       // start = 0;
        //end = nums.length-1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] < target){
                start = mid + 1;
            }
            else if (nums[mid]> target){
                end = mid - 1;
            }
            else
                return mid;
        }
        return -1;
    }
}