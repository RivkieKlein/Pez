package pez;
import java.util.Stack;

import java.util.Random;
import java.util.Scanner;

public class EatFromDispenser {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Stack<PezColors> pez = new Stack<PezColors>();
		Stack<PezColors> temp = new Stack<PezColors>();
		char cont;
		// fill up a pez dispenser with 12 candies
		do {
			fill(pez);
			System.out.println("Lets see how to eat pez if you're a picky person who only likes yellow");
			eating(pez, temp);
			display(pez);
			System.out.println(
					"Do you want to eat more pez? Maybe this time you'll be lucky and get more yellow candies. (y or n)");
			cont = keyboard.nextLine().toUpperCase().charAt(0);

		} while (cont == 'Y');
		System.out.println("Happy Pez-dispenser collecting");
	}

	// fills up new pez dispenser with random variety of pez candies
	public static void fill(Stack<PezColors> pez) {
		// random object with a range corresponding to numbers of pez color items enum
		Random rand = new Random();

		// fills with 12 candies from color enum
		for (int counter = 0; counter < 12; counter++) {
			PezColors pezc = PezColors.valueOf("a" + Integer.toString(rand.nextInt(4)));
			pez.push(pezc);
		}
	}

	// shows how pez will be eaten by displaying each candy
	public static void eating(Stack<PezColors> pez, Stack<PezColors> temp) {

		while (!pez.isEmpty()) {

			if (pez.peek().getColor().equals("yellow")) {
				System.out.print(pez.peek().getColor());
				System.out.println("! Eating this one!");
				pez.pop();

			} else {
				PezColors temps = pez.pop();
				System.out.println(temps.getColor() + ". Not my taste");
				temp.push(temps);
			}

		}

		while (!temp.isEmpty()) {
			pez.push(temp.peek());
			temp.pop();
		}
	}

	// shows new pez after the yellows have been eaten
	public static void display(Stack<PezColors> pez) {
		System.out.println("Now give this yellow-less pez to a friend. You wouldn't want it to go to waste!");
		System.out.println("And look its still in the same order:");
		while (!pez.isEmpty()) {
			System.out.println(pez.peek().getColor());
			pez.pop();
		}

	}
}
