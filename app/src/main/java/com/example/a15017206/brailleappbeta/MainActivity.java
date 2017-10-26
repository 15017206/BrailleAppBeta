package com.example.a15017206.brailleappbeta;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String TAG = "";
    ArrayList<String> arraylist_output2 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doTranslateEtoB obj1 = new doTranslateEtoB();
        obj1.binaryToDecimal("Ben & I LOVES eating 3 ice-creams. Don't you, Tom?");
//        obj1.findMatch();

        //Sample test to split words with hyphens ie. ice-cream:
        //System.out.println(Arrays.toString("a-b-c-d-".split("((?<=-)|(?=-))")));
        //System.out.println(Arrays.toString("Hello!".split("((?<=!)|(?=!))")));
    }

    class doTranslateEtoB {

        // Convert from binary to decimal -eg.  1100011 to 35
        public ArrayList binaryToDecimal(String input_string) {

            // 1a. Using a .split(" ")-> ["THIS" "IS" "A" "PASSAGE." "I" "LOVE" "eating" "3" "ice-creams." "Don't" "you," "Tom?"]
            // ArrayList<String> arraylist_output = new ArrayList<String>(Arrays.asList(input_string.split(" ")));
            ArrayList<String> arraylist_output = new ArrayList<String>(Arrays.asList(input_string.split(" ")));

            // for "-"
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains("-") && arraylist_output.get(i).length() > 1 ) {
                    System.out.println(Arrays.toString(arraylist_output.get(i).split("((?<=[-])|(?=[-]))")) + " Position is: " + i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[-])|(?=[-]))")));
                    System.out.println(temporary_arraylist);
                    arraylist_output.remove(i);
                    for (int j = 0; j<temporary_arraylist.size(); j++) {
                        arraylist_output.add(i+j, temporary_arraylist.get(j));
                    }
                }
            }

            // for "."
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains(".") && arraylist_output.get(i).length() > 1 ) {
                    System.out.println(Arrays.toString(arraylist_output.get(i).split("((?<=[.])|(?=[.]))")) + " Position is: " + i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[.])|(?=[.]))")));
                    System.out.println(temporary_arraylist);
                    arraylist_output.remove(i);
                    for (int j = 0; j<temporary_arraylist.size(); j++) {
                        arraylist_output.add(i+j, temporary_arraylist.get(j));
                    }
                }
            }

            // for "?"
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains("?") && arraylist_output.get(i).length() > 1 ) {
                    System.out.println(Arrays.toString(arraylist_output.get(i).split("((?<=[?])|(?=[?]))")) + " Position is: " + i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[?])|(?=[?]))")));
                    System.out.println(temporary_arraylist);
                    arraylist_output.remove(i);
                    for (int j = 0; j<temporary_arraylist.size(); j++) {
                        arraylist_output.add(i+j, temporary_arraylist.get(j));
                    }
                }
            }

            // for ","
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains(",") && arraylist_output.get(i).length() > 1 ) {
                    System.out.println(Arrays.toString(arraylist_output.get(i).split("((?<=[,])|(?=[,]))")) + " Position is: " + i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=[,])|(?=[,]))")));
                    System.out.println(temporary_arraylist);
                    arraylist_output.remove(i);
                    for (int j = 0; j<temporary_arraylist.size(); j++) {
                        arraylist_output.add(i+j, temporary_arraylist.get(j));
                    }
                }
            }

            // for "'"
            for (int i = 0; i < arraylist_output.size(); i++) {
                // filter out full stops ie. "boy."
                if (arraylist_output.get(i).contains("'") && arraylist_output.get(i).length() > 1 ) {
                    System.out.println(Arrays.toString(arraylist_output.get(i).split("((?<=['])|(?=[']))")) + " Position is: " + i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(arraylist_output.get(i).split("((?<=['])|(?=[']))")));
                    System.out.println(temporary_arraylist);
                    arraylist_output.remove(i);
                    for (int j = 0; j<temporary_arraylist.size(); j++) {
                        arraylist_output.add(i+j, temporary_arraylist.get(j));
                    }
                }
            }

            System.out.println(arraylist_output);
            // 1b. Detect capitalisation of whole words or Capital letters only. Split to detect where passage capitalisation ends


            // 1c. Detect of special characters behind(ie. "Hello!"), in front(ie. ""), or between words(ie. "ice-cream")


            //System.out.println("this is the arraylist_output>>" + arraylist_output);


            return arraylist_output;
            // return Integer.parseInt(c, 2);
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

