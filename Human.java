package org.example.battle_royale;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Constructor class for Human objects.
 * Humans have a name, health, strength, armor, and evade stats. 
 * Humans can stab, sap, useCaltrops, or hope (heal).
 * 
 */
public class Human {
    public String name;
    private int health;
    private int strength;
    private int armor;
    private int evasion;
    private int damage;
    ArrayList<String> humanAttacks = new ArrayList<String>();
    ArrayList<String> humanStats = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
   
    public Human(String inputName) {
        name = inputName;
        health = 10;
        strength = 10;
        armor = 0;
        evasion = 5;
        damage = 0;
        humanAttacks.add("stab");
        humanAttacks.add("sap");
        humanAttacks.add("use caltrops");
        humanAttacks.add("hope beyond hope");
    }
    public int stab() {
        damage = strength;
        System.out.println("You stab the enemy for " + damage + " damage.");
        return damage;
    }
    public void sap(){
        System.out.println("You hit the enemy with a sap. You always wondered when that would come in handy...");
        System.out.println("It is easier to avoid its attacks now.");
        evasion = evasion + 2;
    }
    public int useCaltrops() {
        System.out.println("You spread caltrops on the floor. Your enemy may not trip, but he will bleed... and so will you.");
        health = health - 2;
        return strength + 2;
    }
    public void hope() {
        System.out.println("You hope beyond hope that you won't die in this dingy dungeon. Hey, that was alliterative!");
        System.out.println("Anyways, you feel a little better after your hoping session.");
        health = health + 3;
    }
    public void dealDamage(int inputDamage) {
        health = health - inputDamage;
    }
    public int chooseAttack() {
        Scanner scanner = new Scanner(System.in);
        for (String attackMoves : humanAttacks) {
            System.out.println("You can " + attackMoves + ".");
        }
        System.out.println("Choose an attack! Be very specific, though, because computers are like that.");
        String attackChoice = scanner.next();
        if (attackChoice.equals("stab"))
        {
            stab();
            return damage;
        }
        else 
        {
            if (attackChoice.equals("sap"))
            {
                return 0;
            }
            else 
            {
                if (attackChoice.equals("use caltrops"))
                {
                    return 0;
                }
                else 
                {
                    if (attackChoice.equals("hope beyond hope"))
                    {
                        hope();
                        return 0;
                    }
                    else 
                    {
                        System.out.println("Didn't quite catch that...");
                        chooseAttack();
                        return 0;
                    }
                }
            } 
        }
    }
    public int getDamage() {
        return damage;
    }
    public void changeHealth(int inputDamage) {
        int damage = inputDamage;
        damage = damage - (evasion + armor);
        if (damage > 0) 
        {
            health = health - damage;
        }
        else
        {
            System.out.println("You take no damage!");
        }
        System.out.println("Your remaining health is " + health + ".");
    }
    public void levelUp() {
        System.out.println("Also, you've leveled up and become a generally better person. And in the game.");
        health = 10;
        strength = strength + 10;
        evasion = evasion + 3;
        armor = armor + 5;
    }
    public boolean isDead() {
        if (health > 0) 
        {
            return false;
        }
        else
        {
            return true;
        }
    }     
}