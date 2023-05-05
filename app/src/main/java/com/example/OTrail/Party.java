/**
 * ECCS: Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @since March 29, 2023
 *
 * Description: This java Party class stores all the names that are given to Hattie's 3 family members and
 * her pet, along with their current health, if they are dead of alive, and if they have won the game or not.
 */
package com.example.OTrail;

import java.io.Serializable;
import java.util.Random;


public class Party implements Serializable
{
    private String difficulty[] = {"Easy", "Medium", "Hard", "Hardcore"};
    private String currentDifficulty = "Easy";
    private String names[] = new String[5]; // five people and the pet
    private int health[] = {100, 100, 100, 100, 100};
    private static Party instance = null;
    private int speed = 10;

    private boolean isAlive[] = {true, true, true, true, true};
    private boolean gameOver = false;
    private static Inventory inv;

    private Random rand;

    /**
     * Default constructor for the Inventory class.
     */
    public Party(Inventory inv, String names[])
    {
        this.inv = inv;
        this.names = names;
        rand = new Random();
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

    public int getNumberOfPeopleAlive()
    {
        int playersAlive = 0;
        for(int i = 0;  i < 5; i++)
        {
            if(health[i] > 0)
            {
                playersAlive++;
            }
        }
        return playersAlive;
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

    public int getSpeed()
    {
        return speed;
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

    public boolean getAtLeastSomeoneAlive()
    {
        if(isAlive[0] || isAlive[1] || isAlive[2] || isAlive[3] || isAlive[4])
        {
            return true;
        }
        else
        {
            return false;
        }
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


    public void setHealth(int healthAway) {
        boolean runLoop = true;
        int randomValue = 0;
        int numberDead = 0;
        int numberAt100 = 0;

        while (runLoop && healthAway < 0)
        {
            randomValue = rand.nextInt(5);

            if(health[randomValue] > 0)
            {
                health[randomValue] = health[randomValue] + healthAway;

                if(health[randomValue] < 0)
                {
                    health[randomValue] = 0;
                }
                runLoop = false;
            }
            else
            {
                numberDead++;
            }

            if(numberDead == 5)
            {
                gameOver = true;
                runLoop = false;

            }
        }

        while (runLoop && healthAway < 100 && healthAway > 0)
        {
            randomValue = rand.nextInt(5);

            if(health[randomValue] < 100 && health[randomValue] > 0)
            {
                health[randomValue] = health[randomValue] + healthAway;

                if(health[randomValue] > 100)
                {
                    health[randomValue] = 100;
                }

                if(health[randomValue] < 0)
                {
                    health[randomValue] = 0;
                }
                runLoop = false;
            }
            else
            {
                numberAt100++;
            }

            if(numberAt100 == 5)
            {
                runLoop = false;

            }
        }
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

    /**
     *
     * @param speed
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void dailyFoodUsed(Inventory thisInv)
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
        if (thisInv.getFoodCount() > 0)
        {
            thisInv.setFoodCount(-1*counter*3);
        }
        else if (thisInv.getFoodCount() == 0)
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
            thisInv.setFoodCount(0);
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


    public static Party getInstance(Inventory inv, String names[])
    {
        if(instance == null)
        {
            instance = new Party(inv, names);
        }
        return instance;
    }
}