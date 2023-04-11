/**
 * ECCS: Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @since March 29, 2023
 *
 * Description: This java Party class stores all the names that are given to Hattie's 3 family members and
 * her pet, along with their current health, if they are dead of alive, and if they have won the game or not.
 */
package com.example.OTrail;

import java.util.Random;
import java.util.Scanner;


public class Party
{
    private String difficulty[] = {"Easy", "Medium", "Hard", "Hardcore"};
    private String currentDifficulty = "Easy";
    private String names[] = new String[5]; // five people and the pet
    private int health[] = {100, 100, 100, 100, 100};
    private boolean isAlive[] = {true, true, true, true, true};
    private boolean gameOver = false;
    private Inventory inv;

    /**
     * Default constructor for the Inventory class.
     */
    public Party(Inventory inv)
    {
        this.inv = inv;
    }

    /**
     * Gets the games difficulty level.
     *
     * @return currentDifficulty Allows the program to know if the game is set to Easy, Medium, Hard, or Hardcore.
     */
    public String getDifficulty()
    {
        return currentDifficulty;
    }
    /**
     * Gets Hattie's family members names and the name of their pet, which is the last index in the names array.
     *
     * @return names Allows the program to know each person's name.
     */
    public String[] getNames()
    {
        return names;
    }
    /**
     * Gets Hattie's health, her family members health, and the current health of their pet, which is the last index in the names array.
     *
     * @return health Allows the program to know each person's health.
     */
    public int[] getHealth()
    {
        return health;
    }

    /**
     * Gets Hattie's current living status, her family members current living status, and the current living status of their pet, which is the last index in the names array.
     *
     * @return isAlive Allows the program to know each person's current living status.
     */
    public boolean[] getIsAliveStatus()
    {
        return isAlive;
    }

    /**
     * Gets the status of the game whether it is over or not.
     *
     * @return False if all the players are living and true if they are all dead.
     */
    public boolean getGameOverStatus()
    {
        if(isAlive[0] || isAlive[1] || isAlive[2] || isAlive[3] || isAlive[4])
        {
            gameOver = false;
        }
        else
        {
            gameOver = true;
        }
        return gameOver;
    }

    /**
     * Sets the games current difficulty level.
     *
     * @param currentDifficulty Can set the game to a Easy, Medium, Hard, or Hardcore difficulty level.
     */
    public void setDifficulty(String currentDifficulty)
    {
        this.currentDifficulty = currentDifficulty;
    }

    /**
     * Sets Hattie's family members names and the name of the pet.
     *
     * @param names Is a names array containing Hattie at the first element, then her family, and finally her pet at the last element.
     */
    public void setNames(String names[])
    {
        this.names = names;
    }

    /**
     * Sets Hattie's family members health and the health of the pet.
     *
     * @param health Is a health array containing Hattie at the first element, then her family, and finally her pet at the final element.
     */
    public void setHealth(int health[])
    {
        this.health = health;
    }

    /**
     * Sets Hattie's family members current alive status and the alive status of the pet.
     *
     * @param isAlive Is a alive status array containing Hattie at the first element, then her family, and finally her pet at the final element.
     */
    public void setIsAliveStatus(boolean isAlive[])
    {
        this.isAlive = isAlive;
    }

    public void dailyFoodUsed()
    {
        int counter = 0;

        for(boolean needsFood : isAlive)
        {
            if(needsFood)
            {
                counter++;
            }
        }

        // negative because the people will use food each day and each individual eats 3 pounds a day
        if (inv.getFoodCount() > 0)
        {
            inv.setFoodCount(-1*counter*3);
        }
        else if (inv.getFoodCount() == 0)
        {
            Random rand = new Random();

            int player = 0;

            do
            {
                player = rand.nextInt(5);

            }while(!isAlive[player]);

            health[player] = health[player] - 10;

            if(health[player] <= 0)
            {
                isAlive[player] = false;
                System.out.println(names[player] + " is dead!");
            }
        }
        else
        {
            inv.setFoodCount(0);
        }

    }

    /**
     * Prints out the health of Hattie and her family members/pet.
     */
    public void printAllPeoplesHealth()
    {
        for(int i = 0; i < names.length; i++)
        {
            if(health[i] > 0)
            {
                System.out.println(names[i] + " has a health of " + health[i] + ".");
            }
        }
    }
}