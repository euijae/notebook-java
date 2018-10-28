package go.there.soon.ctci.ch3.q6;

import java.util.LinkedList;

import go.there.soon.ctci.ch3.q6.animal.Animal;
import go.there.soon.ctci.ch3.q6.animal.Cat;
import go.there.soon.ctci.ch3.q6.animal.Dog;

public class AnimalShelter3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private LinkedList<Cat> cats = new LinkedList<>();
	private LinkedList<Dog> dogs = new LinkedList<>();
	private static int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		
		if(a instanceof Cat) {
			cats.add((Cat) a);
		} else {
			dogs.add((Dog) a);
		}
	}
	
	public Animal dequeueAny() {
		
		if(cats.size() == 0) 
			return dogs.poll();
		else if(dogs.size() == 0)
			return cats.poll();
		else {
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			
			if(dog.isOlderThan(cat)) {
				return dogs.poll();
			} else {
				return cats.poll();
			}
		}
	}
	
	public Animal dequeueCat() {
		return cats.poll();
	}
	
	public Animal dequeueDog() {
		return dogs.poll();
	}
}