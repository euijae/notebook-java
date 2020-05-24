package datastructures.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class JavaSort1 {

	public static void main(String[] args) {
		//sort an array of strings using natural ordering
		String[] words1 = {"Fred","bob","Tom","Mark","john","Steve"};
		
		Arrays.sort(words1);
		System.out.println(Arrays.toString(words1));
		
		String[] words2 = {"Fred","bob","Tom","Mark","john","Steve"};
		Arrays.sort(words2, new Comp1());
		System.out.println(Arrays.toString(words2));
		
		//sort in reverse order
		String[] words3 = {"Fred","Bob","Tom","Mark","John","Steve"};
		Arrays.sort(words3, new Comp2());
		System.out.println(Arrays.toString(words3));

		//sort by emails
		String[] words4 = {"Fred@cmu.edu","Bob@yahoo.com","Tom@gmail.com","Mark@ucla.edu","John@pit.edu","Steve@microsoft.com"};
		Arrays.sort(words4, new Comp3());
		System.out.println(Arrays.toString(words4));
	}
	
	public static String print(String [] arr) {
		if(arr == null)
			return "null";
		
		int iMax = arr.length - 1;
		
		if(iMax == -1) {
			return "[]";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1)
				sb.append(arr[i] + "]").toString();
			else 
				sb.append(arr[i] + ", ");
		}
		
		return sb.toString();
	}
}

class Comp1 implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}
	
}

class Comp2 implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
}

class Comp3 implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		String str1 = o1.substring(o1.indexOf("@"));
		String str2 = o2.substring(o2.indexOf("@"));
		System.out.println("indexOf: " + o1.indexOf("@") + ", str1: " + str1);
		System.out.println("indexOf: " + o2.indexOf("@") + ", str2: " + str2);
		
		return str1.compareToIgnoreCase(str2);
	}
	
}