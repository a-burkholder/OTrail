/**
 * Programming 2 Oregon Trail Project
 * @author Keefer McClure
 * @since March 28, 2023
 *
 * Description: The Menu class contains the text based Oregon Trail information and user inputs for all the different menu
 * choices that the user can make in the Oregon Trail game.
 */
package com.example.OTrail;

import java.util.Random;
import java.util.Scanner;


public class Menu {
    //Variables
    private Inventory inv;
    private Party party;
    private Map map;
    private Shop shop;

    /**
     * Default constructor for the Menu class.
     */
    public Menu()
    {

    }

    /** Constructor for the Menu class.
     *
     * @param inv The inventor object for the program.
     * @param party Party object for the game.
     * @param map Map object for the game.
     * @param shop Shop object for the game.
     */
    public Menu(Inventory inv, Party party, Map map, Shop shop)
    {
        this.inv = inv;
        this.party = party;
        this.map = map;
        this.shop = shop;
    }


    /**Title Screen
     * Sets title screen
     */
    public void titleScreen()
    {
        System.out.println("[========================================================================]");
        System.out.println("""
                ░▀▀█▀▀░█░░░░█▀▀░░░▒█▀▀▀█░█▀▀▄░█▀▀░█▀▀▀░▄▀▀▄░█▀▀▄░░░▀▀█▀▀░█▀▀▄░█▀▀▄░▀█▀░█░░
                ░░▒█░░░█▀▀█░█▀▀░░░▒█░░▒█░█▄▄▀░█▀▀░█░▀▄░█░░█░█░▒█░░░░▒█░░░█▄▄▀░█▄▄█░░█░░█░░
                ░░▒█░░░▀░░▀░▀▀▀░░░▒█▄▄▄█░▀░▀▀░▀▀▀░▀▀▀▀░░▀▀░░▀░░▀░░░░▒█░░░▀░▀▀░▀░░▀░▀▀▀░▀▀▀
                 By: A. Burkholder, A. Casada, A. Guzman, and K. McClure\s""");
        System.out.println("[========================================================================]");
    }

    /**Load Main Menu
     * Sets the display for the main menu, does NOT receive inputs or give outputs.
     *      1. Travel the trail
     *      2. Learn about the trail
     *      3. See the Oregon Top Ten
     *      4. Choose Management Options
     *      5. End
     */
    public void loadMainMenu()
    {
        Scanner userIn = new Scanner(System.in); //Set up Scanner
        int userInput = 0;
        do {
            System.out.println("""
                   Main Menu: Choose from the options below to continue.\s
                        *      1. Travel the trail
                        *      2. Learn about the trail
                        *      3. Learn about Hattie Campbell
                        *      4. See the Oregon Top Ten
                        *      5. Visit the Graveyard
                        *      6. Choose Management Options
                   """);
            System.out.println("[========================================================================]");
            userInput = userIn.nextInt();
            switch (userInput) {
                case 1 -> {
                    //Start the Oregon Trail
                }
                case 2 -> {
                    learnAboutTrail();
                }
                case 3 -> {
                    learnAboutHattie();
                }
                case 4 -> {
                    System.out.println("Reference the soon-to-be-made top 10 class and retrieve the list of top 10 pioneers");
                    System.out.println("[========================================================================]");
                    continu();
                }
                case 5 -> {
                    System.out.println("Reference the gravestones list and tell the user where people died.");
                    System.out.println("[========================================================================]");
                    continu();
                }
                case 6 -> {
                    System.out.println("Provide options to the user");
                    System.out.println(" 1. Choose to reset the top 10 list to default");
                    System.out.println(" 2. Choose to reset the gravestones to default");
                    System.out.println(" 3. Change something aesthetic of the game.");
                    System.out.println(" 4. IDK what other options we want.");
                    System.out.println("[========================================================================]");
                    continu();
                }
                default -> {
                }
            }
        }while (userInput != 1);
    }

    /**Intro about trail
     * Short intro before main menu.
     */
    public void introAboutTrail()
    {
        System.out.println("""
               About the Oregon Trail:
                The Oregon Trail was a legendary 2170 mile stretch of land from Independence, Missouri to Oregon City, Oregon.
                This was no simple road trip for those who wanted to experience the west, and many people faced extreme hardships along the way.

                Today you will be carving your own path on the trail, playing in the shoes of 13 year old Hattie Campbell.
                Will you aid your family in making it to Oregon, or will you be one of the 20,000 individuals to lose their life on the trail?
               """);
        System.out.println("[========================================================================]");
        continu();
    }

    /**Learn about Trail
     * Displays the "Learn about the trail" text to inform the user about the trail.
     */
    public void learnAboutTrail()
    {
        System.out.println("""
                About the Oregon Trail:
                 The Oregon Trail was a legendary 2170 mile stretch of land from Independence, Missouri to Oregon City, Oregon.
                 In the early 1800s, the trail was utilized by fur traders, only traveling the tail on horseback.
                 By 1836, wagon trains from Independence, Missouri began clearing the trail to Oregon.\s
                 As the years went on, roads, bridges, and ferries were built to speed up the journey.\s
                 In the 1840's, the Organic Laws of Oregon promised free land to any settlers who chose to move to Oregon.
                 The term "Manifest Destiny" was coined to describe the thousands of families who traveled the trails, inspired by that very promise.
                 Many other families were inspired by the California Gold rush in 1848, inspired from the promise of riches.
                 By the 1860's, many were traveling on ferries, with rivers and canals bring created to aid the pioneers.
                 Finally, in 1869, the transcontinental railroad was completed, leading many to chose it over the trail.
                 """);
        continu();
        System.out.println("""
                While natural hazards and dangerous river crossings were very common along the trail, many emigrants feared
                contact with Native Americans. However, this fear was often misplaced, as contact was rare, and not always
                hostile.  The emigrants were far more likely to die from accidents; diseases, such as cholera and typhoid;
                starvation; drowning while attempting a river crossing; or the perils of an unexpected blizzard. The wagon
                trains often encountered grass fires, hailstorms, floods, and other powerful forces of nature.
                                
                At least 27 different Indian tribes lived near the Oregon Trail, with most offering trades with the
                emigrants, and only a small portion choosing to stealing small portions of supplies. Because the emigrants
                were ignorant about Indian cultures, they often behaved in an unnecessarily hostile manner toward the Indians.
                """);
        continu();
        System.out.println("""   
                There was rarely any medical care available on the trail, so they would pack primitive medicinals and remedies
                like laudanum (an opium medicinal) and camphor for general ailments, quinine, castor oil, and harts horn for
                snakebites.The cost of the entire trip, to outfit and transport each family, was about five hundred dollars.
                
                Though there was very little formal schooling, children learned a great deal — from how to care for animals
                to the names of flowers. Women and teenage girls worked extremely hard. In addition to cooking and caring for
                the younger children, they also pitched tents, built fires, drove oxen, protected camp, and assumed other
                traditionally male duties.
                
                Most emigrants walked next to their covered wagons, rather than riding, so that the livestock would have less
                weight to pull, and because there was very little room to sit inside. Firewood was always scarce, and during
                the day, women and children collected weeds and buffalo chips (dung) to use to heat their evening meal.
                                
                """);
        System.out.println("[========================================================================]");
        continu();
    }


    /**Learn about Hattie
     * Displays a picture of Hattie Campbell.
     */
    public void learnAboutHattie()
    {
        System.out.println("""
               Hattie Campbell is a 13 year old pioneer, eldest child to Charles and Augusta Campbell,
               spending her time helping on the farm and keeping an eye on her two younger brothers.
               Leaving from Independence, Missouri in 1847, Hattie and her family are joining
               the Great Migration to Oregon. Their simple farm life had been uprooted by overcrowding,
               high taxes, and annual rounds of the deadly swamp fever.
               """);
        continu();
        System.out.println("""   
               Over the past few months, Hattie's father, Charles Campbell, shares his passion for
               traveling the Oregon Trail, buying booklets about the journey and speaking of partaking
               in a part of America's "Manifest Destiny." However, Hattie's mother continues to share
               her fears of the trail, warning of the death toll and tearing up when thinking about
               how she will never see her sisters again.
             """);
        continu();
        System.out.println("""
               In March, Hattie's father sold the house, chickens, three horses, and a cow to a neighbor
               for $65, which when added their original savings and a riverboat passage to Independence,
               Missouri, should be enough to get them to Oregon.
                 """);
        System.out.println("[========================================================================]");
        continu();
    }

    /** Player Daily Choices
     * Blah Blah Blah
     */
    public int playerDailyChoices(Map map)
    {
        Scanner in = new Scanner(System.in);
        int option = 1;
        System.out.println("What would you like to do? \n1. Continue on the trail. \n2. Check your supplies.");
        if(map.isShop())
        {
            System.out.println("3. Go to the Shop.");
        }
        option = in.nextInt();
        if(option == 2)
        {

        }
        else if(option == 1)
        {
            System.out.println("You are continuing along the Oregon Trail.");
        }
        else if(option == 3 && map.isShop())
        {
//            shop.buyItems();
        }
        else
        {
            System.out.println("That is not an option, but your family chooses to continue on the trail.");
        }
        return option;
    }

    /**
     * See Top Ten
     * Displays the top ten expeditions on the menu, both names and scores.
     * Asks if we would like to see how points are earned.
     * Y - display how points are earned, then return to main menu
     * n - return to main menu
     */
    public void seeTopTen()
    {
        //display top 10 scores
        //tell them how to get a better score
    }

    /**Choose Management Options
     */
    public void chooseManagementOptions()
    {
        //See Current Top Ten List
        //     *      See Original Top Ten List
        //     *      Erase Current Top Ten List
        //     *      Erase Tombstone Messages
        //     *      Toggle Pictures (Turns off the fun photos we added for each fort)
        //     *      Return to the Main Menu.
    }

    /**setStartDate
     * Displays the date selection screen.
     *    ex: "Choose A Starting Month:" then placing all months in a numbered list.
     * Asks user to choose a month to depart.
     * Asks the user if they are sure.
     * @return int[3] (the date: DAY, MONTH (int), YEAR)
     */
    public int[] startDate()
    {
        boolean validInput = false;
        int[] date = new int[3];
        System.out.println("""
               Choose A Starting Month (type number)
               1. March
               2. April
               3. May
               4. June
               5. July
               6. August
               7. September""");


        Scanner in = new Scanner(System.in);    //Set up Scanner
        int input = 0;                          //initialize input
        input =  in.nextInt();            //gets next integer input as input.


        date[0] = 1;    //Set day
        date[1] = 4;    //Set initial month in case of error
        date[2] = 1847; //Set Year
        do {
            switch (input) {
                case 1 -> {
                    date[1] = 3;
                    validInput = true;
                } // March
                case 2 -> {
                    date[1] = 4;
                    validInput = true;
                } // April
                case 3 -> {
                    date[1] = 5;
                    validInput = true;
                } // May
                case 4 -> {
                    date[1] = 6;
                    validInput = true;
                } // June
                case 5 -> {
                    date[1] = 7;
                    validInput = true;
                } // July
                case 6 -> {
                    date[1] = 8;
                    validInput = true;
                } // August
                case 7 -> {
                    date[1] = 9;
                    validInput = true;
                } // September
                default -> {
                    validInput = false;
                }
            }
        }while (validInput = false); // Set Month

        System.out.println("\nYour journey shall begin on " + date[1] + "-" + date[0] + "-" + date[2] + ".\n[=========================================================================]");
        continu();
        return date;
    }

    /**Sets Names
     * Sets the inital names for the game.
     */
    public void setNames()
    {
        String names[] = new String[5];
        names[0] = "Hattie";
        Scanner in = new Scanner(System.in);
        System.out.println("What are the names of your family members (2, 3, 4) and your pet (5)?");
        System.out.println("(1) Hattie Campbell");
        for(int i = 1; i <names.length; i++)
        {
            System.out.print("(" + (i+1) + ") ");
            names[i] = in.nextLine();
        }

        System.out.println("[========================================================================]");
        party.setNames(names);
    }

    /**Initial Cash
     * Displays the "Here is your initial cash" Screen:
     *      Display in-depth motive for leaving oregon
     *      Display Spendable Cash
     *      Provide descriptions for items available in the shop
     *      Provide hints for the trail.
     */
    public void initialCash(int playerMoneyCount)
    {
        System.out.println("Every family has their own reason for leaving for Oregon, but our family is hoping to escape the overcrowding here in Louisiana.\nOur father, a banker, has stored us a healthy " + playerMoneyCount +  "$ for our trip... hopefully he spends it well.\nThe Clerk at the store told us to stock up on Oxen, Bullets, and medicine.\nWe were told only those with the speed of one hundred horses, the hunting spirit of Kit Carson, and plentiful medicine would make it to Oregon.\nHopefully his words hold true, but he wouldn't be the first to trying and swindle us out the last of our savings...");
        System.out.println("""
               You are about to visit the General Store, the cheapest shop along the oregon trail.   
               In the shop, you can buy:\s   
                 
               1. Food - Feeds party members, can be obtained at traders or through hunting  
               2. Clothing - Protection from the weather 
               3. Box of Bullets - For hunting and protection from bandits   
               4. Oxen - Determines the speed of wagon (minimum: 4). Be wary of Oxen health.\s   
               5. Wagon Wheel - For Repairs, Trades, or Sale 
               6. Wagon Axle - For Repairs, Trades, or Sale  
               7. Wagon Tongue -  For Repairs, Trades, or Sale   
               8. Medical Supply Box - For healing the diseased and preventing death 
                 
                  (Press 0 to continue to the shop)""");
        Scanner in = new Scanner(System.in);    //Set up Scanner
        int input = 2;                          //initialize input
        input =  in.nextInt();                  //gets next integer input as input.
        boolean validinput = false;             //sets up toggleable variable
        do {
            validinput = input == 0;
        }while(!validinput);
        System.out.println("[=========================================================================]");
    }



    /**Continue Class
     * Adds: "submit "0" to continue"
     * Once zero is submitted, code finishes.
     */
    public void continu()
    {
        System.out.println("    Submit \"0\" to continue.");
        Scanner inContinu = new Scanner(System.in);    //Set up Scanner
        int input = 99;                          //initialize input
        boolean validinput = false;             //sets up toggleable variable
        do {
            input =  inContinu.nextInt();                  //gets next integer input as input.
            validinput = input == 0;
        }while(!validinput);
        System.out.println("[========================================================================]");
    }
}
