package org.example.battle_royale;

/**
 * Cosntructor class for LutefiskPaladin objects.
 * LutefiskPaladins have a name, health, armor, evade, and squelchiness (yum, squelchy squelchy lutefisk!).
 * LutefiskPaladins can convert, squelch, fishSlap, and stab.
 * 
 * Russell Blickhan
 * 9/24
 */
public class LutefiskPaladin {
    public String name;
    private int health;
    private int squelchiness;
    private int armor;
    private int evasion;
    private int damage;
    
    public LutefiskPaladin() {
        name = "paladin of the Lutefisk God";
        health = 25;
        squelchiness = 20;
        armor = 25;
        evasion = 5;
    }
    public void nameFight() {
        System.out.println("You are fighting a " + name + ".");
    }
    public void conversion() {
        System.out.println("The paladin attempts to convert you to the Lutefisk God. Although he makes persuasive arguments, he can't manage to convince you.");
        damage = 0;
    }
    public void squelch() {
        //entirely flavour text
        System.out.println("The paladin squelches towards you suggestively. Although it does no damage, you feel like you'll need to wash up later.");
        damage = 0;
    }
    public void fishSlap() {
        //"demoralizes" the player, skipping their turn
        System.out.println("The paladin slaps you with a convenient fish. It temporarily stuns you, allowing the paladin to evade you easier.");
        damage = 0;
        evasion = evasion + 3;
    }
    public void slash() {
        System.out.println("The paladin stabs you with his Holy Fishy Sword of +1 Squelchiness.");
        damage = squelchiness + 5;
    }
    public int getHealth() {
        return health;
    }
    public void showStats() {
            System.out.println("The paladin's health is " + health + ".");
            System.out.println("The paladin's squelchiness factor is " + squelchiness + ".");
            System.out.println("The paladin's armor is " + armor + ".");
            System.out.println("The paladin's evasion ability is " + evasion + ".");
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
            System.out.println("You deal no damage!");
        }
        System.out.println("The paladin's remaining health is " + health + ".");
    }
    public void chooseAttack() {
        double randomNumber = Math.random();
        if (randomNumber <= .25) {
            slash();
        }
        else 
        {
            if (randomNumber <= .5) {
                fishSlap();
            }
            else 
            {
                if (randomNumber <= .75) {
                    squelch();
                }
                else
                {
                   if (randomNumber <= 1) {
                       conversion();
                    }
                }
            }
        }
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