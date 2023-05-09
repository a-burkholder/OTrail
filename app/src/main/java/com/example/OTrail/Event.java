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
     * Default Event class constructor.
     */
    private Event()
    {

    }

    /**
     * Constructor for the Event class.
     *
     * @param inv The inventory object that stores the player's items.
     * @param party The party of Hattie and her family/pet.
     */
    public Event(Inventory inv, Party party, Date date) {
        this.inv = inv;
        this.party = party;
        this.date = date;
    }

    public static Event getInstance(Inventory inv, Party party, Date date) {
        if(instance == null) {
            instance = new Event(inv, party, date);
        }
        return instance;
    }

    /**Grabs the current even message
     * @return a string with an event message
     * */
    public String getEventMessage() {
        return eventMessage;
    }

    /**Creates a number between 1-200
     *
     * @return an int from 1-200
     */
    public int eventNum(){
        Random chance = new Random();
        int event = chance.nextInt(200);
        return event;
    }

    /**
     * This method generates random events and will then update the player's inventory/health depending on the event.
     * @param date the date to make the event, so it can calculate skips
     * @param inv the current inv, so it can update it
     * @param party the current party stats, so it can update it
     */
    public void randomEvents(Inventory inv, Party party, Date date) {
        Random rand = new Random();

        int rand_int1 = rand.nextInt(35);

        //christmas event
        if (date.getDay() == 25 && date.getMonth() == 12){
            eventMessage = "Santa has delivered you presents!";
            inv.setBasketCount(10);
            inv.setFoodCount(800);
            inv.setPlayerMoneyCount(300);
            inv.setMedicalSupplyCount(10);
            inv.setClothingCount(4);
            inv.setBasketCount(100);
        }

        //raiderAttacck
        if (rand_int1 == 2 || rand_int1 == 3) {
            eventMessage = "You have been attacked by raiders.";
            inv.setBasketCount(-2);
            if (inv.getBasketCount() < 0) {
                inv.setBasketCount(-1 * inv.getBasketCount());
                eventMessage = eventMessage + "\n-2 baskets.";
            }
            inv.setPlayerMoneyCount(-100);
            if (inv.getPlayerMoneyCount() < 0) {
                inv.setPlayerMoneyCount(-1 * inv.getPlayerMoneyCount());
                eventMessage = eventMessage + "\n-$100.";
            }
            inv.setClothingCount(-2);
            if (inv.getClothingCount() < 0) {
                inv.setClothingCount(-1 * inv.getClothingCount());
                eventMessage = eventMessage + "\n-2 clothing.";
            }
            party.setHealth(-20);
        }

        //Animal Attack
        else if (rand_int1 == 4) {
            if (inv.getMedicalSupplyCount() >= 1) {
                inv.setMedicalSupplyCount(-1);
                eventMessage = "Animal Attack.\n-1 medical supplies" + "\nMedical Supplies: " + inv.getMedicalSupplyCount();
            } else {
                party.setHealth(-5);
                eventMessage = "Animal Attack.\n-5 Health";
            }
        }

        //Member Sickness
        else if (rand_int1 == 5 || rand_int1 == 6) {
            if (inv.getMedicalSupplyCount() > 5) {
                inv.setMedicalSupplyCount(-5);
                eventMessage = "A member of your group has Dysentery.\n-5 medical supplies" + "\nMedical Supplies: " + inv.getMedicalSupplyCount();
            } else {
                party.setHealth(-30);
                eventMessage = "A member of your group has Dysentery.\n-30 Health";
            }
        }

        //Dead Ox
        else if (rand_int1 == 11) {
            inv.setOxenCount(-1);
            eventMessage = "One of you Ox has died." + "\nOxen count: " + inv.getOxenCount();
        }


        //Snake Bite
        else if (rand_int1 == 15) {
            if (inv.getMedicalSupplyCount() >= 2) {
                inv.setMedicalSupplyCount(-2);
                eventMessage = "A member of your family got bit by a snake.\n-2 medical supplies" + "\nMedical Supplies: " + inv.getMedicalSupplyCount();
            } else {
                party.setHealth(-30);
                eventMessage = "A member of your family got bit by a snake.\n-10 Health";
            }
        }

        //Wrong Trail; lose 4 days
        else if (rand_int1 == 16) {
            date.setDate(4);
            if(inv.getFoodCount() >= 0) {
                switch (party.getSpeed()){
                    case 10: {
                        inv.setFoodCount(-4 * party.getNumberOfPeopleAlive() * 2);
                    }break;
                    case 12:{
                        inv.setFoodCount(-4*party.getNumberOfPeopleAlive()*3);
                    }break;
                    case 15:{
                        inv.setFoodCount(-4*party.getNumberOfPeopleAlive()*5);
                    }break;
                    default:inv.setFoodCount(-15);
                }
            }
            else {
                noFood();
                inv.setFoodCount(-inv.getFoodCount());
            }
            eventMessage = "Hattie went down the wrong trail. Lose 4 days.";
        }

        //Rough trail; lose a day
        else if (rand_int1 == 17 || rand_int1 == 18) {
            date.setDate(1);
            if(inv.getFoodCount() >= 0) {
                switch (party.getSpeed()){
                    case 10: {
                        inv.setFoodCount(-party.getNumberOfPeopleAlive() * 2);
                    }break;
                    case 12:{
                        inv.setFoodCount(-party.getNumberOfPeopleAlive()*3);
                    }
                    case 15:{
                        inv.setFoodCount(-party.getNumberOfPeopleAlive()*5);
                    }break;
                    default:inv.setFoodCount(-15);
                }
            }
            else {
                noFood();
                inv.setFoodCount(-inv.getFoodCount());
            }
            eventMessage = "Rough Trail. Lose a day.";
        }

        //Impassible trail; lose 3 day s
        else if (rand_int1 == 19 || rand_int1 == 20) {
            date.setDate(3);
            if(inv.getFoodCount() >= 0) {
                switch (party.getSpeed()){
                    case 10:{
                        inv.setFoodCount(-3*party.getNumberOfPeopleAlive()*2);
                    }break;
                    case 12: {
                        inv.setFoodCount(-3*party.getNumberOfPeopleAlive()*3)
                    }break;
                    case 15: {
                        inv.setFoodCount(-3*party.getNumberOfPeopleAlive()*5);
                    }break;
                    default:inv.setFoodCount(-15);
                }
            }
            else {
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
        else {
            eventMessage = "You found a berry bush!";
        }
    }

    /**River Crossing menu
     * Determines river height and depth, then outputs menu for choices.
     * @param input the index for the option chosen
     * @param Ninv the current inventory to update
     * @return data as a string if index = 1 <br> paid crossing results if index = 2 <br> unpaid crossing results if index = 3
     */
    public String riverCrossing(Inventory Ninv, int input) {
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
     * @param Ninv The current inventory to be updated
     * @param option The index for finding which option was selected
     * @param rivD The river depth
     * @param rivW The river width
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

    /**hurts the party if called
     * */
    public void noFood() {
        party.setHealth(-15);
    }
}
