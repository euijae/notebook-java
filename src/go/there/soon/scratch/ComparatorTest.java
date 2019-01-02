package go.there.soon.scratch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	public static void main(String args[]) {
		ComparatorTest o = new ComparatorTest();
        o.test();
    }
	
    public void test() {
        Person p1 = new Person("john", "doe", 33);
        Person p2 = new Person("smith", "black", 9);
        Person p3 = new Person("diana", "yale", 12);
        
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        
        for(int i = 0; i < 4; i++) {
            print(persons, i);
            System.out.println("---------");
        }
    }
    
    public void print(List<Person> persons, int order) {
        if(order == 1) {
            Collections.sort(persons, new SortPersonByLastname());
        } else if(order == 2) {
            Collections.sort(persons, new SortPersonByFirstname());
        } else if(order == 3) {
            Collections.sort(persons, new SortPersonByAge());
        } 
        
        System.out.println(getTitle(order));
        
        for(Person person : persons) {
            System.out.println(person.toString());
        }
    } 
    
    public String getTitle(int order) {
        if(order == 1) {
            return "[Sory by last name]";
        } else if(order == 2) {
            return "[Sory by first name]";
        } else if(order == 3) {
            return "[Sory by age]";
        } else {
            return "[Initial]";
        }
    }
    
    class SortPersonByFirstname implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.firstname.compareTo(p2.firstname);
        }
    }
    
    class SortPersonByLastname implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.lastname.compareTo(p2.lastname);
        }
    }
    
    class SortPersonByAge implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.age - p2.age;
        }
    }
    
    class Person {
        String firstname;
        String lastname;
        int age;
        
        public Person(String fname, String lname, int a) {
            firstname = fname;
            lastname = lname;
            age = a;
        }
        
        public String toString() {
            return "[first = " + firstname + ", last = " + lastname + ", age = " + age + "]"; 
        }
    }

}
