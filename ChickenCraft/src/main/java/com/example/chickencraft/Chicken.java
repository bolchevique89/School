package com.example.chickencraft;

public class Chicken {
    /** whether chicken is happy or not */
    private Boolean isHappy = true;
    /** whether chicken is alive or not */
    private Boolean isAlive = true;
    /** chicken's name */
    private String name = "Nancy";
    /** chicken's health points */
    private int hearts = 4;
    /** number of seeds chicken is currently fed */
    private double seeds = 0.1;

    /** default constructor */
    public Chicken() {
    }
    /** returns report on chicken */
    public String toString() {
        System.out.println("Name: " + this.name);
        if (this.isHappy) {
            System.out.println("Happiness: Happy");
        } else {
            System.out.println("Happiness: Sad");
        }

        if (this.isAlive) {
            System.out.println("Dead or Alive: Alive");
        } else {
            System.out.println("Dead or Alive: Dead");
        }

        System.out.println("Hearts: " + this.hearts + "\nSeeds: " + this.seeds + "kg\n");
        return null;
    }
    /** hit chicken to lose heart and becomes unhappy  */
    public void hit() {
        this.isHappy = false;
        --this.hearts;
        if (this.hearts == 0) {
            this.setDead();
        }

    }
    /** two chickens play together and become happy */
    public static void play(Chicken chickenOne, Chicken chickenTwo) {
        chickenOne.setHappiness();
        chickenTwo.setHappiness();
    }
    /** gives chicken a new name */
    public void setName(String chickenName) {
        this.name = chickenName;
    }
    /** feeds the chicken and gains heart */
    public void feed() {
        this.seeds += 0.1;
        int seedsInt = (int)Math.round(this.seeds * 100.0);
        this.seeds = (double)seedsInt / 100.0;
        if (this.seeds > 2.01) {
            this.setDead();
        } else if (this.hearts < 4) {
            ++this.hearts;
        }

    }
    /** adds to player's collection of eggs but makes chicken unhappy */
    public int collectEggs() {
        int eggs = (int)(this.seeds / 0.25);
        this.seeds = (double)Math.round(this.seeds * 100.0);
        this.seeds -= (double)(eggs * 25);
        this.seeds /= 100.0;
        if (this.isHappy) {
            eggs *= 2;
            this.isHappy = false;
        }

        return eggs;
    }
    /** returns if chicken is alive */
    public Boolean isAlive() {
        return this.isAlive;
    }
    /** returns chicken's name  */
    public String getName() {
        return this.name;
    }
    /** returns number of seeds chicken is currently fed */
    public double getSeeds() {
        return this.seeds;
    }
    /** returns number of hearts  */
    public int getHearts() {
        return this.hearts;
    }
    /** returns if chicken is happy */
    public Boolean isHappy() {
        return this.isHappy;
    }
    /** makes chicken happy */
    private void setHappiness() {
        this.isHappy = true;
    }
    /** kills the chicken */
    private void setDead() {
        this.isAlive = false;
        this.hearts = 0;
        this.isHappy = false;
    }
}
