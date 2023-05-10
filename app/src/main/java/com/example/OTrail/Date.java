package com.example.OTrail;
import java.io.Serializable;
import java.util.Random;
/**
 * ECCS: Programming 2 Oregon Trail Project
 * @author Alexnader Burkholder
 * @since March 30, 2023
 *
 * Description: This class stores date data and does all daily calculations for weather and climate
 */
public class Date implements Serializable {
    Random rand = new Random();
    //-------------variables
    private int[] date;
    private static Date instance = null;
    private int[] lastRain;
    private String currentWeather;
    private int currentTemp;
    private String currentGrass;

    //numbers taken from online historical data
    private int[][] avgTemps = {
            {30, 34, 45, 56, 65, 75, 80, 78, 69, 57, 45, 33}, // independence
            {26, 29, 39, 50, 61, 71, 75, 73, 64, 51, 38, 27},
            {23, 24, 32, 38, 48, 59, 65, 63, 54, 43, 31, 23},
            {22, 21, 31, 38, 50, 60, 65, 63, 59, 45, 35, 24},
            {25, 27, 45, 42, 51, 62, 70, 68, 58, 47, 34, 26},
            {26, 28, 37, 49, 61, 70, 74, 73, 67, 54, 42, 31} //Oregon Temps
    };

    //These numbers are calculated by taking the number of rainy days in a month divided by total days in that month
    private double[][] rainChance = {

            {11.6, 15.4, 23.2, 35, 40, 45, 35, 30, 29, 25, 19, 15},
            {10, 15, 19, 24, 38, 38, 32, 33, 25, 15, 14, 11},
            {6, 8, 11, 22, 29, 23, 22, 19, 17, 15, 10, 9},
            {20, 21, 25, 38, 41, 29, 23, 26, 19, 18, 16, 22},
            {12, 13, 14, 19, 24, 15, 11, 12, 16, 14, 13, 13},
            {26.7, 20, 23.3, 30, 33.3, 67, 26.7, 23.3, 20, 23.3, 23.3, 23.3}
    };

    //-----------------constructors

    /**Date
     * <br>default class constructor - Creates an instance of the Date class to be used in the game
     * */
    public Date(){
        int[] a = {0,0,0};
        date = a;
        currentWeather = "Clear";
        int[] b = {-1, -1, -1};
        lastRain = b;
}
    /**Date
     * <br>Class constructor - Creates an instance of the Date class to be used in the game
     * @param startDate An array of length 3 with the form: day, month, year
     * */
    public Date(int[] startDate){
        this.date = startDate;
        currentWeather = "Clear";
        int[] a = {-1, -1, -1};
        lastRain = a;
    }

    public static Date getInstance(int[] startDate)
    {
        if(instance == null)
        {
            instance = new Date(startDate);
        }
        return instance;
    }
    //-------------functionality

    /**getDate()
     * <br>The easy way to get the date out as you put it in
     * @return The date as an array of length 3 with the form: day, month, year
     * */
    public int[] getDate() {
        return this.date;
    }

    /**getDay()
     * <br>The easy way to get the day
     * @return The day as an int
     * */
    public int getDay() {return date[0];}

    /**getMonth()
     *<br>The easy way to get the month
     * @return The month as an int
     * */
    public int getMonth() {return date[1];}

    /**getYear()
     *<br>The easy way to get the year
     * @return The year as an int
     * */
    public int getYear() {return date[2];}

    /**String getWeather()
     * <br>The easy way to get the current weather
     * @return The sky's condition for the day
     * */
    public String getWeather() {
        return this.currentWeather;
    }

    /**getTemp()
     * <br>The easy way to get the temperature
     * @return The temperature, as an integer, in Fahrenheit
     * */
    public int getTemp() {
        return this.currentTemp;
    }

    /**getGrass()
     *<br>The easy way to get the grass conditions
     * @return The grass condition as a string
     * */
    public String getGrass() {
        return this.currentGrass;
    }

    /**getLastRain()
     *<br>The easy way to get the date of last rain
     * @return An integer array in the form: day, month, year
     * */
    public int[] getLastRain() {
        return lastRain;
    }

    /**setDate(int numDays)
     * <br>Easily increment the date by a given number of days
     * @param numDays The number of days passed
     * */
    public void setDate(int numDays) {
        if (this.date[1] == 0){
            this.date[1] = 1;
        }
        if (this.date[1] == 13){
            this.date[2]++;
            this.date[1] = 1;
        }
        this.date[0] = this.date[0] + numDays;

        boolean bigDay;
        if (date[1] == 2 && date[0] > 28){bigDay = true;}
        else if (date[1] > 7) {
            if (date[0]>31 && date[1]%2 == 0){bigDay = true;}
            else if (date[0] > 30 && date[1] % 2 == 1) {bigDay = true;}
            else bigDay = false;
        }
        else if (date[1] <= 7) {
            if (date[0]>31 && date[1]%2 == 1){bigDay = true;}
            else if (date[0] > 30 && date[1] % 2 == 0) {bigDay = true;}
            else bigDay = false;
        }
        else bigDay = false;


        while (bigDay){
            if (date[1]==2)
                date[0] = date[0]-28;
            else if(date[1] > 7){
                if (date[1] % 2 == 0)
                    date[0] = date[0]-31;
                else if (date[1] % 2 == 1)
                    date[0] = date[0]-30;
            }
            else if (date[1] <=7) {
                if (date[1] % 2 == 1)
                    date[0] = date[0]-31;
                else if (date[1] % 2 == 0)
                    date[0] = date[0]-30;
            }
            date[1]++;
            if (date[0]>31 && date[1]%2 == 1){bigDay = true;}
            else if (date[0]>28 && date[1] == 2){bigDay = true;}
            else if (date[0]>30 && date[1]%2 == 0){bigDay = true;}
            else bigDay = false;
        }
    }

    /**setWeather(int climateZone)
     *<br>Sets the weather conditions based on the climate at the location and time of year
     * @param climateZone The current climate the weather could be like. Provides a general range and likelihood of rain. Start at 0
     * */
    public void setWeather(int climateZone){
        int newWeather = rand.nextInt(100);
        if (newWeather>49){
            int chance = rand.nextInt(100);
            if (newWeather>90 && chance < rainChance[climateZone][date[1]]){
                currentWeather = "Heavy rain";
            }
            else if (chance < rainChance[climateZone][date[1]]) {
                currentWeather = "Rain";
            }
            else currentWeather = "Clear";
        }
        else {currentWeather = currentWeather;}

        if (currentTemp < 32 && currentWeather == "Heavy rain") {
            currentWeather = "Heavy snow";
        } else if (currentTemp < 32 && currentWeather == "rain") {
            currentWeather = "snow";
        }
        if (currentWeather.equals("Rain") || currentWeather.equals("Heavy rain")){
            lastRain[0] = date[0];
            lastRain[1] = date[1];
            lastRain[2] = date[2];
        }
    }

    /**setTemp(int climateZone)
     *<br>Sets the temperature based on the climate at the location and time of year
     * @param climateZone The current temperatures it could be like. Provides a general range of temperatures. Start at Zone 0
     * */
    public void setTemp(int climateZone) {
        int dtemp = rand.nextInt(40);

        if (dtemp < 20)
            currentTemp = avgTemps[climateZone][date[1]]- dtemp;
        else if (dtemp >= 20)
            currentTemp = avgTemps[climateZone][date[1]]+ dtemp;
    }

    /**setGrass(int climateZone)
     * <br>Currently non-functional.
     * <br>Would set the grass conditions based on recent rain and climate values
     * @param climateZone The current zone the grass should be calculated for. Start at Zone 0
     * */
    public void setGrass(int climateZone) {

    }

    /**toString()
     *<br>Converts the class to a string for easy testing
     * @return The date as a string in the form Day/Month/Year
     * */
    public String toString(){
        return Integer.toString(date[0]) + "/" + Integer.toString(date[1]) + "/" + Integer.toString(date[2]);
    }

    /**printDate()
     * <br>Prints the date with the current month, day, and year.
     */
    public void printDate() {
        System.out.println("The current data is " + date[1] + "/" + date[0] + "/" + date[2] + ".");
    }
}