/**
 * Programming 2 Oregon Trail Project
 * @author Keefer McClure
 * @since April 23, 2023
 *
 * Description: The BerryPickingMinigame class sets up a layout that allows the player to player the
 * best mini game ever created, the berry picking mini game. This mini game has a count down timer and
 * berries that the player must pick in a certain amount of time. This food will then be added to the
 * players inventory.
 */

package com.example.OTrail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class BerryPickingMinigame extends AppCompatActivity {
    public static final String RESULT = "com.example.OTrail.RESULT";
    private TextView score;
    private Inventory inv;
    int numOfBerryPicked = 0; //initial number of berries picked
    int BERRY_TIMER = 3; //how long the intro timer runs for
    int GAMETIME = 8; // how long the game runs for
    int GAMETIMEMS = GAMETIME * 1000; //GAMETIME, but in ms
    public double BERRY_DELAY = 0.6;  //seconds until berry re-appears.
    private Boolean miniGameRunning = false;
    Random rand = new Random();


    /**
     * Default constructor for the BerryPickingMinigame class.
     */
    public BerryPickingMinigame()
    {
    }

    protected void onCreate(Bundle savedInstanceState) {
        inv = (Inventory)getIntent().getSerializableExtra(BerryActivity.BERRY_TITLE_TO_GAME);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berry_picking_minigame);

        ImageButton berry1 = findViewById(R.id.imageButton);
        ImageButton berry2 = findViewById(R.id.imageButton2);
        ImageButton berry3 = findViewById(R.id.imageButton3);
        ImageButton berry4 = findViewById(R.id.imageButton4);
        ImageButton berry5 = findViewById(R.id.imageButton5);
        Button returnButton = findViewById(R.id.returnButton);
        TextView btime = findViewById(R.id.textView3);
        score = findViewById(R.id.berryscore);
        TextView counter1 = findViewById(R.id.centerTimer);

        //When berries are clicked, increase number of food collected and make them invisible for a short time.
        berry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry1);
            }
        });
        berry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry2);
            }
        });
        berry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry3);
            }
        });
        berry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry4);
            }
        });
        berry5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                berryPicked();
                moveBerry(berry5);
            }
        });

        //Last part of game "setup", sets berries invisible while intro countdown runs.
        counter1.setElevation(Float.parseFloat("40.0"));
        makeInvisible(berry1);
        makeInvisible(berry2);
        makeInvisible(berry3);
        makeInvisible(berry4);
        makeInvisible(berry5);
        // Intro title appears for 1.2 seconds
        new CountDownTimer(1200, 600) {

            @SuppressLint("SetTextI18n")
            public void onTick(long milisUntilFinished) {
                counter1.setText("Berry Picking Minigame");
                returnButton.setText("Skip Game");
            }
            //After those 1.2 seconds, the countdown begins. 3,2,1,...
            public void onFinish() {
                new CountDownTimer(1800, 600) {
                    int berrytimer = BERRY_TIMER;

                    public void onTick(long millisUntilFinished) {
                        counter1.setText(String.valueOf(this.berrytimer));
                        this.berrytimer--;
                    }
                    // After numbers countdown, output "GO!" into the text box.
                    public void onFinish() {
                        new CountDownTimer(600, 600) {

                            @SuppressLint("SetTextI18n")
                            public void onTick(long millisUntilFinished) {
                                counter1.setText("Go!!");
                                returnButton.setVisibility(View.INVISIBLE);
                                returnButton.setClickable(false);
                            }


                            //Finally, Text has finished up.
                            //Once intro finishes, make the berries visible and BEGIN THE GAME.
                            //For "GAMETIME", run the game, allowing berries to be clicked and food to increase.
                            public void onFinish() {
                                makeVisible(berry1);
                                makeVisible(berry2);
                                makeVisible(berry3);
                                makeVisible(berry4);
                                makeVisible(berry5);
                                counter1.setVisibility(View.INVISIBLE);
                                counter1.setElevation(Float.parseFloat("-40.0"));
                                miniGameRunning = true;

                                new CountDownTimer(GAMETIMEMS + 1000, 1000) {
                                    public void onTick(long millisUntilFinished) {
                                        btime.setText(String.valueOf(millisUntilFinished / 1000));

                                    }

                                    //Once the timer runs out, the GAME FINISHES.
                                    //Berries turn invisible and you are shown your score.
                                    //Final on tick loop completed.
                                    @SuppressLint("SetTextI18n")
                                    public void onFinish() {
                                        miniGameRunning = false;
                                        makeInvisible(berry1);
                                        makeInvisible(berry2);
                                        makeInvisible(berry3);
                                        makeInvisible(berry4);
                                        makeInvisible(berry5);
                                        counter1.setElevation(Float.parseFloat("40"));
                                        counter1.setVisibility(View.VISIBLE);
                                        counter1.setText("Finished!" + "\nTotal Collected Berries: " + numOfBerryPicked*5);
                                        returnButton.setText("Continue");
                                        returnButton.setVisibility(View.VISIBLE);
                                        returnButton.setClickable(true);
                                        miniGameRunning = false;
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();

        //Once game is over, wait for the return button to be pressed
        //This button will increase the inventory's food count based on score, with a hard limit imposed if no baskets are in the inventory.
        //Once inventory is increased, return to previous intent and completely exit from the minigame.
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("num berries picked = " + numOfBerryPicked);

                if (inv.getBasketCount() > 0) {
                    inv.setBasketCount(-1);
                }
                else {
                    if (numOfBerryPicked > 10) {
                        numOfBerryPicked = 10;
                    }
                }
                inv.setFoodCount(numOfBerryPicked * 5);

                System.out.println("Food count = " + inv.getFoodCount());

                Intent resultIntent = new Intent();
                resultIntent.putExtra(RESULT, inv);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    /**berryPicked
     * Increases the stored # of berries picked along with the visible score.
     */
    private void berryPicked() {
        if (miniGameRunning) {
            numOfBerryPicked++;
            score.setText(String.valueOf(numOfBerryPicked * 5));
        }
    }

    /**moveBerry
     * This function is triggered when a berry is clicked in the game.
     * First, make the image invisible
     * Then, after "BERRY_DELAY" number of seconds, make the berry re-appear.
     * Note: Function checks if game is running before making berry visible again (bug fix).
     * Note: Initially, this function would move the berry around, but this function was scratched.
     * @param img
     */
    private void moveBerry(ImageButton img) {
        makeInvisible(img);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (miniGameRunning) {
                    makeVisible(img);
                }
            }
        }, (int) (BERRY_DELAY * 1000));
    }

    /** makeVisible
     * Sets the elevation to the front and allows the image to be visible.
     * @param img
     */
    private void makeVisible(ImageButton img) {
        img.setElevation(Float.parseFloat("1"));
        img.setVisibility(View.VISIBLE);
    }

    /** makeInisible
     * Sets the elevation to the back and forces the image to be invisible to the player.
     * @param img
     */
    private void makeInvisible(ImageButton img) {
        img.setElevation(Float.parseFloat("-10"));
        img.setVisibility(View.INVISIBLE);

    }
}