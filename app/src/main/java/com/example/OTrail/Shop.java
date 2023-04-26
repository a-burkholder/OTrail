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
import android.content.Intent;
import android.util.Log;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;


public class Shop extends AppCompatActivity {
    public static final String POST_SHOP = "com.example.OTrail.POST_SHOP";

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
    private Party party;

    private int items = 0;
    private int amount = 0;


    final int FOODPRICE = 1;
    final int CLOTHINGPRICE = 10;
    final int BASKETPRICE = 2;
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

    public Shop()
    {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        inv = (Inventory)getIntent().getSerializableExtra("Inventory object");
        party = (Party)getIntent().getSerializableExtra("passParty");

        final TextView textView67 = (TextView)findViewById(R.id.textView67);
        final TextView textView68 = (TextView)findViewById(R.id.textView68);
        final TextView textView69 = (TextView)findViewById(R.id.textView69);
        final TextView textView70 = (TextView)findViewById(R.id.textView70);
        final TextView textView71 = (TextView)findViewById(R.id.textView71);
        final TextView textView72 = (TextView)findViewById(R.id.textView72);
        final TextView textView73 = (TextView)findViewById(R.id.textView73);
        final TextView textView74 = (TextView)findViewById(R.id.textView74);
        final TextView textView89 = (TextView)findViewById(R.id.textView89);
        final TextView moneyAmount = (TextView)findViewById(R.id.moneyAmount);

        // tells the player how many items they current have
        textView67.setText(String.valueOf(inv.getFoodCount()));
        textView68.setText(String.valueOf(inv.getClothingCount()));
        textView69.setText(String.valueOf(inv.getBasketCount()));
        textView70.setText(String.valueOf(inv.getOxenCount()));
        textView71.setText(String.valueOf(inv.getWagonWheelCount()));
        textView72.setText(String.valueOf(inv.getWagonAxleCount()));
        textView73.setText(String.valueOf(inv.getWagonTongueCount()));
        textView74.setText(String.valueOf(inv.getMedicalSupplyCount()));
        moneyAmount.setText("Money: $" + String.valueOf(inv.getPlayerMoneyCount()));

        Button buyItem = (Button) findViewById(R.id.buyItem);
        Button continueOnTheTrail = (Button) findViewById(R.id.continueOnTheTrail);

        radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        buy100 = (RadioButton) findViewById(R.id.buy100);
        buy50 = (RadioButton) findViewById(R.id.buy50);
        buy25 = (RadioButton) findViewById(R.id.buy25);
        buy10 = (RadioButton) findViewById(R.id.buy10);
        buy2 = (RadioButton) findViewById(R.id.buy2);
        buy1 = (RadioButton) findViewById(R.id.buy1);

        buyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                // Updates the amount of money the player has along with their inventory of items.
                switch (radioGroup1.getCheckedRadioButtonId()) {
                    case R.id.buyFood: {
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                        moneyUsed = moneyUsed + basketPurchased * BASKETPRICE;
                    }
                    break;
                    case R.id.buyOxen: {
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                        System.out.println(moneyUsed);

                    }
                    break;
                    case R.id.buyWagonWheel: {
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                        switch (radioGroup2.getCheckedRadioButtonId()) {
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
                else
                {
                    textView89.setText("Get out of my shop!!!");

                }
                moneyAmount.setText("Money: $" + String.valueOf(inv.getPlayerMoneyCount()));


            }
        });

        continueOnTheTrail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(POST_SHOP, inv);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }


    /**
     * Resets the player's money. Checks to make sure the player has enough money and will update the plays inventory.
     */
    public void resetItems ()
    {
        System.out.println(oxenPurchased);
        if (inv.getPlayerMoneyCount() >= moneyUsed) {
            inv.setPlayerMoneyCount(-moneyUsed);
            inv.setFoodCount(foodPurchased * 2);
            inv.setClothingCount(clothingPurchased);
            inv.setBasketCount(basketPurchased);
            inv.setOxenCount(oxenPurchased);
            inv.setWagonWheelCount(wagonWheelPurchased);
            inv.setWagonAxleCount(wagonAxlePurchased);
            inv.setWagonTongueCount(wagonTonguePurchased);
            inv.setMedicalSupplyCount(medicalSupplyPurchased);

            foodPurchased = 0;
            clothingPurchased = 0;
            basketPurchased = 0;
            oxenPurchased = 0;
            wagonWheelPurchased = 0;
            wagonAxlePurchased = 0;
            wagonTonguePurchased = 0;
            medicalSupplyPurchased = 0;
            moneyUsed = 0;
        } else {
            inv.setPlayerMoneyCount(playerMoneyCount);
        }
    }
}