package codingproblems.ctci.ch10.q3;

public class SearchInRotatedArray2 {
    public static void main(String [] args) {
        int [] arr = {15,16,19,20,25,1,3,4,5,7,10,14};

        for(int target : arr) {
            int index = rotatedArray(arr, target);
            System.out.printf("the target(%d) is found at %d\n", target, index);
        }
    }

    public static int rotatedArray(int [] arr, int target) {
        return rotatedArray(arr, target, 0, arr.length-1);
    }

    public static int rotatedArray(int [] arr, int target, int left, int right) {
        if(left > right)
            return -1;

        int mid = (left + right) / 2;

        if(arr[mid] == target)
            return mid;

        if(arr[left] < arr[mid]) {
            if(arr[left] <= target && target < arr[mid]) {
                return rotatedArray(arr, target, left, mid-1);
            } else {
                return rotatedArray(arr, target, mid+1, right);
            }
        } else if(arr[mid] < arr[right]) {
            if(arr[mid] < target && target <= arr[right]) {
                return rotatedArray(arr, target, mid+1, right);
            } else {
                return rotatedArray(arr, target, left, mid-1);
            }
        } else if(arr[left] == arr[mid]) {
            if(arr[mid] != arr[right]) {
                return rotatedArray(arr, target, mid+1, right);
            } else {
                int result = rotatedArray(arr, target, left, mid-1);
                if(result == -1) {
                    return rotatedArray(arr, target, mid+1, right);
                } else {
                    return result;
                }
            }
        }

        return -1;
    }
}
