package org.example.battle_royale;

import java.util.Scanner;

public class World {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Acorath acorathOne = new Acorath();
		System.out.println("Welcome to Battle Royale! We didn't pay for the trademark!");
		System.out.println("Expecting lawsuit from Koushun Takami in 5... 4... 3... 2... 1...");
		System.out.println("But in the meantime, would you like to murder some poor, defenseless, fantasy creatures in a dungeon?");
		System.out.println("y/n");
		String ready = scanner.next();
		System.out.println(ready);
		//If "n", then gameOver(); if "y", then it asks for a name and starts the acorath fight; if something else, it closes the program
		if (ready.equals("n"))
		{
			noGame();
		}
		else
		{
			if (ready.equals("y"))
			{
				System.out.println("What is your name?");
				String name = scanner.next();
				Human player = new Human(name);
				acorathFight(player, acorathOne);
			}
			else
			{
				System.out.println("Oops, the dungeon *ahem* collapsed!");
                System.out.println("Please try again!");
                System.exit(2);
			}
		}
	}
	public static void acorathFight(Human player, Acorath acorathOne) {
	    Scanner scanner = new Scanner(System.in);
	    Pigman pigmanOne = new Pigman();
	    System.out.println("You are fighting an acorath. It has " + acorathOne.getHealth() + " health remaining.");
	    System.out.println("An acorath is a small, humanoid, rose-thingy. Yeah, we don't really understand it either.");
	    acorathOne.showStats();
	    //while the acorath's health is above 0, the fight continues
	    while (acorathOne.isDead() == false)
	    {
	    	player.chooseAttack();
	    	acorathOne.changeHealth(player.getDamage());
	    	acorathOne.chooseAttack();
	    	player.changeHealth(acorathOne.getDamage());
	    	if (player.isDead() == true)
	    	{
	    		gameOver();
	    	}
	    }
	    System.out.println("Congrats, you killed it!");
	    player.levelUp();
	    System.out.println("On to the next enemy...");
	    pigmanFight(player, pigmanOne);
	}
	public static void pigmanFight(Human player, Pigman pigmanOne) {
		Scanner scanner = new Scanner(System.in);
		LutefiskPaladin paladinOne = new LutefiskPaladin();
		System.out.println("You are fighting a pigman. It has " + pigmanOne.getHealth() + " health remaining.");
		System.out.println("A pigman is part man, part pig. We don't understand how it works either.");
		pigmanOne.showStats();
		//while the pigman's health is above 0, the fight continues
		while (pigmanOne.isDead() == false)
		{
			player.chooseAttack();
			pigmanOne.changeHealth(player.getDamage());
			pigmanOne.chooseAttack();
			player.changeHealth(pigmanOne.getDamage());
			if (player.isDead() == true)
			{
				gameOver();
			}
		}
		System.out.println("Congrats, you killed it!");
		player.levelUp();
		System.out.println("On to the next enemy...");
		paladinFight(player, paladinOne);
	}
	public static void paladinFight(Human player, LutefiskPaladin paladinOne) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("You are fighting a paladin of the Lutefisk God. It has " + paladinOne.getHealth() + " health remaining.");
		System.out.println("It's a fishman and devotee of the Lutefisk God. It's mumbling something about a portal and \"killing the eyebrowed one\".");
		System.out.println("You feel like you're missing a reference here.");
		paladinOne.showStats();
		//while the acorath's health is above 0, the fight continues
		while (paladinOne.isDead() == false)
		{
			player.chooseAttack();
			paladinOne.changeHealth(player.getDamage());
			paladinOne.chooseAttack();
			player.changeHealth(paladinOne.getDamage());
			if (player.isDead() == true)
			{
				gameOver();
			}
		}
		System.out.println("Congrats, you killed it!");
		//player.levelUp;
		System.out.println("On to the next enemy...");
		paladinFight(player, paladinOne);
	}
	public static void noGame() {
		System.out.println("Well, that's disappointing.");
		System.out.println("I think you're wanted down in legal, anyways...");
		System.exit(0);
	}
	public static void gameOver() {
		System.out.println("Game over, man. Game over.");
		System.exit(2);
	}
}
