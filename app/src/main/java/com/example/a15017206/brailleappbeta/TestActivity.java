package com.example.a15017206.brailleappbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TestActivity extends AppCompatActivity {

    String TAG = ">/>";

    TextView tvOutput;
    EditText etInput;
    Button btnDoTranslate;
    String output = "";
    ArrayList<String> arraylist_output2;
    Boolean numericMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tvOutput = (TextView) findViewById(R.id.tvOutput);
        etInput = (EditText) findViewById(R.id.etInput);
        btnDoTranslate = (Button) findViewById(R.id.btnDoTranslate);

        final doTranslateEtoB obj1 = new doTranslateEtoB();

//        etInput.setText("Prof Ito");

        btnDoTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output = "";
                arraylist_output2 = obj1.separateToIndividualArraysWord(etInput.getText().toString());
                output += arraylist_output2 + "\n\n";
                arraylist_output2 = obj1.detectNumbers(arraylist_output2);
                output += arraylist_output2 + "\n\n";
                arraylist_output2 = obj1.detectCapitalisation(arraylist_output2);
                output += arraylist_output2 + "\n\n";
                arraylist_output2 = obj1.separateToIndividualArraysLetter(arraylist_output2);
                output += arraylist_output2 + "\n\n";
                arraylist_output2 = obj1.convertLettersAndNumbersToBinary(arraylist_output2);
                output += arraylist_output2 + "\n\n";
                arraylist_output2 = obj1.convertBinaryToDecimals(arraylist_output2);
                output += arraylist_output2 + "\n\n";
                tvOutput.setText(output);
            }
        });
//        btnDoTranslate.performClick();
    }

    class doTranslateEtoB {

        public ArrayList separateToIndividualArraysWord(String input_string0) {

            // 1a. Using a .split(" ")-> ["THIS" "IS" "A" "PASSAGE." "I" "LOVE" "eating" "3" "ice-creams." "Don't" "you," "Tom?"]
//            ArrayList<String> arraylist_output = new ArrayList<String>(Arrays.asList(input_string0.split(" ")));

            String[] temp_array = input_string0.split(" ");
            Log.i(TAG, "separateToIndividualArraysWord: " + temp_array);
            ArrayList<String> arraylist_output = new ArrayList<String>();

            int counter_arraylist = 0;
            for (int i = 0; i < temp_array.length; i++) {

//                if (!Pattern.matches("\\b[A-Za-z]+[\\d]+\\b|\\b[\\d]+[A-Za-z]+\\b", temp_array[i] + "")) {
                arraylist_output.add(counter_arraylist, temp_array[i]);

                // if the index is the last, dont add additional " " <- empty string
                if (i + 1 < temp_array.length) {
                    arraylist_output.add(counter_arraylist + 1, " ");
                }
                counter_arraylist = arraylist_output.size();
//                }
            }


            for (int i = 0; i < arraylist_output.size(); i++) {
                if ((arraylist_output.get(i) + "").matches("\\b\\d+[A-Za-z]+|[A-Za-z]+\\d+\\b")) {
                    ArrayList<String> temp_arraylist = new ArrayList<String>(Arrays.asList((arraylist_output.get(i) + "").split("")));
                    Log.i(TAG, "separateToIndividualArraysWord: " + temp_arraylist);
                    arraylist_output.remove(i);
                    temp_arraylist.remove(0);
                    arraylist_output.addAll(i, temp_arraylist);

                }
            }

            for (int i = 0; i < arraylist_output.size(); i++) {
                if (i + 1 < arraylist_output.size()) {
                    if (Pattern.matches("\\b[A-Za-z]+[\\d]+\\b|\\b[\\d]+[A-Za-z]+\\b", arraylist_output.get(i) + "")) {
                        Log.i(TAG, "separateToIndividualArraysWord: " + arraylist_output);
                    }
                }
            }

            // to check for letters & numbers together, eg. i7, T34,
            for (int i = 0; i < arraylist_output.size(); i++) {
                // separate letters and words together, 32p, i7, u30s
                if (Pattern.matches("\\b[A-Za-z]+[\\d]+\\b|\\b[\\d]+[A-Za-z]+\\b", arraylist_output.get(i) + "")) {
                    String y = "" + arraylist_output.get(i);
                    ArrayList<String> temporary_arraylist2 = new ArrayList<String>(Arrays.asList(y.split("")));
                    temporary_arraylist2.remove(0);
                    arraylist_output.addAll(i, temporary_arraylist2);
                    arraylist_output.remove(i + temporary_arraylist2.size());
                    i += temporary_arraylist2.size();

                }
            }


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

        public ArrayList detectNumbers(ArrayList input_arraylist) {
            numericMode = false;
            for (int i = 0; i < input_arraylist.size(); i++) {
                String x = input_arraylist.get(i) + "";
                // If string x is a number P.S. this can allow a 77 or 7.7
                if (x.matches("\\d+")) {

                    ArrayList<String> temp_arraylist = new ArrayList<>(Arrays.asList(x.split("")));
                    temp_arraylist.remove(0);
                    input_arraylist.remove(i);

                    input_arraylist.addAll(i, temp_arraylist);

                    if (numericMode == false) {
                        input_arraylist.add(i, "001111");
                        numericMode = true;
                    }

                    i = i + temp_arraylist.size();
                }

                // is i NOT the last index? Need to know, as we need to add a grade 1 indicator if a word is behind a numeral
                if (i + 1 < input_arraylist.size()) {

                    // is there a " " or " ", "<<sth here>>" after index i? eg. 22 pens, 90 ink - need to put grade 1 indicator
//                    if ((input_arraylist.get(i) + "").matches(" ") && (input_arraylist.get(i + 1) + "").matches("\\b[A-Ja-j]+[A-Za-z]*\\b") || (input_arraylist.get(i) + "").matches("\\b[A-Ja-j]+[A-Za-z]*\\b")) {
//                        input_arraylist.add(i + 1, "000011");
//                        numericMode = false;
//                        i += 2;
//                    }
                }
            }
            return input_arraylist;
        }

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
                }
            }
            return input_arraylist;
        }

        private ArrayList separateToIndividualArraysLetter(ArrayList input_arraylist2) {

            for (int i = 0; i < input_arraylist2.size(); i++) {
                // need to separate
                if (Pattern.matches("\\b[A-Z |a-z]{2,}\\b", "" + input_arraylist2.get(i))) {
                }

                // check if the index contains a legit word, "phone", "cow", "mouse", etc
                if (Pattern.matches("\\b[A-Z |a-z]{2,}\\b", "" + input_arraylist2.get(i))) {
                    // This is assumed to be in grade 1 Braille
                    String x = "" + input_arraylist2.get(i);
                    ArrayList<String> temporary_arraylist = new ArrayList<String>(Arrays.asList(x.split("")));
                    temporary_arraylist.remove(0);
                    input_arraylist2.addAll(i, temporary_arraylist);
                    input_arraylist2.remove(i + temporary_arraylist.size());
                    // i = i + temporary_arraylist.size();
                }

                //STEP 3: when words like, iPhone, macPherson, when a uppercase letter in a lowercase word
                // Need index i(lowercase letter), and i+1(uppercase letter)
                // if the arraylist size is at least 2, and 1st index is a lowercase, and 2nd index is uppercase
                if (input_arraylist2.size() >= 2 && i < input_arraylist2.size()-1) {
                    if (Pattern.matches("\\b[a-z]+\\b", "" + input_arraylist2.get(i)) && Pattern.matches("\\b[A-Z]+\\b", "" + input_arraylist2.get(i + 1))){
                        input_arraylist2.add(i+1, "000001");
                    }
                }

//                String y = "" + input_arraylist2.get(i);
//                ArrayList<String> temporary_arraylist2 = new ArrayList<String>(Arrays.asList(y.split("")));
//                temporary_arraylist2.remove("");
//                Log.i(TAG, "separateToIndividualArraysLetter: " + temporary_arraylist2);

//                // separate letters and words together, 32p, i7, u30s
//                if (Pattern.matches("\\b[A-Za-z]+[\\d]+\\b|\\b[\\d]+[A-Za-z]+\\b", input_arraylist2.get(i)+"")){
//                    String y = "" + input_arraylist2.get(i);
//                    ArrayList<String> temporary_arraylist2 = new ArrayList<String>(Arrays.asList(y.split("")));
//                    temporary_arraylist2.remove(0);
//                    input_arraylist2.addAll(i, temporary_arraylist2);
//                    input_arraylist2.remove(i+temporary_arraylist2.size());
//                    i+= temporary_arraylist2.size();
//
//                }

            }
            return input_arraylist2;
        }

        private ArrayList convertLettersAndNumbersToBinary(ArrayList input_arraylist3) {
            ArrayList<String> temp_arraylist = new ArrayList<>();
            for (int i = 0; i < input_arraylist3.size(); i++) {
                String x = input_arraylist3.get(i) + "";

                //Some binary code is already added. Need this if else to filter out these existing binary codes, else the library switch case wont recognise it.
                if (x.matches("\\b[A-Za-z0-9]\\b| ")) {
                    temp_arraylist.add("" + wordToBinary(x));
                } else {
                    temp_arraylist.add(x);
                }
            }
            return temp_arraylist;
        }

        public ArrayList convertBinaryToDecimals(ArrayList input_arraylist4) {
            ArrayList<String> temp_arraylist = new ArrayList<>();
            for (int i = 0; i < input_arraylist4.size(); i++) {
                String x = input_arraylist4.get(i) + "";

                if (x.matches("\\b[0|1]{6}\\b")) {
                    temp_arraylist.add("" + binaryToDecimal(x));
                }
            }
            return temp_arraylist;
        }


        //These 2 are libraries created by me
        public String wordToBinary(String x) {
            switch (x.toLowerCase()) {
                case " ":
                    return "000000";
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
                case "000000":
                    return Integer.parseInt("000000", 2); // 0
                case "100000": // a/1
                    return Integer.parseInt("100000", 2); //32;
                case "110000": // b/2
                    return Integer.parseInt("110000", 2); //32;
                case "100100": // c/3
                    return Integer.parseInt("100100", 2); //32;
                case "100110": // d/4
                    return Integer.parseInt("100110", 2); //32;
                case "100010": // e/5
                    return Integer.parseInt("100010", 2); //32;
                case "110100": // f/6
                    return Integer.parseInt("110100", 2); //32;
                case "110110": // g/7
                    return Integer.parseInt("110110", 2); //32;
                case "110010": // h/8
                    return Integer.parseInt("110010", 2); //32;
                case "010100": // i/9
                    return Integer.parseInt("010100", 2); //32;
                case "010110": // j/0
                    return Integer.parseInt("010110", 2); //32;

                case "101000": // k/1
                    return Integer.parseInt("101000", 2); //32;
                case "111000": // l/1
                    return Integer.parseInt("111000", 2); //32;
                case "101100": // m/1
                    return Integer.parseInt("101100", 2); //32;
                case "101110": // n/1
                    return Integer.parseInt("101110", 2); //32;
                case "101010": // o/1
                    return Integer.parseInt("101010", 2); //32;
                case "111100": // p/1
                    return Integer.parseInt("111100", 2); //32;
                case "111110": // q/1
                    return Integer.parseInt("111110", 2); //32;
                case "111010": // r/1
                    return Integer.parseInt("111010", 2); //32;
                case "011100": // s/1
                    return Integer.parseInt("011100", 2); //32;
                case "011110": // t/1
                    return Integer.parseInt("011110", 2); //32;
                case "101001": // u/1
                    return Integer.parseInt("101001", 2); //32;
                case "111001": // v/1
                    return Integer.parseInt("111001", 2); //32;
                case "010111": // w/1
                    return Integer.parseInt("010111", 2); //32;
                case "101101": // x/1
                    return Integer.parseInt("101101", 2); //32;
                case "101111": // y/1
                    return Integer.parseInt("101111", 2); //32;
                case "101011": // z/1
                    return Integer.parseInt("101011", 2); //32;
                case "001111": // entering numeric mode
                    return Integer.parseInt("001111", 2); //32;
                case "000011": // entering grade 1 mode
                    return Integer.parseInt("101011", 2); //32;
                case "000001": // entering uppercase mode
                    return Integer.parseInt("000001", 2); //32;
                case "010000": // translate , to decimals
                    return Integer.parseInt("010000", 2); //32;

            }
            return 0;
        }
    }
}
