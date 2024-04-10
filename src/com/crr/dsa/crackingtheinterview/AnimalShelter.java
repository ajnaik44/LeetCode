package com.crr.dsa.crackingtheinterview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class AnimalShelter {
	Queue<Integer> dog = new LinkedList<>();
	Queue<Integer> cat = new LinkedList<>();
	public enum Animal{
		Dog(1),
		Cat(2);
		private final int value;
		Animal(int value){
			this.value = value;
		}	
		public int getValue() {
	        return value;
	    }
	}
	
	public void enqueue(Enum animal,int value)
	{
		if(Animal.Cat==animal)
		{
			cat.add(value);
		}else {
			dog.add(value);
		}
	}
	public int dequeueAny()
	{
		Random random = new Random();
        int randomIndex = random.nextInt(Animal.values().length);

        // Get the enum constant at the random index
        Animal randomAnimal = Animal.values()[randomIndex];
        
        if(randomAnimal==Animal.Cat)
        {
        	return cat.poll();
        }
        else {
        	return dog.poll();
        }
	}

	public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(Animal.Cat, 1);
        animalShelter.enqueue(Animal.Cat, 3);
        animalShelter.enqueue(Animal.Cat, 5);
        animalShelter.enqueue(Animal.Cat, 6);
        animalShelter.enqueue(Animal.Dog, 2);
        animalShelter.enqueue(Animal.Dog, 8);
        animalShelter.enqueue(Animal.Dog, 9);
        
        animalShelter.enqueue(Animal.Dog, 4);

        System.out.println("Dequeued animal: " + animalShelter.dequeueAny());
        System.out.println("Dequeued animal: " + animalShelter.dequeueAny());
        System.out.println("Dequeued animal: " + animalShelter.dequeueAny());
        System.out.println("Dequeued animal: " + animalShelter.dequeueAny());
        System.out.println("Dequeued animal: " + animalShelter.dequeueAny());
    }
	
}
