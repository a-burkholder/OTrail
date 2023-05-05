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
    private int riverWidth;
    private int riverDepth;


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
            eventMessage = "Santa Has delivered you presents!";
            inv.setBasketCount(+2);
            inv.setFoodCount(+500);
            inv.setPlayerMoneyCount(+300);
            inv.setMedicalSupplyCount(+10);
            inv.setClothingCount(+4);
        }

        //raiderAttacck
        if (rand_int1 == 2 || rand_int1 == 3) {
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
            eventMessage = "You have been attacked by raiders.\n" + "Minus 2 baskets.\n" + "Minus $100.\n" + "Minus 2 clothing.";
        }

        //Animal Attack
        else if (rand_int1 == 4) {
            if (inv.getMedicalSupplyCount() > 2) {
                inv.setMedicalSupplyCount(-2);
            } else {
                party.setHealth(-10);
            }
            eventMessage = "Animal attack. Minus 2 medical supplies and if you do not have medical supplies -10 player health.";
        }

        //Member Sickness
        else if (rand_int1 == 5 || rand_int1 == 6) {
            if (inv.getMedicalSupplyCount() > 5) {
                inv.setMedicalSupplyCount(-5);
            } else {
                party.setHealth(-30);
            }
            eventMessage = "A member of your group has Dysentery.\n Minus 5 medical supplies and if you do not have medical supplies -30 player health.";
        }

        //Dead Ox
        else if (rand_int1 == 11) {
            inv.setOxenCount(-1);
            eventMessage = "One of you Ox has died." + " Oxen count: " + inv.getOxenCount();
        }


        //Snake Bite
        else if (rand_int1 == 15) {
            if (inv.getMedicalSupplyCount() >= 2)
            {
                party.setHealth(-10);
            }
            eventMessage = "A member of your family got bit by a snake. Minus 2 Medical Supplies and if you do not have medical supplies -10 player health";
        }

        //Wrong Trail; lose 4 days
        else if (rand_int1 == 16) {
            date.setDate(4);
            if(inv.getFoodCount() >= 0)
            {
                inv.setFoodCount(-4*party.getNumberOfPeopleAlive()*party.getSpeed());

            }
            else
            {
                noFood();
                inv.setFoodCount(-inv.getFoodCount());
            }
            eventMessage = "You went down the wrong trail. Lose 4 days.";
        }

        //Rough trail; lose a day
        else if (rand_int1 == 17 || rand_int1 == 18) {
            date.setDate(1);
            if(inv.getFoodCount() >= 0)
            {
                inv.setFoodCount(-party.getNumberOfPeopleAlive()*party.getSpeed());

            }
            else
            {
                noFood();
                inv.setFoodCount(-inv.getFoodCount());
            }
            eventMessage = "Rough Trail. Lose a day.";
        }

        //Impassible trail; lose a day
        else if (rand_int1 == 19 || rand_int1 == 20) {
            date.setDate(3);
            if(inv.getFoodCount() >= 0)
            {
                inv.setFoodCount(-3*party.getNumberOfPeopleAlive()*party.getSpeed());

            }
            else
            {
                noFood();
                inv.setFoodCount(-inv.getFoodCount());
            }
            eventMessage = "Impassible trail. Lose 3 days.";
        }

        //Broken Wheel
        else if (rand_int1 == 21 || rand_int1 == 22) {
            inv.setWagonWheelCount(-1);
            eventMessage = "You have a broken wheel. Minus 1 wheels." + "Wheel Count: " + inv.getWagonWheelCount();
        }

        //Broken Axle
        else if (rand_int1 == 23 || rand_int1 == 24) {
            inv.setWagonAxleCount(-1);
            eventMessage = "You have a broken Axle. Minus 1 axle." + " Axle Count: " + inv.getWagonAxleCount();
        }

        //Broken Tongue
        else if (rand_int1 == 25) {
            inv.setWagonTongueCount(-1);
            eventMessage = "You have a broken tongue. Minus 1 tongue." + "Tongue Count: " + inv.getWagonTongueCount();
        }
        //berrybush
        else  {
            eventMessage = "You found a berry bush!";
        }
    }

    /**River Crossing menu
     * Determines river height and depth, then outputs menu for choices.
     */
    public String riverCrossing(Inventory Ninv, int input)
    {
        int value = input;
        Random rand = new Random();
        riverDepth = rand.nextInt(10+1);
        riverWidth = rand.nextInt(50+1);

            switch (value) {
                case 1 -> {
                    eventMessage = "The river is " + riverDepth + " feet deep and " + riverWidth + " feet across." +
                            "\nYou could pay $75 to safely travel the river via ferry." +
                            "\nHowever, if you wish to cross by foot, there is a chance" +
                            "\nto lose items in the heavy current.";
                }
                case 2 -> {
                    riverCrossing(Ninv, 2, riverDepth, riverWidth);
                }
                case 3 -> {
                    riverCrossing(Ninv, 3, riverDepth, riverWidth);
                }
                default -> {
                    System.out.println("Invalid input");
                }
            }

        return eventMessage;
    }

    /**public void riverCrossing(int option)
     * Contains the functionality of options to cross the river
     * @param option The index for finding which option was selected
     * */
    public void riverCrossing(Inventory Ninv, int option, int rivD, int rivW){
        if (option == 2){
            Ninv.setPlayerMoneyCount(-75);
            eventMessage = "You have paid $75 and have successfully crossed the river!";
        }
        else if (option == 3){
            Random rand = new Random();
            if(rand.nextInt(100) > (0.8*rivW)+(6*rivD)){
                eventMessage = "You have successfully crossed the river!";
            }

            else {
                eventMessage = "You have successfully crossed the river, but you lost: ";

                if(Ninv.getClothingCount() > 0){
                    int numClothesL = inv.getClothingCount() / 3;
                    Ninv.setClothingCount(-numClothesL);
                    eventMessage = eventMessage + numClothesL + " clothes, ";
                }
                if((Ninv.getWagonWheelCount()>2) && (rivW>40)) {
                    Ninv.setWagonWheelCount(-2);
                    eventMessage = eventMessage + "two wagon wheels, ";
                }
                else if(Ninv.getWagonWheelCount()>1){
                    Ninv.setWagonWheelCount(-1);
                    eventMessage = eventMessage + "two wagon wheels, ";
                }

                if(Ninv.getWagonAxleCount()>1){
                    if(rivD >= 7) {
                        Ninv.setWagonAxleCount(-1);
                        Ninv.setWagonTongueCount(-1);
                        eventMessage = eventMessage + "one wagon axle, and one tongue";
                    }
                }
                eventMessage = eventMessage + ".";
            }
        }
    }

    public void noFood()
    {
        party.setHealth(-10);
    }
}
