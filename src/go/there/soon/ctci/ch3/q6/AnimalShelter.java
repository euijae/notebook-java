package go.there.soon.ctci.ch3.q6;

public class AnimalShelter {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.print();
		Animal c1 = new Animal(AnimalType.CAT, "C1");
		Animal c2 = new Animal(AnimalType.CAT, "C2");
		Animal c3 = new Animal(AnimalType.CAT, "C3");
		Animal d1 = new Animal(AnimalType.DOG, "D1");
		Animal d2 = new Animal(AnimalType.DOG, "D2");
		Animal d3 = new Animal(AnimalType.DOG, "D3");
		
		queue.enqueue(c1);
		queue.enqueue(d1);
		queue.enqueue(c2);
		queue.enqueue(d2);
		queue.enqueue(c3);
		queue.enqueue(d3);
		queue.print();
		queue.dequeueAny();
		queue.print();
		queue.dequeueCat();
		queue.print();
		queue.dequeueDog();
		queue.print();
	}
}