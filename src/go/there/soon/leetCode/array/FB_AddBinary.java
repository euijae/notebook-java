package go.there.soon.leetCode.array;

public class FB_AddBinary {

	public static void main(String[] args) {
		FB_AddBinary s = new FB_AddBinary();
		s.test();
	}
	
	public void test() {
		String result = addBinary("1", "111");
		System.out.println(result);
	}

    public String addBinary(String a, String b) {
    	String l = a.length() > b.length() ? a : b;
    	String s = a.length() > b.length() ? b : a;
    	
    	int p1 = l.length()-1;
        int p2 = s.length()-1;
        
        StringBuilder sb = new StringBuilder();
        boolean append = false;
        
        while(p1 >= 0 || p2 >= 0) {
        	char c1 = l.charAt(p1);
        	
        	if(p1 >= 0 && p2 >= 0) {
        		
        		char c2 = s.charAt(p2);
        		
        		System.out.printf("c1: %c, c2: %c, append: %b\n", c1, c2, append);
        		
        		if(append) {
        			sb.insert(0, c1 == c2 ? '1' : '0');
        			append = (c1 == '1' || c2 == '1');
        		} else {
        			sb.insert(0, c1 == c2 ? '0' : '1');
        			append = (c1 == '1' && c2 == '1');
        		}
	        	
	        	p2--;
        	} else {
        		if(c1 == '1') {
            		sb.insert(0, append ? '0' : '1');
            		append &= true;
            	} else {
            		sb.insert(0, append ? '1' : '0');
            		append = false;
            	}
        	}
        	
        	p1--;
        }
        
        
        if(append) {
        	sb.insert(0, '1');
        }
        
        return sb.toString();
    }
}
