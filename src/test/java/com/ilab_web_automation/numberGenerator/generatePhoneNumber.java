package com.ilab_web_automation.numberGenerator;

import java.util.Random;

public class generatePhoneNumber {

    //A method that generates the phone number to be passed into the form
    public String generate(){

        //Instantiate an object that's going to be used to generate random numbers
        Random rand = new Random();

        int countryCode = 0;
        int[] carrierId = {6,7,8};
        int afterCarrierInd = rand.nextInt(10);
        int randomIndex = rand.nextInt(carrierId.length);

        //First three digits of the phone number
        String firstThree = countryCode + "" + carrierId[randomIndex] + "" + afterCarrierInd;

        //Second three digits of the phone number
        int upperBoundForSecondThree = 1000;
        int secondThree =  rand.nextInt(upperBoundForSecondThree);


        //Last four digits of the phone number
        int upperBoundForLastFour = 10000;
        int lastFour = rand.nextInt(upperBoundForLastFour);


        //concatenate the number groups
        String phoneNumber = firstThree + " " + secondThree + " " + lastFour;


        //phoneNumber that will be returned when the method is invoked
        return phoneNumber;

    }

}
