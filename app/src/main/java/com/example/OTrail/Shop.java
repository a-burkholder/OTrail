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
import android.view.View;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;



import java.util.Scanner;



public class Shop extends AppCompatActivity
{
    private int playerMoneyCount = 0;
    private int foodPurchased = 0;
    private int clothingPurchased = 0;
    private int basketPurchased = 0;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        public void onRadioButtonClicked(View view)
        {
            boolean checked = ((RadioButton) view).isChecked();

                // Updates the amount of money the player has along with their inventory of items.
                switch (view.getId()) {
                    case R.id.buyFood: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                foodPurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                foodPurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                foodPurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                foodPurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                foodPurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                foodPurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + foodPurchased * FOODPRICE;
                    }
                    break;
                    case R.id.buyClothing: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                clothingPurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                clothingPurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                clothingPurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                clothingPurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                clothingPurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                clothingPurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + clothingPurchased * CLOTHINGPRICE;
                    }
                    break;
                    case R.id.buyBaskets: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                basketPurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                basketPurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                basketPurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                basketPurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                basketPurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                basketPurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + basketPurchased * BULLETSBOXPRICE;
                    }
                    break;
                    case R.id.buyOxen: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                oxenPurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                oxenPurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                oxenPurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                oxenPurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                oxenPurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                oxenPurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + oxenPurchased * OXENPRICE;
                    }
                    break;
                    case R.id.buyWagonWheel: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                wagonWheelPurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                wagonWheelPurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                wagonWheelPurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                wagonWheelPurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                wagonWheelPurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                wagonWheelPurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + wagonWheelPurchased * WAGONPARTPRICE;
                    }
                    break;
                    case R.id.buyWagonAxle: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                wagonAxlePurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                wagonAxlePurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                wagonAxlePurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                wagonAxlePurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                wagonAxlePurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                wagonAxlePurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + wagonAxlePurchased * WAGONPARTPRICE;
                    }
                    break;
                    case R.id.buyWagonTongue: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                wagonTonguePurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                wagonTonguePurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                wagonTonguePurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                wagonTonguePurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                wagonTonguePurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                wagonTonguePurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + wagonTonguePurchased * WAGONPARTPRICE;
                    }
                    break;
                    case R.id.buyMedicalSupply: {
                        switch (view.getId()) {
                            case R.id.buy100: {
                                medicalSupplyPurchased = 100;
                            }
                            break;

                            case R.id.buy50: {
                                medicalSupplyPurchased = 50;
                            }
                            break;

                            case R.id.buy25: {
                                medicalSupplyPurchased = 25;
                            }
                            break;

                            case R.id.buy10: {
                                medicalSupplyPurchased = 10;
                            }
                            break;

                            case R.id.buy2: {
                                medicalSupplyPurchased = 2;
                            }
                            break;

                            case R.id.buy1: {
                                medicalSupplyPurchased = 1;
                            }
                            break;
                            default:
                        }
                        moneyUsed = moneyUsed + medicalSupplyPurchased * MEDICALSUPPLYPRICE;
                    }
                    break;
                    default:
                }
                if (inv.getPlayerMoneyCount() > moneyUsed) {
                    resetItems();
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
            inv.setBasketCount(basketPurchased);
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