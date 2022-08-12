package com.zeezaglobal.dicerollingapp;

import java.util.Random;

public class Dice {
    int numberOfSides;

    public Dice(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    int rollTrueTen() // created function for rolling dies
    {

        Random rand = new Random();
        return rand.nextInt(numberOfSides-2) ;

    }
    int rollDie() // created function for rolling dies
    {

        Random rand = new Random(); // calling the random function to get a random number and assinging it to rand
        // variable
      return rand.nextInt(numberOfSides) + 1;// to remove 0 and to add limit

    }

    public int rollTenthTen() {
        Random rand = new Random();
        return (rand.nextInt(numberOfSides)+1)*10;
    }
}
