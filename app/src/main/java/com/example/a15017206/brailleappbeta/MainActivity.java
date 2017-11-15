package com.example.a15017206.brailleappbeta;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String TAG = ">/>";
    ArrayList<String> arraylist_output2 = new ArrayList<>();
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView4 = (TextView) findViewById(R.id.textView4);

        doTranslateEtoB obj1 = new doTranslateEtoB();

        arraylist_output2 = obj1.separateToIndividualArraysWord("and AND");

        // testing purposes only
//        String x = obj1.lettersToBinaryToDecimal();
//textView4.setText(x);


        arraylist_output2 = obj1.detectCapitalisation(arraylist_output2);
        arraylist_output2 = obj1.separateToIndividualArraysLetter(arraylist_output2);
        arraylist_output2 = obj1.convertLettersToDecimals(arraylist_output2);


        Log.i(TAG, "onCreate: " + arraylist_output2);
    }

    class doTranslateEtoB {

        // 1. separate the strings to individual words
        public ArrayList separateToIndividualArraysWord(String input_string) {

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

        // 1.b? BETA: detect numbers
        public void detectNumbers(ArrayList input_arraylist){

        }

        // 2. Detect capitalisation of whole words or Capital letters only. Split to detect where passage capitalisation ends
        private ArrayList detectCapitalisation(ArrayList input_arraylist) {
            boolean detect_capital_letter = false;
            boolean detect_capital_word = false;

            for (int i = 0; i < input_arraylist.size(); i++) {

                //detects for capital letters in front of a word
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]{1}[a-z]{1,}\\b", "" + input_arraylist.get(i))) {
                    input_arraylist.add(i, "1");
                    i++;
                }
            }

            for (int j = 0; j < input_arraylist.size(); j++) {
                // detects for capital words
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]{2,}\\b", "" + input_arraylist.get(j))) {

                    ArrayList<String> temp_arraylist = new ArrayList<>();
                    temp_arraylist.add("1");
                    temp_arraylist.add("1");
                    input_arraylist.addAll(j, temp_arraylist);
                    j = j + 2;
                    Log.i(TAG, "detectCapitalisation: j is: " + j + " & the word is: " + input_arraylist.get(j));
                }
            }

            //Log.i(TAG, "detectCapitalisation: ended:" + input_arraylist);
            return input_arraylist;
        }

        //This is used for Uncontracted Braille
        private ArrayList separateToIndividualArraysLetter(ArrayList input_arraylist2) {

            // Log.i(TAG, "separateToIndividualArraysLetter: " + input_arraylist2);
            for (int i = 0; i < input_arraylist2.size(); i++) {

                // check if the index contains a legit word
                if (Pattern.matches("\\b[A-Z | a-z]{2,}\\b", "" + input_arraylist2.get(i))) {

                    // This is assumed to be in grade 1 Braille
                    String x = "" + input_arraylist2.get(i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(x.split("")));
                    temporary_arraylist.remove(0);
                    input_arraylist2.addAll(i, temporary_arraylist);
                    input_arraylist2.remove(i + temporary_arraylist.size());
                    // i = i + temporary_arraylist.size();
                }

            }
            return input_arraylist2;
        }

        // Grade 1:
        private ArrayList convertLettersToDecimals(ArrayList input_arraylist3) {
            ArrayList<String> temp_arraylist = new ArrayList<>();
            for (int i = 0; i < input_arraylist3.size(); i++) {
                String x = input_arraylist3.get(i) + "";
//                if (x.contains("0") || x.contains("1") ){
                temp_arraylist.add("" + wordToDecimal(x));
//                }


            }
            Log.i(TAG, "convertLettersToDecimals: " + temp_arraylist);
            return temp_arraylist;
        }

        //Grade 1
        public String lettersToBinaryToDecimal() {
            ArrayList<String> obj = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Caps", ",", "numeric_indic"));

            String x = "";

            for (int i = 0; i < obj.size(); i++) {
                int y = wordToDecimal(obj.get(i));
                Log.i(TAG, "lettersToBinaryToDecimal: " + obj.get(i) + " in decimal form is: " + y);
                x = x + obj.get(i) + " in decimal form is: " + y + "\n";
            }

            return x;
        }

        public int wordToDecimal(String x) {
            switch (x.toLowerCase()) {
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
                case ",":
                    return Integer.parseInt("010000", 2);
                case "Caps":
                    return Integer.parseInt("000001", 2);
                case "numeric_indic":
                    return Integer.parseInt("001111", 2);
            }
            return 0;
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
    }
}

