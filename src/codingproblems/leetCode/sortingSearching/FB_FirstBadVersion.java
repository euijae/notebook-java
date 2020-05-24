package codingproblems.leetCode.sortingSearching;

public class FB_FirstBadVersion {

	public static void main(String[] args) {
		int a = 1063376696;
		int b = 2126753390;
		
		if(Integer.MAX_VALUE - a - b < 0)
			System.out.println("yes this is out of scope");
		
		FB_FirstBadVersion fbv = new FB_FirstBadVersion();
		fbv.test();
	}
	
	public void test() {
		Solution s = new Solution();
		int firstBad = s.firstBadVersion(2126753390);
		System.out.println("firstBad: " + firstBad);
	}
	
	public class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	        int firstBad = versionCheckerHelper(n, 1, n);
	        return firstBad;
	    }
	    
	    public int versionCheckerHelper(int n, int left, int right) {
	        if(left > right || left > n || left < 1 || right > n || right < 1)
	            return -1;
	        
	        int mid = (left+right)/2;
	        
	        if(Integer.MAX_VALUE - right - left < 0) {
	        		mid = (left / 2) + (right / 2);
	        }
	        
	        System.out.println(">> left: " + left + ", mid: " + mid + ", right: " + right);
	        
	        if(isBadVersion(mid)) {
	            if(mid == 1)
	                return mid;
	            else {
	                if(!isBadVersion(mid-1))
	                    return mid;
	                
	                return versionCheckerHelper(n, left, mid-1);
	            }
	        } else {
	            if(isBadVersion(mid+1))
	                return mid+1;
	            
	            return versionCheckerHelper(n, mid+1, right);
	        }
	    }
	}
	
	public abstract class VersionControl {
		int size = 2126753390; //4;
		int v = 1702766719; //4;

		boolean isBadVersion(int n) {
			if(n > size || n < 1)
				return false;
			
			return (n >= v);
		}
	}
}
