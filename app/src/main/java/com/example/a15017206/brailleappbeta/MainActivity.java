package com.example.a15017206.brailleappbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String TAG = ">/>";
    ArrayList<String> arraylist_output2 = new ArrayList<>();
    ArrayList<String> arraylist_output3 = new ArrayList<>();
    ArrayList<String> arraylist_output4 = new ArrayList<>();
    ArrayList<String> arraylist_output5 = new ArrayList<>();

    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView4 = (TextView) findViewById(R.id.textView4);

        doTranslateEtoB obj1 = new doTranslateEtoB();

        arraylist_output2 = obj1.separateToIndividualArraysWord("32 fish");

        // testing purposes only
//        String x = obj1.lettersToBinaryToDecimal();
//textView4.setText(x);

        arraylist_output2 = obj1.detectNumbers(arraylist_output2);
        arraylist_output2 = obj1.detectCapitalisation(arraylist_output2);
        arraylist_output2 = obj1.separateToIndividualArraysLetter(arraylist_output2);
        arraylist_output2 = obj1.convertLettersAndNumbersToBinary(arraylist_output2);
//arraylist_output2 = obj1.binaryToDecimal(arraylist_output2);

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
            return arraylist_output;
            // return Integer.parseInt(c, 2);
        }

        // 1.b? BETA: detect numbers - method is hardcoded for grade 1
        public ArrayList detectNumbers(ArrayList input_arraylist) {
            for (int i = 0; i < input_arraylist.size(); i++) {
                String x = input_arraylist.get(i) + "";

                // If string x is a number
                if (x.matches("\\d+")) {
                    ArrayList<String> temp_arraylist = new ArrayList<>(Arrays.asList(x.split("")));
                    temp_arraylist.remove(0);
                    input_arraylist.remove(i);

                    input_arraylist.addAll(i, temp_arraylist);
                    input_arraylist.add(i, "001111");
                    i = i + temp_arraylist.size();

                    if (true){
                        input_arraylist.add("xxx");
                    }
                }
            }
            return input_arraylist;
        }


        // 2. Detect capitalisation of whole words or Capital letters only. Split to detect where passage capitalisation ends
        private ArrayList detectCapitalisation(ArrayList input_arraylist) {
            boolean detect_capital_letter = false;
            boolean detect_capital_word = false;

            for (int i = 0; i < input_arraylist.size(); i++) {

                //detects for capital letters in front of a word
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]{1}[a-z]{1,}\\b", "" + input_arraylist.get(i))) {
                    input_arraylist.add(i, "000001");
                    i++;
                }
            }

            for (int j = 0; j < input_arraylist.size(); j++) {
                // detects for capital words
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]{2,}\\b", "" + input_arraylist.get(j))) {

                    ArrayList<String> temp_arraylist = new ArrayList<>();
                    temp_arraylist.add("000001");
                    temp_arraylist.add("000001");
                    input_arraylist.addAll(j, temp_arraylist);
                    j = j + 2;
//                    Log.i(TAG, "detectCapitalisation: j is: " + j + " & the word is: " + input_arraylist.get(j));
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
        private ArrayList convertLettersAndNumbersToBinary(ArrayList input_arraylist3) {
            ArrayList<String> temp_arraylist = new ArrayList<>();
            for (int i = 0; i < input_arraylist3.size(); i++) {
                String x = input_arraylist3.get(i) + "";
                if (x.matches("\\b[A-Za-z0-9]\\b|\\bnumeric_indic\\b|\\bcaps\\b")) {
                    temp_arraylist.add("" + wordToBinary(x));
                } else {
                    temp_arraylist.add(x);
                }
            }
            Log.i(TAG, "convertLettersToDecimals: " + temp_arraylist);
            return temp_arraylist;
        }


        public String wordToBinary(String x) {
            switch (x.toLowerCase()) {
                case "a":
                case "1":
//                    return Integer.parseInt("100000", 2); //32
                    return "100000";
                case "b":
                case "2":
//                    return Integer.parseInt("110000", 2); //48
                    return "110000";
                case "c":
                case "3":
//                    return Integer.parseInt("100100", 2); //36
                    return "100100";
                case "d":
                case "4":
//                    return Integer.parseInt("100110", 2); //38
                    return "100110";
                case "e":
                case "5":
//                    return Integer.parseInt("100010", 2); //34
                    return "100010";
                case "f":
                case "6":
//                    return Integer.parseInt("110100", 2); //52
                    return "110100";
                case "g":
                case "7":
//                    return Integer.parseInt("110110", 2); //54
                    return "110110";
                case "h":
                case "8":
//                    return Integer.parseInt("110010", 2); //50
                    return "110010";
                case "i":
                case "9":
//                    return Integer.parseInt("010100", 2); //20
                    return "010100";
                case "j":
                case "0":
//                    return Integer.parseInt("010110", 2); //22
                    return "010110";
                case "k":
//                    return Integer.parseInt("101000", 2); //40
                    return "101000";
                case "l":
//                    return Integer.parseInt("111000", 2); //56
                    return "111000";
                case "m":
//                    return Integer.parseInt("101100", 2); //44
                    return "101100";
                case "n":
//                    return Integer.parseInt("101110", 2); //46
                    return "101110";
                case "o":
//                    return Integer.parseInt("101010", 2); //42
                    return "101010";
                case "p":
//                    return Integer.parseInt("111100", 2); //60
                    return "111100";
                case "q":
//                    return Integer.parseInt("111110", 2); //62
                    return "111110";
                case "r":
//                    return Integer.parseInt("111010", 2); //58
                    return "111010";
                case "s":
//                    return Integer.parseInt("011100", 2); //28
                    return "011100";
                case "t":
//                    return Integer.parseInt("011110", 2); //30
                    return "011110";
                case "u":
//                    return Integer.parseInt("101001", 2); //41
                    return "101001";
                case "v":
//                    return Integer.parseInt("111001", 2); //57
                    return "111001";
                case "w":
//                    return Integer.parseInt("010111", 2); //23
                    return "010111";
                case "x":
//                    return Integer.parseInt("101101", 2); //45
                    return "101101";
                case "y":
//                    return Integer.parseInt("101111", 2); //47
                    return "101111";
                case "z":
//                    return Integer.parseInt("101011", 2); //32
                    return "101011";
                case ",":
//                    return Integer.parseInt("010000", 2);
                    return "010000";
                case "Caps":
//                    return Integer.parseInt("000001", 2);
                    return "000001";
                case "numeric_indic":
//                    return Integer.parseInt("001111", 2);
                    return "001111";
            }
            return "shouldnt come here";
        }

        public int binaryToDecimal(String y) {
            switch (y) {
                case "100000": // a/1
                    return Integer.parseInt("100000", 2); //32;
            }
            return 0;
        }

        //Grade 1 - testing purposes only
        public String lettersToBinaryToDecimal() {
            ArrayList<String> obj = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Caps", ",", "numeric_indic"));

            String x = "";

            for (int i = 0; i < obj.size(); i++) {
                int y = Integer.parseInt(wordToBinary(obj.get(i)));
                Log.i(TAG, "lettersToBinaryToDecimal: " + obj.get(i) + " in decimal form is: " + y);
                x = x + obj.get(i) + " in decimal form is: " + y + "\n";
            }

            return x;
        }
    }
}

