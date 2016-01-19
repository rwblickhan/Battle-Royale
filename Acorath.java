package org.example.battle_royale;

import java.util.ArrayList;

/**
 * Constructor class for Acorath classes.
 * Acoraths have a name, health, strength, evade, and photosynthesis.
 * Acoraths can prick, sunlightHeal, use sleepPowder, or give an exciting legal disclaimer!
 * 
 * Russell Blickhan
 * 9/21/12
 */
public class Acorath
{
    public String name;
    private int health;
    private int strength;
    private int evasion;
    private int photosynthesis;
    private int damage;
    ArrayList<String> acorathAttacks = new ArrayList<String>();
    
    public Acorath() {
        name = "acorath";
        health = 10;
        strength = 10;
        evasion = 5;
        photosynthesis = 5;
        damage = 0;
        acorathAttacks.add("prick");
        acorathAttacks.add("give an exciting legal disclaimer");
        acorathAttacks.add("use sleeping powder");
    }
    public void prick() {
        System.out.println("The acorath attempts to stab you with its points.");
        damage = strength;
    }
    public void sunlightHeal() {
        System.out.println("The acorath heals itself through the magic of a high school biology class: photosynthesis!");
        damage = 0;
        health = health + photosynthesis;
        photosynthesis = photosynthesis - 1;
    }
    public void sleepPowder() {
        System.out.println("The acorath sprays you with a sleeping powder.");
        System.out.println("It can evade your attacks easier now.");
        damage = 0;
        evasion = evasion + 2;
    }
    public void disclaimer() {
        System.out.println("Our lawyers would like you to know that the developer of this program is not involved in any way with the Pokemon series or their developers, GameFreak.");
        System.out.println("Also, acoraths were not inspired by Roselia or Roserade from the above AT ALL.");
        damage = 0;
    }
    public void showAttacks() {
        for (String attackMoves : acorathAttacks) {
            System.out.println("The acorath can " + attackMoves + ".");
        }
    }
    public void showStats() {
            System.out.println("The acorath's health is " + health + ".");
            System.out.println("The acorath's strength is " + strength + ".");
            System.out.println("The acorath's evasion is " + evasion + ".");
            System.out.println("The acorath's photosynthetic ability is " + photosynthesis + ".");
    }
    public void chooseAttack() {
        if (health <= 5) {
            sunlightHeal();
        }
        else 
        {
            if (health == 10) {
                disclaimer();
            }
            else 
            {
                if (evasion < 10)
                {
                    sleepPowder();
                }
                else
                {
                    prick();
                }
            }
        }
    }
    public void changeHealth(int inputDamage) {
        int damage = inputDamage;
        damage = damage - evasion;
        if (damage > 0) 
        {
            health = health - damage;
        }
        else
        {
            System.out.println("It deals no damage!");
        }
        System.out.println("The acorath's remaining health is " + health + ".");
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
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