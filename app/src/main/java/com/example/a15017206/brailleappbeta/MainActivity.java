package com.example.a15017206.brailleappbeta;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String TAG = ">/>";
    ArrayList<String> arraylist_output2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doTranslateEtoB obj1 = new doTranslateEtoB();

        arraylist_output2 = obj1.separateToIndividualArrays("Ben & I LOVES eating 3 ice-creams. Don't you, Tom? RIGHT?");
        arraylist_output2 = obj1.detectCapitalisation(arraylist_output2);
        Log.i(TAG, "onCreate: " + arraylist_output2);

//   obj1.lettersToBinaryToDecimal();

//        obj1.findMatch();

        //Sample test to split words with hyphens ie. ice-cream:
        //System.out.println(Arrays.toString("a-b-c-d-".split("((?<=-)|(?=-))")));
        //System.out.println(Arrays.toString("Hello!".split("((?<=!)|(?=!))")));
    }

    class doTranslateEtoB {

        // 1. separate the strings to individual arrays
        public ArrayList separateToIndividualArrays(String input_string) {

            // 1a. Using a .split(" ")-> ["THIS" "IS" "A" "PASSAGE." "I" "LOVE" "eating" "3" "ice-creams." "Don't" "you," "Tom?"]
            ArrayList<String> arraylist_output = new ArrayList<String>(Arrays.asList(input_string.split(" ")));

            // for "-"
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains("-") && arraylist_output.get(i).length() > 1) {
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[-])|(?=[-]))")));
                    arraylist_output.remove(i);
                    for (int j = 0; j < temporary_arraylist.size(); j++) {
                        arraylist_output.add(i + j, temporary_arraylist.get(j));
                    }
                }
            }

            // for "."
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains(".") && arraylist_output.get(i).length() > 1) {
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[.])|(?=[.]))")));
                    arraylist_output.remove(i);
                    for (int j = 0; j < temporary_arraylist.size(); j++) {
                        arraylist_output.add(i + j, temporary_arraylist.get(j));
                    }
                }
            }

            // for "?"
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains("?") && arraylist_output.get(i).length() > 1) {
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[?])|(?=[?]))")));
                    arraylist_output.remove(i);
                    for (int j = 0; j < temporary_arraylist.size(); j++) {
                        arraylist_output.add(i + j, temporary_arraylist.get(j));
                    }
                }
            }

            // for ","
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains(",") && arraylist_output.get(i).length() > 1) {
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[,])|(?=[,]))")));
                    arraylist_output.remove(i);
                    for (int j = 0; j < temporary_arraylist.size(); j++) {
                        arraylist_output.add(i + j, temporary_arraylist.get(j));
                    }
                }
            }

            // for "'"
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains("'") && arraylist_output.get(i).length() > 1) {
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=['])|(?=[']))")));
                    arraylist_output.remove(i);
                    for (int j = 0; j < temporary_arraylist.size(); j++) {
                        arraylist_output.add(i + j, temporary_arraylist.get(j));
                    }
                }
            }

             System.out.println(arraylist_output);

            return arraylist_output;
            // return Integer.parseInt(c, 2);
        }

        // 2. Detect capitalisation of whole words or Capital letters only. Split to detect where passage capitalisation ends
        private ArrayList detectCapitalisation(ArrayList input_arraylist){
            boolean detect_capital_letter = false;
            boolean detect_capital_word = false;

            for (int i = 0; i<input_arraylist.size(); i++){

                //detects for capital letters in front of a word
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]\\w[a-z]*\\b", ""+input_arraylist.get(i))){
                        input_arraylist.add(i, "01");
                            i++;
                }
            }

            for (int j=0; j < input_arraylist.size(); j++){
                // detects for capital words
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]{2,}\\b", ""+input_arraylist.get(j))){

                    ArrayList<String> temp_arraylist = new ArrayList<>();
                    temp_arraylist.add("68");
                    temp_arraylist.add("68");
                    input_arraylist.addAll(j, temp_arraylist);
                    j = j+ 2;
                    Log.i(TAG, "detectCapitalisation: j is: " + j + " & the word is: " + input_arraylist.get(j));
                }
            }

            //Log.i(TAG, "detectCapitalisation: ended:" + input_arraylist);
            return input_arraylist;
        }

        @NonNull
        private String findMatch() {
            String match = "1234567890";

            // Pattern to find code
            String pattern = "[0-9]{8}";  // Sequence of 8 digits
            Pattern regEx = Pattern.compile(pattern);

            // Find instance of pattern matches
            Matcher m = regEx.matcher(match);
            if (m.find()) {
                //match = m.group(0);
                System.out.println("matched. >>" + m.group(0));
            }
            //return match;
            return "";
        }

        //Grade 1
        public void lettersToBinaryToDecimal() {
            ArrayList<String> obj = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));

            for (int i = 0; i < obj.size(); i++) {
/*                String decimal_output = wordToDecimal(obj.get(i));

                if (!decimal_output.contains(" ")){
                    int output2 = Integer.parseInt(decimal_output, 2);
                    Log.i(TAG, "lettersToBinaryToDecimal: " + obj.get(i) + " in decimal is: " + output2);
                }
                else {
                    ArrayList<String> splitted_arraylist = new ArrayList<>(Arrays.asList(decimal_output.split(" ")));
                    int output2 = 0;
                    for (int j = 0; j < splitted_arraylist.size(); j++){
                        output2 = Integer.parseInt(splitted_arraylist.get(j), 2);
                    }
                    Log.i(TAG, "lettersToBinaryToDecimal: " + output2);
                }*/

                int y = wordToDecimal(obj.get(i));
                Log.i(TAG, "lettersToBinaryToDecimal: " + obj.get(i) + " is: " + y);
            }
        }

        public int wordToDecimal(String x) {
            switch (x) {
                case "a":
                case "1":
                    return Integer.parseInt("100000", 2);
                case "b":
                case "2":
                    return Integer.parseInt("110000", 2);
                case "c":
                case "3":
                    return Integer.parseInt("100100", 2);
                case "d":
                case "4":
                    return Integer.parseInt("100110", 2);
                case "e":
                case "5":
                    return Integer.parseInt("100010", 2);
                case "f":
                case "6":
                    return Integer.parseInt("110100", 2);
                case "g":
                case "7":
                    return Integer.parseInt("110110", 2);
                case "h":
                case "8":
                    return Integer.parseInt("110010", 2);
                case "i":
                case "9":
                    return Integer.parseInt("010100", 2);
                case "j":
                case "0":
                    return Integer.parseInt("010110", 2);
                case "k":
                    return Integer.parseInt("101000", 2);
                case "l":
                    return Integer.parseInt("111000", 2);
                case "m":
                    return Integer.parseInt("101100", 2);
                case "n":
                    return Integer.parseInt("101110", 2);
                case "o":
                    return Integer.parseInt("101010", 2);
                case "p":
                    return Integer.parseInt("111100", 2);
                case "q":
                    return Integer.parseInt("111110", 2);
                case "r":
                    return Integer.parseInt("111010", 2);
                case "s":
                    return Integer.parseInt("011100", 2);
                case "t":
                    return Integer.parseInt("011110", 2);
                case "u":
                    return Integer.parseInt("101001", 2);
                case "v":
                    return Integer.parseInt("111001", 2);
                case "w":
                    return Integer.parseInt("010111", 2);
                case "x":
                    return Integer.parseInt("101101", 2);

                case "y":
                    return Integer.parseInt("101111", 2);

                case "z":
                    return Integer.parseInt("100000", 2);

//                case "capital_letter_indi":
//                    return "000001";
//                case "capital_word_indi":
//                    return "000001 000001";
            }
            return 0;
        }
    }
}

