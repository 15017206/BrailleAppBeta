package com.example.a15017206.brailleappbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BrailleToEnglishActivity extends AppCompatActivity {

    String TAG = ">>";
    Boolean numericMode = false;
    EditText etBinaryInput;
    Button btnDoTranslate;
    Boolean grade1mode = false;
    Boolean uppercaseLetter = false;
    Boolean uppercaseWord = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braille_to_english);

        etBinaryInput = (EditText) findViewById(R.id.etBinaryInput);
        btnDoTranslate = (Button) findViewById(R.id.btnDoTranslate);


        doTranslateBtoE translateBtoE = new doTranslateBtoE();

        String x = "000001 011100 101000";
        ArrayList<String> temp_arraylist = new ArrayList<>(Arrays.asList(x.split(" ")));
        translateBtoE.BinaryToEnglish2(temp_arraylist);
    }

    class doTranslateBtoE {

        // Self-made Libraries
        public void DecimalToBinary() {
        }

        // On-Hold library
        public String BinaryToEnglish(String input_binary) {
            switch (input_binary) {
                case "000000": // " "
                    uppercaseWord = false;
                    return " ";
                case "100000": // a/1
                    if (numericMode) {
                        return "1";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "A";
                        } else if (uppercaseWord) {
                            return "A";
                        } else {
                            return "a";
                        }
                    }
                case "110000": // b/2
                    if (numericMode) {
                        return "2";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "B";
                        } else if (uppercaseWord) {
                            return "B";
                        } else {
                            return "b";
                        }
                    }
                case "100100": // c/3
                    if (numericMode) {
                        return "3";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "C";
                        } else if (uppercaseWord) {
                            return "C";
                        } else {
                            return "c";
                        }
                    }
                case "100110": // d/4
                    if (numericMode) {
                        return "4";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "D";
                        } else if (uppercaseWord) {
                            return "D";
                        } else {
                            return "d";
                        }
                    }
                case "100010": // e/5
                    if (numericMode) {
                        return "5";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "E";
                        } else if (uppercaseWord) {
                            return "E";
                        } else {
                            return "e";
                        }
                    }
                case "110100": // f/6
                    if (numericMode) {
                        return "6";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "F";
                        } else if (uppercaseWord) {
                            return "F";
                        } else {
                            return "f";
                        }
                    }
                case "110110": // g/7
                    if (numericMode) {
                        return "7";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "G";
                        } else if (uppercaseWord) {
                            return "G";
                        } else {
                            return "g";
                        }
                    }
                case "110010": // h/8
                    if (numericMode) {
                        return "8";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "H";
                        } else if (uppercaseWord) {
                            return "H";
                        } else {
                            return "h";
                        }
                    }
                case "0110100": // i/9
                    if (numericMode) {
                        return "9";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "I";
                        } else if (uppercaseWord) {
                            return "I";
                        } else {
                            return "i";
                        }
                    }
                case "010110": // j/0
                    if (numericMode) {
                        return "0";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "J";
                        } else if (uppercaseWord) {
                            return "J";
                        } else {
                            return "j";
                        }
                    }

                    // "k" and other letters with no numeric mode
                case "101000":
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "K";
                    } else if (uppercaseWord) {
                        return "K";
                    } else {
                        return "k";
                    }

                case "111000": // "l"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "L";
                    } else if (uppercaseWord) {
                        return "L";
                    } else {
                        return "l";
                    }

                case "101100": // "m"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "M";
                    } else if (uppercaseWord) {
                        return "M";
                    } else {
                        return "m";
                    }
                case "101110": // "n"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "N";
                    } else if (uppercaseWord) {
                        return "N";
                    } else {
                        return "n";
                    }
                case "101010": // "o"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "O";
                    } else if (uppercaseWord) {
                        return "O";
                    } else {
                        return "o";
                    }
                case "111100": // "p"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "P";
                    } else if (uppercaseWord) {
                        return "P";
                    } else {
                        return "p";
                    }
                case "111110": // "q"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "Q";
                    } else if (uppercaseWord) {
                        return "Q";
                    } else {
                        return "q";
                    }
                case "111010": // "r"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "R";
                    } else if (uppercaseWord) {
                        return "R";
                    } else {
                        return "r";
                    }
                case "011100": // "s"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "S";
                    } else if (uppercaseWord) {
                        return "S";
                    } else {
                        return "s";
                    }
                case "011110": // "t"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "T";
                    } else if (uppercaseWord) {
                        return "T";
                    } else {
                        return "t";
                    }
                case "101001": // "u"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "U";
                    } else if (uppercaseWord) {
                        return "U";
                    } else {
                        return "u";
                    }
                case "111001": // "v"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "V";
                    } else if (uppercaseWord) {
                        return "V";
                    } else {
                        return "v";
                    }
                case "010111": // "w"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "W";
                    } else if (uppercaseWord) {
                        return "W";
                    } else {
                        return "w";
                    }
                case "101101": // "x"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "X";
                    } else if (uppercaseWord) {
                        return "X";
                    } else {
                        return "x";
                    }
                case "101111": // "y"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "Y";
                    } else if (uppercaseWord) {
                        return "Y";
                    } else {
                        return "y";
                    }
                case "101011": // "z"
                    numericMode = false;
                    if (uppercaseLetter) {
                        uppercaseLetter = false;
                        return "Z";
                    } else if (uppercaseWord) {
                        return "Z";
                    } else {
                        return "z";
                    }
                case "001111": // entering numeric mode
                    numericMode = true;
                    return "shouldnt come here 2";
                case "000011": // entering grade 1
                    numericMode = false;
                    return "shouldnt come here 2";
                case "000001":
                    uppercaseLetter = true;
                    return "shouldnt come here 2";
                case "000001 000001":
                    uppercaseWord = true;
                    return "shouldnt come here 2";

                case "000001 000010 110001": // "("
                    return "("; // This is a large opened bracket
                case "000001 000010 001110":
                    return ")";// This is a large closed bracket

            }
            return "shouldnt come here 1";
        }

        // Method doing computation and contains library together
        public ArrayList BinaryToEnglish2(ArrayList arraylist_input_binary) {
            ArrayList<String> arraylist_output = new ArrayList();

            //Using a for loop to traverse the arraylist
            while (arraylist_input_binary.size() > 0) {

                // if arraylist has 2 index greater than i
                if (arraylist_input_binary.size() >= 3) {
                    String index = arraylist_input_binary.get(0) + "";
                    String index1 = arraylist_input_binary.get(1) + "";
                    String index2 = arraylist_input_binary.get(2) + "";

                    // Eg. if first 3 indexes matches  "("
                    String concatenated = index + " " + index1 + " " + index2;
                    String after_using_library = BinaryToEnglish(concatenated);
                    Log.i(TAG, "BinaryToEnglish2: " + concatenated);
                    Log.i(TAG, "after using the library: " + after_using_library);

                    if (!after_using_library.contains("shouldnt come here 1")){
                        if (!after_using_library.contains("shouldnt come here 2")){
                            arraylist_output.add(after_using_library);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        }
                        else {
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        }
                    }


                }

                // if arraylist has 1 index greater than i
                if (arraylist_input_binary.size() >= 2) {
                    String index = arraylist_input_binary.get(0) + "";
                    String index1 = arraylist_input_binary.get(1) + "";

                    // Eg. if first 2 indexes matches  "..."
                    String concatenated = index + " " + index1;
                    String after_using_library = BinaryToEnglish(concatenated);
                    Log.i(TAG, "BinaryToEnglish2: " + concatenated);
                    Log.i(TAG, "after using the library: " + after_using_library);

                    if (!after_using_library.contains("shouldnt come here 1")){
                        if (!after_using_library.contains("shouldnt come here 2")){
                            arraylist_output.add(after_using_library);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        }
                        else {
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        }
                    }
                }

                // Those that do not satisfy the previous 2 requirements will be converted here - single character letters/numbers
                if (arraylist_input_binary.size() >= 1) {
                    String x = arraylist_input_binary.get(0) + "";
                    String y = BinaryToEnglish(x);

                    if (!y.contains("shouldnt come here 1")){
                        if (!y.contains("shouldnt come here 2")){
                            arraylist_output.add(y);
                            arraylist_input_binary.remove(0);
                        }
                        else {
                            arraylist_input_binary.remove(0);
                        }
                    }

                    Log.i(TAG, "single char value is: " + x);
                }
            }

            Log.i(TAG, "arraylist_output is: " + arraylist_output);

            return arraylist_output;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_e_to_b:
                Intent i = new Intent(this, EnglishToBrailleActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
