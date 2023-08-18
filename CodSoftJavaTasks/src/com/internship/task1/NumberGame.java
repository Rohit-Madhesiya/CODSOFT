package com.internship.task1;
import java.util.*;
public class NumberGame {
	public static void playing() {
		Scanner in=new Scanner(System.in);
		System.out.println("----------NUMBER GUESSING GAME----------\n\n");
		int randomNumber=(int)(100*Math.random())+1;
		int guessCount=0;
		int guessedNumber;
		while(true) {
			System.out.println("NOTE: You have Six Chance to Guess the Number");
			System.out.print("Guess the Number: ");
			guessedNumber=in.nextInt();
			++guessCount;
			if(guessedNumber==randomNumber) {
				System.out.println("------Congratulations!!!------");
				System.out.println("You have guessed it in "+guessCount+" guesses!");
				System.out.println("My number was "+randomNumber+" :)");
				break;
			}
			if(guessCount==6) {
				System.out.println("You didn't get the number in Six Guesses:(");
				System.out.println("You have Loosed the Game!!!");
				System.out.println("My Number was "+randomNumber);
				break;
			}
			if(guessedNumber<randomNumber) 
				System.out.println("That is too Low :(");
			else if(guessedNumber>randomNumber) 
				System.out.println("That is too High :(");
			if((randomNumber-guessedNumber)<10)
				System.out.println("HINT: You are too closed ;)");
			System.out.println("Try Again!!");
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int playFlag;
		do {
			playing();
			System.out.println("Do you want to Play Again? (1->YES/0->NO): ");
			playFlag=scan.nextInt();
		}while(playFlag==1);
		System.out.println("Thankyou for playing!!");
		System.out.println("Have Fun, GoodBye!!!");
		scan.close();
	}

}
