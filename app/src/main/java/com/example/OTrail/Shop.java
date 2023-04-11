/**
 * Programming 2 Oregon Trail Project
 * @author Alexander Casada
 * @since March 28, 2023
 *
 * Description: This java Shop class allows the player of the
 * Oregon Trail game to buy items for their journey on the Oregon
 * Trail. This class also gets the users item type and amount in
 * order to update the player's inventory.
 */

package com.example.OTrail;
import java.util.Scanner;



public class Shop
{
    private int playerMoneyCount = 0;
    private int foodPurchased = 0;
    private int clothingPurchased = 0;
    private int bulletsBoxPurchased = 0;
    private int oxenPurchased = 0;
    private int wagonWheelPurchased = 0;
    private int wagonAxlePurchased = 0;
    private int wagonTonguePurchased = 0;
    private int medicalSupplyPurchased = 0;
    private int moneyUsed = 0;
    private Inventory inv;

    /**
     * Constructor for the Shop class.
     *
     * @param inv Inventory object used to update the player's inventory.
     * @param playerMoneyCount The amount of money the player has.
     */
    public Shop(Inventory inv, int playerMoneyCount)
    {
        this.inv = inv;
        this.playerMoneyCount = playerMoneyCount;
    }

    /**
     * Allows the player to buy items from the shops along the oregon trail. Will calculate the players total amount of
     * money spent.
     */
    public void buyItems()
    {
        Scanner in = new Scanner(System.in);

        final int FOODPRICE = 1;
        final int CLOTHINGPRICE = 10;
        final int BULLETSBOXPRICE = 2;
        final int OXENPRICE = 20;
        final int WAGONPARTPRICE = 10;
        final int MEDICALSUPPLYPRICE = 2;

        // items that can be bough from the shop
        int item = 0;

        //number of an item that the player is buying
        int amount = 0;

        while(item != 9)
        {
            // list of items that the player can buy from the Shop
            System.out.println("You can buy: \n 1: Food ($1 for 2 pounds) \n 2: Set of Clothing ($10 for one set) " +
                               "\n 3: Box of Bullets ($2 per box, 20 bullets per box) \n 4: Oxen ($20 each) \n 5: Extra " +
                               "Wagon Wheel ($10 each) \n 6: Extra Wagon Axle ($10 each) \n 7: Extra Wagon Tongue ($10 each) " +
                               "\n 8: Medical Supply Box ($2 each) \n Type '9' to exit");



            System.out.println("You have $" + (playerMoneyCount - moneyUsed));
            System.out.print("What item would you like to buy? ");
            item = in.nextInt();

            if(item !=9)
            {
                System.out.print("How many of this item do you want? ");
                amount = in.nextInt();
            }

            System.out.println("[========================================================================]");

            // Updates the amount of money the player has along with their inventory of items.
            switch(item)
            {
                case 1:
                {
                    foodPurchased = amount;
                    moneyUsed = moneyUsed + foodPurchased * FOODPRICE;
                }
                break;
                case 2:
                {
                    clothingPurchased = amount;
                    moneyUsed = moneyUsed + clothingPurchased* CLOTHINGPRICE;
                }
                break;
                case 3:
                {
                    bulletsBoxPurchased = amount;
                    moneyUsed = moneyUsed + bulletsBoxPurchased* BULLETSBOXPRICE;
                }
                break;
                case 4:
                {
                    oxenPurchased = amount;
                    moneyUsed = moneyUsed + oxenPurchased* OXENPRICE;
                }
                break;
                case 5:
                {
                    wagonWheelPurchased = amount;
                    moneyUsed = moneyUsed + wagonWheelPurchased* WAGONPARTPRICE;
                }
                break;
                case 6:
                {
                    wagonAxlePurchased = amount;
                    moneyUsed = moneyUsed + wagonAxlePurchased* WAGONPARTPRICE;
                }
                break;
                case 7:
                {
                    wagonTonguePurchased = amount;
                    moneyUsed = moneyUsed + wagonTonguePurchased* WAGONPARTPRICE;
                }
                break;
                case 8:
                {
                    medicalSupplyPurchased = amount;
                    moneyUsed = moneyUsed + medicalSupplyPurchased* MEDICALSUPPLYPRICE;
                }
                break;
                case 9:
                {
                    resetItems();
                    System.out.println("Exiting the shop...");
                    System.out.println("[========================================================================]");
                    moneyUsed = 0;
                }
                break;
                default:
                {
                    System.out.println("That is not an item!");
                    System.out.println("[========================================================================]");

                }
            }

            if(item != 9)
            {
                item = 0;
                amount = 0;
            }
        }
    }

    /**
     * Resets the player's money. Checks to make sure the player has enough money and will update the plays inventory.
     */
    public void resetItems()
    {
        if (playerMoneyCount >= moneyUsed)
        {
            inv.setPlayerMoneyCount(playerMoneyCount - moneyUsed);
            inv.setFoodCount(foodPurchased * 2);
            inv.setClothingCount(clothingPurchased);
            inv.setBulletsCount(bulletsBoxPurchased * 20);
            inv.setOxenCount(oxenPurchased);
            inv.setWagonWheelCount(wagonWheelPurchased);
            inv.setWagonAxleCount(wagonAxlePurchased);
            inv.setWagonTongueCount(wagonTonguePurchased);
            inv.setMedicalSupplyCount(medicalSupplyPurchased);
        }
        else
        {
            inv.setPlayerMoneyCount(playerMoneyCount);
            System.out.println("You do not have enough money!");
            System.out.println("Get out of my shop!!!");
        }
    }
}