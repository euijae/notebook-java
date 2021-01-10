package codingproblems.ctci.ch3.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructures.stack.StackException;

public class StackOfPlates {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		
		SetOfStacks<Integer> sos = new SetOfStacks<>();
		sos.push(1);
		sos.push(2);
		sos.push(3);
		System.out.println(sos.getSize());
		sos.push(4);
		sos.push(5);
		sos.push(6);
		System.out.println(sos.getSize());
		sos.pop();
		sos.pop();
		sos.pop();
		System.out.println(sos.getSize());
		sos.pop();
		sos.pop();
		sos.pop();
		System.out.println(sos.getSize());
		sos.pop();
	}

}

class SetOfStacks<T> {
	int capacity = 3;
	int sizeOfStacks;
	List<Stack<T>> setOfStacks;
	
	public SetOfStacks() {
		setOfStacks = new ArrayList<>();
		setOfStacks.add(new Stack<>());
		sizeOfStacks = 1;
	}
	
	public void push(T item) {
		int i = sizeOfStacks;
		if(i == 0) {
			Stack<T> s = new Stack<>();
			s.push(item);
			setOfStacks.add(s);
			sizeOfStacks = 1;
		} else {
			if(setOfStacks.get(i-1).size() == capacity) {
				Stack<T> s = new Stack<>();
				s.push(item);
				setOfStacks.add(s);
				sizeOfStacks++;
			} else {
				setOfStacks.get(i-1).push(item);
			}
		}
	}
	
	public T pop() {
		if(sizeOfStacks == 0) 
			throw new StackException();
		
		T data = setOfStacks.get(sizeOfStacks-1).pop();
		if(setOfStacks.get(sizeOfStacks-1).size() == 0) {
			setOfStacks.remove(sizeOfStacks-1);
			sizeOfStacks--;
		}
		
		return data;
	}
	
	public int getSize() {
		return sizeOfStacks;
	}
}






