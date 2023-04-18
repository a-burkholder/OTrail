/**
 * Programming 2 Oregon Trail Project
 * @author The Busy People
 * @since March 28, 2023
 *
 * Description: The Main class organizes the pre-loop methods and also contains the main loop of the game which is interated
 * after each day on the Oregon Trail.
 */
package com.example.OTrail;

public class Main {
    public static void main(String[] args) {
        //Program creates objects
        Inventory inv = new Inventory();
        Shop shop = new Shop(inv, inv.getPlayerMoneyCount());
        Map map = new Map();
        Party party = new Party(inv);
        Menu menu = new Menu(inv, party, map, shop);


        //Programs Goes through title screen and main menu items.
        menu.titleScreen();

        //Outputs the history of the trail.
        menu.introAboutTrail();

        // Loads the menu of all choices the player has before the game.
        menu.loadMainMenu();

        // Player is able to set Hattie's family members/pet names.
        menu.setNames();

        Date date = new Date(menu.startDate());
        Event event = new Event(inv, party, date);

        //Display blurb about starting cash, what they could buy, and what they should buy.  (maybe add lore here based on class)
        menu.initialCash(inv.getPlayerMoneyCount());
        shop.buyItems();
        //Display graphic for "Beginning the journey"
        inv.isWagonUsable();


        // The main loop of the Oregon Trail game. Only runs if the player is not yet at the first fort (250 miles away) and their game is not yet over.
        while((map.getPosition() <  250) && !party.getGameOverStatus())
        {
            // 10 miles travelled per day only if the wagon is usable and the game is not yet over.
            if(inv.isWagonUsable() && !party.getGameOverStatus())
            {
                map.setPosition(10);
            }

            // If river crossing
            if(map.isRiver()){
                menu.riverCrossing(event);
            }

            // Prints the progress percentage.
            map.progressBar();

            // Increments the date for each loop.
            date.setDate(1);

            // Prints the current date out for the player to see.
            date.printDate();

            // Prints out the player's health.
            party.printAllPeoplesHealth();

            // Increment weather / terrian if needed.
            map.setClimateZone();
            date.setWeather(map.getClimate());
            date.setTemp(map.getClimate());
            date.setGrass(map.getClimate());

            // Calculates the players food use.
            party.dailyFoodUsed();

            // Could generate a random number depending on the random number generated.
            event.randomEvents();

            // Lists the daily choices for the player.
            int temp = 1;
            do
            {
                temp = menu.playerDailyChoices(map);

            }while(temp == 2);


            // Increment distance to next location.
            map.getDistToLM();

            System.out.println("[========================================================================]");
        }

        if (map.getPosition() >= 250 && !party.getGameOverStatus())
        {
            System.out.println("YOU HAVE MADE IT TO THE FIRST FORT!!!");
            System.out.println("[========================================================================]");
        }
        
        else
        {
            System.out.println("YOU HAVE DIED AND DID NOT MAKE IT TO OREGON CITY!!!");
            System.out.println("[========================================================================]");
        }
    }
}