/**
 * ECCS: Programming 2 Oregon Trail Project
 * @author Aaron Guzman
 * @since April 1, 2023
 *
 * Description: This Event class will randomly generate random events throughout the game and update the player's items.
 */
package com.example.OTrail;

import java.util.Random;
public class Event
{
    //-------------variables
    private Inventory inv;
    private Party party;
    private Date date;


    /**
     * Constructor for the Event class.
     *
     * @param inv The inventory object that stores the player's items.
     * @param party The party of Hattie and her family/pet.
     */
    public Event(Inventory inv, Party party, Date date)
    {
        this.inv = inv;
        this.party = party;
        this.date = date;
    }

    /**
     * This method generates random events and will then update the player's inventory/health depending on the event.
     */
    public void randomEvents()
    {
        // create a random integer generator from 0 to 99
        Random rand = new Random();


        int rand_int1 = rand.nextInt(100);


        // Print random integers
        //System.out.println("Random Integer: "+rand_int1);


        //berrybush
        if (rand_int1 ==  0 || rand_int1 == 1){
            System.out.println("You found a berry bush. Plus 20 pounds of food.");
            inv.setFoodCount(20);
            System.out.println("Food Count: " + inv.getFoodCount());
        }


        //raiderAttacck
        if (rand_int1 ==  2 || rand_int1 == 3){
            System.out.println("You have been attacked by raiders.\n" + "Minus 50 bullets.\n" + "Minus $100.\n" + "Minus 2 clothing.");
            inv.setBulletsCount(-50);
            if(inv.getBulletsCount() < 0)
            {
                inv.setBulletsCount(-1*inv.getBulletsCount());
            }
            System.out.println("Bullet Count: " + inv.getBulletsCount());
            inv.setPlayerMoneyCount(-100);
            if(inv.getPlayerMoneyCount() < 0)
            {
                inv.setPlayerMoneyCount(-1*inv.getPlayerMoneyCount());
            }
            System.out.println("Player Money Count: " + inv.getPlayerMoneyCount());
            inv.setClothingCount(-2);
            if(inv.getClothingCount() < 0)
            {
                inv.setClothingCount(-1*inv.getClothingCount());
            }
            System.out.println("Clothing Count: " + inv.getClothingCount());
        }


        //Animal Attack
        if (rand_int1 ==  4){
            int player[] = new int [5];
            int playerTemp = 0;
            playerTemp = rand.nextInt(5);


            System.out.println("Animal attack. Minus 2 medical supplies and if you do not have medical supplies -10 player health.");
            if(inv.getMedicalSupplyCount() > 2)
            {
                inv.setMedicalSupplyCount(-2);
            }
            else
            {
                player = party.getHealth();
                player[playerTemp] = player[playerTemp] - 10;
                party.setHealth(player);
            }
            System.out.println("Medical supply count: " + inv.getMedicalSupplyCount());
        }

        //Member Sickness
        if (rand_int1 ==  5 || rand_int1 == 6){
            int player1[] = new int [5];
            int playerTemp1 = 0;
            playerTemp1 = rand.nextInt(5);
            System.out.println("A member of your group has the flu. Minus 2 medical supplies and if you do not have medical supplies -10 player health.");
            if(inv.getMedicalSupplyCount() > 2)
            {
                inv.setMedicalSupplyCount(-2);
            }
            else
            {
                player1 = party.getHealth();
                player1[playerTemp1] = player1[playerTemp1] - 10;
                party.setHealth(player1);
            }
            System.out.println("Medical supply count: " + inv.getMedicalSupplyCount());
        }

        //Dead Ox
        if (rand_int1 ==  11){
            System.out.println("One of you Ox has died.");
            inv.setOxenCount(-1);
            System.out.println("Oxen count: " + inv.getOxenCount());
        }


        //Snake Bite
        if (rand_int1 == 15){
            int player2[] = new int [5];
            int playerTemp2 = 0;
            playerTemp2 = rand.nextInt(5);


            System.out.println("A member of your family got bit by a snake. Minus 2 Medical Supplies and if you do not have medical supplies -10 player health");
            if(inv.getMedicalSupplyCount() > 2)
            {
                inv.setMedicalSupplyCount(-2);
            }
            else
            {
                player2 = party.getHealth();
                player2[playerTemp2] = player2[playerTemp2] - 10;
                party.setHealth(player2);
            }
            System.out.println("Medical supply count: " + inv.getMedicalSupplyCount());
        }


        //Wrong Trail; lose 4 days
        if (rand_int1 == 16){
            System.out.println("You went down the wrong trail. Lose 4 days.");
            date.setDate(4);
        }


        //Rough trail; lose a day
        if (rand_int1 == 17 || rand_int1 == 18){
            System.out.println("Rough Trail. Lose a day.");
            date.setDate(1);
        }


        //Impassible trail; lose a day
        if (rand_int1 == 19 || rand_int1 == 20){
            System.out.println("Impassible trail. Lose 3 days.");
            date.setDate(3);
        }


        //Broken Wheel
        if (rand_int1 ==  21 || rand_int1 == 22){
            System.out.println("You have a broken wheel. Minus 1 wheels.");
            inv.setWagonWheelCount(-1);
            System.out.println("Wheel Count: " + inv.getWagonWheelCount());
        }


        //Broken Axle
        if (rand_int1 ==  23 || rand_int1 == 24){
            System.out.println("You have a broken Axle. Minus 1 axle.");
            inv.setWagonAxleCount(-1);
            System.out.println("Axle Count: " + inv.getWagonAxleCount());
        }


        //Broken Tongue
        if (rand_int1 ==  25){
            System.out.println("You have a broken tongue. Minus 1 tongue.");
            inv.setWagonTongueCount(-1);
            System.out.println("Tongue Count: " + inv.getWagonTongueCount());
        }
    }

    /**public void riverCrossing(int option)
     * Contains the functionality of options to cross the river
     * @param option The index for finding which option was selected
     * */
    public void riverCrossing(int option, int rand1, int rand2){
        if (option == 2){
            inv.setPlayerMoneyCount(-50);
            System.out.println("You have paid $50 to successfully cross the river!");
        }
        else if (option == 3){
            Random rand = new Random();
            if(rand.nextInt(10) > rand1 || rand.nextInt(50 )> rand2){
                System.out.println("You have successfully crossed the river!");
            }

            else {
                System.out.println("You have successfully crossed the river, but you lost: ");

                if(inv.getClothingCount() > 0){
                    int numClothesL = inv.getClothingCount() / 3;
                    inv.setClothingCount(-numClothesL);
                    System.out.println(numClothesL + " clothes");
                }
                if(inv.getWagonWheelCount()>1){
                    inv.setWagonWheelCount(-1);
                    System.out.println("1 wheel");
                }
                if(inv.getWagonAxleCount()>1){
                    inv.setWagonAxleCount(-1);
                    System.out.println("1 axel");
                }
            }
        }
    }
}
