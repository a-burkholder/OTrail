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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;



public class Shop extends AppCompatActivity
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

    private int items = 0;
    private int amount = 0;



    final int FOODPRICE = 1;
    final int CLOTHINGPRICE = 10;
    final int BULLETSBOXPRICE = 2;
    final int OXENPRICE = 20;
    final int WAGONPARTPRICE = 10;
    final int MEDICALSUPPLYPRICE = 2;




    RadioGroup radioGroup1;
    RadioGroup radioGroup2;

    RadioButton buyFood;
    RadioButton buyClothing;
    RadioButton buyBaskets;
    RadioButton buyOxen;
    RadioButton buyWagonWheel;
    RadioButton buyWagonAxle;
    RadioButton buyWagonTongue;
    RadioButton buyMedicalSupply;

    RadioButton buy100;
    RadioButton buy50;
    RadioButton buy25;
    RadioButton buy10;
    RadioButton buy2;
    RadioButton buy1;

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
    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();


        while(item != 9)
        {

            // Updates the amount of money the player has along with their inventory of items.
            switch (view.getId()) {
                case R.id.buyFood: {
                    switch(view.getId())
                    {
                        case R.id.buy100:
                        {
                            foodPurchased = 100;
                        }
                        break;

                        case R.id.buy50:
                        {
                            foodPurchased = 50;
                        }
                        break;

                        case R.id.buy25:
                        {
                            foodPurchased = 25;
                        }
                        break;

                        case R.id.buy10:
                        {
                            foodPurchased = 10;
                        }
                        break;

                        case R.id.buy2:
                        {
                            foodPurchased = 2;
                        }
                        break;

                        case R.id
                    }
                    moneyUsed = moneyUsed + foodPurchased * FOODPRICE;
                }
                break;
                case R.id.buyClothing: {
                    clothingPurchased = amount;
                    moneyUsed = moneyUsed + clothingPurchased * CLOTHINGPRICE;
                }
                break;
                case R.id.buyBaskets: {
                    bulletsBoxPurchased = amount;
                    moneyUsed = moneyUsed + bulletsBoxPurchased * BULLETSBOXPRICE;
                }
                break;
                case R.id.buyOxen: {
                    oxenPurchased = amount;
                    moneyUsed = moneyUsed + oxenPurchased * OXENPRICE;
                }
                break;
                case R.id.buyWagonWheel: {
                    wagonWheelPurchased = amount;
                    moneyUsed = moneyUsed + wagonWheelPurchased * WAGONPARTPRICE;
                }
                break;
                case R.id.buyWagonAxle: {
                    wagonAxlePurchased = amount;
                    moneyUsed = moneyUsed + wagonAxlePurchased * WAGONPARTPRICE;
                }
                break;
                case R.id.buyWagonTongue: {
                    wagonTonguePurchased = amount;
                    moneyUsed = moneyUsed + wagonTonguePurchased * WAGONPARTPRICE;
                }
                break;
                case R.id.buyMedicalSupply: {
                    medicalSupplyPurchased = amount;
                    moneyUsed = moneyUsed + medicalSupplyPurchased * MEDICALSUPPLYPRICE;
                }
                break;
                default:
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