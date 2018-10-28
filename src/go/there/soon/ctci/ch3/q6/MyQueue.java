package go.there.soon.ctci.ch3.q6;

import java.util.EmptyStackException;

enum AnimalType {
	DOG, CAT;
}

public class MyQueue {
	QueueNode<Animal> first;
	QueueNode<Animal> last;
	
	public void enqueue(Animal a) {
		QueueNode<Animal> n = new QueueNode<>(a);
		if(last != null) {
			last.next = n;
		}
		
		last = n;
		
		if(first == null)
			first = last;
	}
	
	private Animal dequeue() {
		Animal a = first.animal;
		first = first.next;
		if(first == null) 
			last = null;
		return a;
	}
	
	public Animal dequeueAny() {
		if(first == null) throw new EmptyStackException();
		return dequeue();
	}
	
	public Animal dequeueDog() {
		if(first == null) throw new EmptyStackException();
		if(first.animal.type == AnimalType.DOG) {
			return dequeue();
		} else {
			return getFirstOne(0);
		}
	}
	
	public Animal dequeueCat() {
		if(first == null) throw new EmptyStackException();
		if(first.animal.type == AnimalType.CAT) {
			return dequeue();
		} else {
			return getFirstOne(1);
		}
	}
	
	public Animal getFirstOne(int preference) {
		AnimalType type = (preference == 0) ? AnimalType.DOG :AnimalType.CAT;
		
		QueueNode<Animal> temp = first;
		
		while(temp.next != null && temp.next.animal.type.compareTo(type) != 0)
			temp = temp.next;
		
		QueueNode<Animal> firstOne = temp.next;
		temp.next = temp.next.next;
		return firstOne.animal;
	}
	
	public void print() {
		QueueNode<Animal> temp = first;
		
		while(temp != null) {
			System.out.print(temp.animal.name + " ");
			temp = temp.next;
		}
		
		System.out.println((first == null) ? "empty pointer" : "");
	}
}

class QueueNode<T> {
	QueueNode<T> next;
	T animal;
	public QueueNode(T animal) {
		this.animal = animal;
		this.next   = null;
	}
}

class Animal {
	String name;
	AnimalType type;
	public Animal(AnimalType type, String name) {
		this.type = type;
		this.name = name;
	}
}