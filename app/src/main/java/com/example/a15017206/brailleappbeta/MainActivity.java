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

    String TAG = ">>";
    ArrayList<String> arraylist_output2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doTranslateEtoB obj1 = new doTranslateEtoB();
        arraylist_output2 = obj1.separateToIndividualArrays("Ben & I LOVES eating 3 ice-creams. Don't you, Tom? RIGHT?");
        obj1.detectCapitalisation(arraylist_output2);

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
        private String detectCapitalisation(ArrayList input_arraylist){

            Log.i(TAG, "detectCapitalisation: "+ input_arraylist);

            boolean detect_capital_letter = false;
            boolean detect_capital_word = false;

            for (int i = 0; i<input_arraylist.size(); i++){

                //detects for capital letters in front of a word
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]\\w[a-z]*\\b", ""+input_arraylist.get(i))){
                        input_arraylist.add(i, 64);
                            i++;
                }


                // detects for capital words
//                else if (detect_capital_word = Pattern.matches("\\b[A-Z]{2,}\\b", ""+input_arraylist.get(i))){
//                    Log.i(TAG, "detectCapitalisation: true2   " + input_arraylist.get(i) + " position: " + i);
//                }
            }

            for (int j=0; j < input_arraylist.size(); j++){
                // detects for capital words
                if (detect_capital_letter = Pattern.matches("\\b[A-Z]{2,}\\b", ""+input_arraylist.get(j))){
                    input_arraylist.add(j, 65);
                    j++;
                }
            }

            Log.i(TAG, "detectCapitalisation: ended:" + input_arraylist);
            return "";
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
                //String decimal_output = wordToDecimal(obj.get(i));
                //int output2 = Integer.parseInt(decimal_output, 2);
            }
        }

        public String wordToDecimal(String x) {
            switch (x) {
                case "a":
                case "1":
                    return "100000";
                case "b":
                case "2":
                    return "110000";
                case "c":
                case "3":
                    return "100100";
                case "d":
                case "4":
                    return "100110";
                case "e":
                case "5":
                    return "100010";
                case "f":
                case "6":
                    return "110100";
                case "g":
                case "7":
                    return "110110";
                case "h":
                case "8":
                    return "110010";
                case "i":
                case "9":
                    return "010100";
                case "j":
                case "0":
                    return "010110";
                case "k":
                    return "101000";
                case "l":
                    return "111000";
                case "m":
                    return "101100";
                case "n":
                    return "101110";
                case "o":
                    return "101010";
                case "p":
                    return "111100";
                case "q":
                    return "111110";
                case "r":
                    return "111010";
                case "s":
                    return "011100";
                case "t":
                    return "011110";
                case "u":
                    return "101001";
                case "v":
                    return "111001";
                case "w":
                    return "010111";
                case "x":
                    return "101101";
                case "y":
                    return "101111";
                case "z":
                    return "101011";
            }
            return "";
        }
    }
}

