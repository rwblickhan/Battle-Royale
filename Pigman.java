package org.example.battle_royale;

import java.util.ArrayList;

/**
 * Constructor class for Pigman objects.
 * Pigmen have a name, health, strength, armor, and fat stats.
 * Pigmen can fatten themselves up, gore you on their adorable little tusks, snort menacingly, or 'phone a friend on one of those newfangled telegraph things.
 * 
 * Russell Blickhan
 * 9/24
 */
public class Pigman
{
    public String name;
    private int health;
    private int strength;
    private int armor;
    private int fat;
    private int damage;
    private ArrayList<String> pigmanAttacks = new ArrayList<String>();
    
    public Pigman()
    {
        name = "pigman";
        health = 15;
        strength = 15;
        armor = 10;
        fat = 0;
        damage = 0;
        pigmanAttacks.add("snort");
        pigmanAttacks.add("gore");
    }
    public void attack() {
        if (strength <= 5) 
        {
                phoneAFriend();
        }
            else 
            {
                if (health <= 5) {
                    fatteningUp();
                }
                else 
                {
                }
            }
        }
    public void fatteningUp() {
        //adds to health, but also adds to bacon, which will decrease strength
        damage = 0;
        fat = fat + 1;
        health = health + 5;
        strength = strength - fat;
        System.out.println("The pigman porks out. Although some damage is healed, he finds it harder to fight.");
        System.out.println("The pigman's current health is " + health + ", his current fat level is " + fat + ", and his current strength is " + strength + ".");
    }
    public void gore() {
        //this is the pigman's "basic" attack
        System.out.println("The pigman gores you with those adorable little tusks of his.");
        damage = strength;
    }
    public void snort() {
        //demoralizes player, making them skip their turn
        System.out.println("The pigman snorts menacingly at you. The psychological scars will be with you for the rest of your life.");
        damage = 0;
    }
    public void phoneAFriend() {
        //this will have a list of different attacks, with a unique description, even though the mechanics themselves are the same
        System.out.println("The pigman uses one of those newfangled telegraph things, which was installed in the dungeon for some reason.");
        System.out.println("Of course, this second pigman can't hurt you (that's not how telegraphs work!), but he can encourage this little guy.");
        damage = 0;
        strength = strength + 3;
        System.out.println("The pigman's current strength is " + strength + ".");
    }
    public void showAttacks() {
        for (String attackMoves : pigmanAttacks) {
            System.out.println("The pigman can " + attackMoves + ".");
        }
    }
    public void showStats() {
            System.out.println("The pigman's health is " + health + ".");
            System.out.println("The pigman's strength is " + strength + ".");
            System.out.println("The pigman's armor is " + armor + ".");
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    public void chooseAttack() {
        
    }
    public void changeHealth(int inputDamage) {
        int damage = inputDamage;
        damage = damage - armor;
        if (damage > 0) 
        {
            health = health - damage;
            System.out.println("The pigman's remaining health is " + health + ".");
        }
        else
        {
            System.out.println("It does no damage.");
        }
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
