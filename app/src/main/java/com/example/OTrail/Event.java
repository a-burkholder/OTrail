/**
 * ECCS: Programming 2 Oregon Trail Project
 * @author Aaron Guzman
 * @since April 1, 2023
 *
 * Description: This Event class will randomly generate random events throughout the game and update the player's items.
 */
package com.example.OTrail;

import android.content.Intent;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Event implements Serializable
{
    //-------------variables
    private Inventory inv;
    private Party party;
    private Date date;
    private static Event instance = null;
    private String eventMessage = "";



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

    public static Event getInstance(Inventory inv, Party party, Date date)
    {
        if(instance == null)
        {
            instance = new Event(inv, party, date);
        }
        return instance;
    }
    public String getEventMessage()
    {
        return eventMessage;
    }

    public int eventNum(){
        Random chance = new Random();
        int event = chance.nextInt(200);
        return event;
    }
    /**
     * This method generates random events and will then update the player's inventory/health depending on the event.
     */
    public void randomEvents(Inventory inv, Party party, Date date) {
        Random rand = new Random();

        int rand_int1 = rand.nextInt(35);

        if (date.getDay() == 25 && date.getMonth() == 12){
            eventMessage = "Santa";
        }

        //raiderAttacck
        if (rand_int1 == 2 || rand_int1 == 3) {
            eventMessage = "You have been attacked by raiders.\n" + "Minus 2 baskets.\n" + "Minus $100.\n" + "Minus 2 clothing." + " Basket Count: " + inv.getBasketCount() + " Your money: " + inv.getPlayerMoneyCount() + " Clothing Count: " + inv.getClothingCount();
            inv.setBasketCount(-2);
            if (inv.getBasketCount() < 0) {
                inv.setBasketCount(-1 * inv.getBasketCount());
            }
            inv.setPlayerMoneyCount(-100);
            if (inv.getPlayerMoneyCount() < 0) {
                inv.setPlayerMoneyCount(-1 * inv.getPlayerMoneyCount());
            }
            inv.setClothingCount(-2);
            if (inv.getClothingCount() < 0) {
                inv.setClothingCount(-1 * inv.getClothingCount());}
            System.out.println("IN EVENT___________________________________");
        }

        //Animal Attack
        else if (rand_int1 == 4) {
            int player[] = new int[5];
            int playerTemp = 0;
            playerTemp = rand.nextInt(5);

            eventMessage = "Animal attack. Minus 2 medical supplies and if you do not have medical supplies -10 player health." + " Medical Supplies = " + inv.getMedicalSupplyCount();
            if (inv.getMedicalSupplyCount() > 2) {
                inv.setMedicalSupplyCount(-2);
            } else {
                player = party.getHealth();
                player[playerTemp] = player[playerTemp] - 10;
                party.setHealth(player);
            }
        }

        //Member Sickness
        else if (rand_int1 == 5 || rand_int1 == 6) {
            int player1[] = new int[5];
            int playerTemp1 = 0;
            playerTemp1 = rand.nextInt(5);
            eventMessage = "A member of your group has Dysentery. Minus 5 medical supplies and if you do not have medical supplies -30 player health." + " Medical Supplies = " + inv.getMedicalSupplyCount();
            if (inv.getMedicalSupplyCount() > 5) {
                inv.setMedicalSupplyCount(-5);
            } else {
                player1 = party.getHealth();
                player1[playerTemp1] = player1[playerTemp1] - 30;
                party.setHealth(player1);
            }
        }

        //Dead Ox
        else if (rand_int1 == 11) {
            eventMessage = "One of you Ox has died." + " Oxen count: " + inv.getOxenCount();
            inv.setOxenCount(-1);
        }


        //Snake Bite
        else if (rand_int1 == 15) {
            int player2[] = new int[5];
            int playerTemp2 = 0;
            playerTemp2 = rand.nextInt(5);

            eventMessage = "A member of your family got bit by a snake. Minus 2 Medical Supplies and if you do not have medical supplies -10 player health" + "Medical Supplies: " + inv.getMedicalSupplyCount();
            if (inv.getMedicalSupplyCount() > 2) {
                inv.setMedicalSupplyCount(-2);
            } else {
                player2 = party.getHealth();
                player2[playerTemp2] = player2[playerTemp2] - 10;
                party.setHealth(player2);
            }
        }

        //Wrong Trail; lose 4 days
        else if (rand_int1 == 16) {
            eventMessage = "You went down the wrong trail. Lose 4 days.";
            date.setDate(4);
        }

        //Rough trail; lose a day
        else if (rand_int1 == 17 || rand_int1 == 18) {
            eventMessage = "Rough Trail. Lose a day.";
            date.setDate(1);
        }

        //Impassible trail; lose a day
        else if (rand_int1 == 19 || rand_int1 == 20) {
            eventMessage = "Impassible trail. Lose 3 days.";
            date.setDate(3);
        }

        //Broken Wheel
        else if (rand_int1 == 21 || rand_int1 == 22) {
            eventMessage = "You have a broken wheel. Minus 1 wheels." + "Wheel Count: " + inv.getWagonWheelCount();
            inv.setWagonWheelCount(-1);
        }

        //Broken Axle
        else if (rand_int1 == 23 || rand_int1 == 24) {
            eventMessage = "You have a broken Axle. Minus 1 axle." + " Axle Count: " + inv.getWagonAxleCount();
            inv.setWagonAxleCount(-1);
        }

        //Broken Tongue
        else if (rand_int1 == 25) {
            eventMessage = "You have a broken tongue. Minus 1 tongue." + "Tongue Count: " + inv.getWagonTongueCount();
            inv.setWagonTongueCount(-1);
        }
        //berrybush
        else  {
            eventMessage = "You found a berry bush.";
        }
    }

    /**River Crossing menu
     * Determines river height and depth, then outputs menu for choices.
     */
    public String riverCrossing(Inventory Ninv, int input)
    {
        int value = input;
        Random rand = new Random();
        int rand_int1 = rand.nextInt(10);
        int rand_int2 = rand.nextInt(50);
        String output = "";

            switch (value) {
                case 1 -> {
                    output = "The river is " + rand_int1 + " feet deep and " + rand_int2 + " feet across." +
                            "\nYou could pay $100 to safely travel the river via ferry." +
                            "\nHowever, if you wish to cross by foot, there is a chance" +
                            "\nto lose items in the heavy current.";
                }
                case 2 -> {
                    riverCrossing(Ninv, 2, rand_int1, rand_int2);
                }
                case 3 -> {
                    riverCrossing(Ninv, 3, rand_int1, rand_int2);
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }

        return output;
    }

    /**public void riverCrossing(int option)
     * Contains the functionality of options to cross the river
     * @param option The index for finding which option was selected
     * */
    public void riverCrossing(Inventory Ninv, int option, int rand1, int rand2){
        if (option == 2){
            Ninv.setPlayerMoneyCount(-100);
            System.out.println("You have paid $50 to successfully cross the river!");
        }
        else if (option == 3){
            Random rand = new Random();
            if(rand.nextInt(100) > 98){
                System.out.println("You have successfully crossed the river!");
            }

            else {
                System.out.println("You have successfully crossed the river, but you lost: ");

                if(Ninv.getClothingCount() > 0){
                    int numClothesL = inv.getClothingCount() / 3;
                    Ninv.setClothingCount(-numClothesL);
                    System.out.println(numClothesL + " clothes");
                }
                if(Ninv.getWagonWheelCount()>1){
                    Ninv.setWagonWheelCount(-1);
                    System.out.println("1 wheel");
                }
                if(Ninv.getWagonAxleCount()>1){
                    Ninv.setWagonAxleCount(-1);
                    System.out.println("1 axel");
                }
            }
        }
    }
}
