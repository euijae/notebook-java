package codingproblems.ctci.ch3.q6;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter2 {

	public static void main(String[] args) {
		AnimalShelter2 as2 = new AnimalShelter2();
		as2.test();
	}
	
	private Queue<Animal> queue;
	
	public AnimalShelter2() {
		this.queue = new LinkedList<>();
	}
	
	public void test() {
		Animal c1 = new Animal(AnimalType.CAT, "C1");
		Animal c2 = new Animal(AnimalType.CAT, "C2");
		Animal c3 = new Animal(AnimalType.CAT, "C3");
		Animal d1 = new Animal(AnimalType.DOG, "D1");
		Animal d2 = new Animal(AnimalType.DOG, "D2");
		Animal d3 = new Animal(AnimalType.DOG, "D3");
	
		enqueue(c1);
		enqueue(d1);
		enqueue(c2);
		enqueue(d2);
		enqueue(c3);
		enqueue(d3);
		print("6 enqueue: ");
		dequeueAny();
		print("dequeueAny: ");
		dequeueCat();
		print("dequeueCat: ");
		dequeueDog();
		print("dequeueDog: ");
	}
	
	public void enqueue(Animal a) {
		queue.add(a);
	}
	
	public Animal dequeueAny() {
		return queue.remove();
	}
	
	public Animal dequeueCat() {
		return removeFirst(AnimalType.CAT);
	}
	
	public Animal dequeueDog() {
		return removeFirst(AnimalType.DOG);
	}
	
	public Animal removeFirst(AnimalType type) {
		for(Animal a : queue) {
			if(a.type.compareTo(type) == 0) {
				queue.remove(a);
				return a;
			}
		}
		
		return null;
	}
	
	public void print(String description) {
		StringBuilder sb = new StringBuilder(description);
		for(Animal a : queue)
			sb.append(a.name + " ");
		
		System.out.println(sb.toString());
	}
}
