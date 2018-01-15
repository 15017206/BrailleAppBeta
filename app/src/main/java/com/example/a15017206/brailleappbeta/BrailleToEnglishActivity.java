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

    String TAG = ">>", string_output_main, binary_string = "";
    Boolean numericMode = false;
    EditText etBinaryInput;
    Button btnTransDeci, btnTansBin;
    Boolean grade1mode = false;
    Boolean uppercaseLetter = false;
    Boolean uppercaseWord = false;
    Boolean uppercasePassage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braille_to_english);

        etBinaryInput = (EditText) findViewById(R.id.etBinaryInput);
        btnTansBin = (Button) findViewById(R.id.btnTransBin);
        btnTransDeci = (Button) findViewById(R.id.btnTransDeci);

        // This is the array to enter the numbers inside
        int x[] = {1, 50, 34, 56, 56, 42, 16, 0, 50, 42, 23, 0, 32, 58, 34, 0, 47, 42, 41, 25};

        // This is to convert from int[] to binary string

        // If
        if (x.length > 0) {
            for (int i = 0; i < x.length; i++) {
                String temp = Integer.toBinaryString(x[i]);
                while (temp.length() < 6) {
                    temp = "0" + temp;
                }
                binary_string += temp + " ";
            }
            Log.i(TAG, "from int[] to binary string is: " + binary_string);
        }

        //    This is to enter binary code directly. It should be commented away when passing code over
        //    binary_string = "000001 000001 100010 111000 100010 100100 011110 111010 010100 100100 100000 111000 000000 000001 000001 111010 101010 101010 101100";

        // This is to convert from binary string to english text string
        doTranslateBtoE translateBtoE = new doTranslateBtoE();
        ArrayList<String> temp_arraylist = new ArrayList<>(Arrays.asList(binary_string.split(" ")));
        temp_arraylist = translateBtoE.BinaryToEnglish2(temp_arraylist);
        string_output_main = translateBtoE.EnglishArrayToEnglishString(temp_arraylist);
        Log.i(TAG, "temp_arraylist: " + temp_arraylist);
        Log.i(TAG, "string_output_main: " + string_output_main);
    }

    class doTranslateBtoE {
        //library
        public String BinaryToEnglish(String input_binary) {
            switch (input_binary) {
                case "000000": // " "
                    uppercaseWord = false;
                    numericMode = false;
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
                            return "H";
                        } else {
                            return "h";
                        }
                    }
                case "010100": // i/9
                    if (numericMode) {
                        return "9";
                    } else {
                        if (uppercaseLetter) {
                            uppercaseLetter = false;
                            return "I";
                        } else if (uppercaseWord) {
                            return "I";
                        } else if (uppercasePassage) {
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
                        } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
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
                    } else if (uppercasePassage) {
                        return "Z";
                    } else {
                        return "z";
                    }
                case "001111": // entering numeric mode
                    numericMode = true;
                    return "shouldnt come here 2";
                case "000011": // entering grade 1/ grade 1 indicator
                    numericMode = false;
                    return "shouldnt come here 2";
                case "000001": // uppercase letter
                    uppercaseLetter = true;
                    return "shouldnt come here 2";


                case "001000": // "'"/apostrophe
                    return "'";


                case "000100 111101": // "&"
                    return "&";
                case "000010 001010":
                    return "*"; // "*"
                case "000010 110001":
                    return "(";
                case "000010 001110":
                    return ")";
                case "000101 110001":
                    return "[";
                case "000101 001110":
                    return "]";
                case "000111 110001":
                    return "{";
                case "000111 001110":
                    return "}";
                case "000100 110001":
                    return "<";
                case "000100 001110":
                    return ">";
                case "000111 010011":
                    return "•";
                case "010000":
                    return ",";
                case "000100 000001 100111":
                    return "†";
                case "000100 000001 110111":
                    return "‡";
                case "000010 001001": // short dash/en dash "-"
                    return "–";
                case "000010 000001 001001":// long dash/em dash "—"
                    return "—";
                case "000010 010000": // ditto mark
                    return "”";
                case "010011 010011 010011":
                    return "…";
                case "011010": // "!"
                    return "!";
                case "000110 101101":
                    return "♀";
                case "000110 101111":
                    return "♂";
                case "000111 100111":
                    return "#";
                case "001001": // "-"/hyphen
                    return "-";
                case "000110 100100":
                    return "©";
                case "000110 111010":
                    return "®";
                case "000110 011110":
                    return "™";
                case "010011": // "."
                    return ".";
                case "011001": // "?" / opening nonspecific quotation mark
                    return "?";
                case "001011":
                    return "'"; // closing nonspecific quotation mark
                case "000110 011001": // opening double quotation mark
                    return "“";
                case "000110 001011": // closing double quotation mark
                    return "”";
                case "000001 011001": // opening single quotation mark
                    return "‘";
                case "000001 001011": // closing single quotation mark
                    return "’";
                case "000111 011001":
                    return "«";
                case "000111 001011":
                    return "»";
                case "011000":
                    return ";";
                case "010010":
                    return ":";
                case "000111 100001": // Backslash
                    return "\\";
                case "000111 001100":
                    return "/";
                case "000101 001001":
                    return "_";
                case "000100 100000":
                    return "@";
                case "000010": // Numeric space/Line continuation indicator. NOTE: This may conflict with the normal space, but it does not stop numeric mode
                    return " ";


                case "000001 000001": // uppercase word
                    uppercaseWord = true;
                    return "shouldnt come here 2";


                case "000001 000001 000001": // capital passage indicator
                    uppercasePassage = true;
                    return "shouldnt come here 2";
                case "000001 001000": // capital passage terminator
                    uppercasePassage = false;
                    return "shouldnt come here 2";

                case "000001 000010 110001": // "("
                    return "("; // This is a large opened bracket
                case "000001 000010 001110":
                    return ")";// This is a large closed bracket

                case "":
                    return "";
                case "000111":
                    return "shouldnt come here 2";

                // Strong wordsigns
                case "000000 100001 000000":
                    return "child";
                case "000000 110011 000000":
                    return "out";
                case "000000 100101 000000":
                    return "shall";
                case "000000 001100 000000":
                    return "still";
                case "000000 100111 000000":
                    return "this";
                case "000000 100011 000000":
                    return "which";


                // Strong Groupsigns - contracted braille
                case "001110":
                    if (uppercaseWord) {
                        return "AR";
                    } else if (uppercasePassage){
                        return "AR";
                    } else {
                        return "ar";
                    }
                case "100001":
                    if (uppercaseWord) {
                        return "CH";
                    } else if (uppercasePassage){
                        return "CH";
                    } else {
                        return "ch";
                    }
                case "110101":
                    if (uppercaseWord) {
                        return "ED";
                    } else if (uppercasePassage){
                        return "ED";
                    } else {
                        return "ed";
                    }
                case "110111":
                    if (uppercaseWord) {
                        return "ER";
                    } else if (uppercasePassage){
                        return "ER";
                    } else {
                        return "er";
                    }
                case "110001":
                    if (uppercaseWord) {
                        return "GH";
                    } else if (uppercasePassage){
                        return "GH";
                    } else {
                        return "gh";
                    }
                case "001101":
                    if (uppercaseWord) {
                        return "ING";
                    } else if (uppercasePassage){
                        return "ING";
                    } else {
                        return "ing";
                    }
                case "110011":
                    if (uppercaseWord) {
                        return "OU";
                    } else if (uppercasePassage){
                        return "OU";
                    } else {
                        return "ou";
                    }
                case "010101":
                    if (uppercaseWord) {
                        return "OW";
                    } else if (uppercasePassage){
                        return "OW";
                    } else {
                        return "ow";
                    }
                case "100101":
                    if (uppercaseWord) {
                        return "SH";
                    } else if (uppercasePassage){
                        return "SH";
                    } else {
                        return "sh";
                    }
                case "001100":
                    if (uppercaseWord) {
                        return "ST";
                    } else if (uppercasePassage){
                        return "ST";
                    } else {
                        return "st";
                    }
                case "100111":
                    if (uppercaseWord) {
                        return "TH";
                    } else if (uppercasePassage){
                        return "TH";
                    } else {
                        return "th";
                    }
                case "100011":
                    if (uppercaseWord) {
                        return "WH";
                    } else if (uppercasePassage){
                        return "WH";
                    } else {
                        return "wh";
                    }
                // Strong contractions
                case "111101":
                    return "and";
                case "111111":
                    return "for";
                case "111011":
                    return "of";
                case "011101":
                    return "the";
                case "011111":
                    return "with";

                // Final letter groupsigns
                // dots 56:
                case "000011 100010":
                    return "ence";
                case "000011 110110":
                    return "ong";
                case "000011 111000":
                    return "ful";
                case "000011 101110":
                    return "tion";
                case "000011 011100":
                    return "ness";
                case "000011 011110":
                    return "ment";
                case "000011 101111":
                    return "ity";

                //dots 46:
                case "000101 100110":
                    return "ound";
                case "000101 100010":
                    return "ance";
                case "000101 101110":
                    return "sion";
                case "000101 011100":
                    return "less";
                case "000101 011110":
                    return "ount";

                // initial letter contraction:-
                // dots 456:-
                case "000111 100100":
                    return "cannot";
                case "000111 110010":
                    return "had";
                case "000111 101100":
                    return "many";
                case "000111 011100":
                    return "spirit";
                case "000111 011101":
                    return "their";
                case "000111 010111":
                    return "world";

                // dots 5:-
                case "000010 100001":
                    return "character";
                case "000010 100110":
                    return "day";
                case "000010 100010":
                    return "ever";
                case "000010 110100":
                    return "father";
                case "000010 110010":
                    return "here";
                case "000010 101000":
                    return "know";
                case "000010 111000":
                    return "lord";
                case "000010 101100":
                    return "mother";
                case "000010 101110":
                    return "name";
                case "000010 101010":
                    return "one";
                case "000010 110011":
                    return "ought";
                case "000010 111100":
                    return "part";
                case "000010 111110":
                    return "question";
                case "000010 111010":
                    return "right";
                case "000010 011100":
                    return "some";
                case "000010 011101":
                    return "there";
                case "000010 011110":
                    return "time";
                case "000010 100111":
                    return "through";
                case "000010 101001":
                    return "under";
                case "000010 100011":
                    return "where";
                case "000010 010111":
                    return "work";
                case "000010 101111":
                    return "young";

                // dots 45:-
                case "000110 011101":
                    return "these";
                case "000110 100111":
                    return "those";
                case "000110 101001":
                    return "upon";
                case "000110 100011":
                    return "whose";
                case "000110 010111":
                    return "word";

                // Lower Groupsigns & lower Wordsigns are problematic

            }
            return "shouldnt come here 1";
        }

        // Method doing computation - it uses the library
        public ArrayList BinaryToEnglish2(ArrayList arraylist_input_binary) {
            ArrayList<String> arraylist_output = new ArrayList();

            //Using a for loop to traverse the arraylist
            // If this keeps repeating in logcat, means the value is not recognised in library
            while (arraylist_input_binary.size() > 0) {
                Log.i(TAG, "currently testing index value: " + arraylist_input_binary.get(0));
                // if arraylist has 2 index greater than i
                if (arraylist_input_binary.size() >= 3) {
                    String index = arraylist_input_binary.get(0) + "";
                    String index1 = arraylist_input_binary.get(1) + "";
                    String index2 = arraylist_input_binary.get(2) + "";

                    // Eg. if first 3 indexes matches  "("
                    String concatenated = index + " " + index1 + " " + index2;
                    String after_using_library = BinaryToEnglish(concatenated);
//                    Log.i(TAG, "BinaryToEnglish2: " + concatenated);
//                    Log.i(TAG, "after using the library index >= 3: " + after_using_library);

                    if (!after_using_library.contains("shouldnt come here 1")) {
                        if (!after_using_library.contains("shouldnt come here 2")) {
                            arraylist_output.add(after_using_library);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        } else {
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        }
                    } else {

                    }


                }

                // if arraylist has 1 index greater than i
                if (arraylist_input_binary.size() >= 2) {
                    String index = arraylist_input_binary.get(0) + "";
                    String index1 = arraylist_input_binary.get(1) + "";

                    // Eg. if first 2 indexes matches  "..."
                    String concatenated = index + " " + index1;
                    String after_using_library = BinaryToEnglish(concatenated);
//                    Log.i(TAG, "BinaryToEnglish2: " + concatenated);
//                    Log.i(TAG, "after using the library index >= 2: " + after_using_library);

                    if (!after_using_library.contains("shouldnt come here 1")) {
                        if (!after_using_library.contains("shouldnt come here 2")) {
                            arraylist_output.add(after_using_library);
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        } else {
                            arraylist_input_binary.remove(0);
                            arraylist_input_binary.remove(0);
                        }
                    }
                } else {

                }

                // Those that do not satisfy the previous 2 requirements will be converted here - single character letters/numbers
                if (arraylist_input_binary.size() >= 1) {
                    String x = arraylist_input_binary.get(0) + "";
                    String y = BinaryToEnglish(x);
//                    Log.i(TAG, "after using the library index >= 1: " + y);
                    if (!y.contains("shouldnt come here 1")) {
                        if (!y.contains("shouldnt come here 2")) {
                            arraylist_output.add(y);
                            arraylist_input_binary.remove(0);
                        } else {
                            arraylist_input_binary.remove(0);
                        }
                    }

                    Log.i(TAG, "single char value is: " + x);
                } else {

                }

            }

            Log.i(TAG, "arraylist_output is: " + arraylist_output);

            return arraylist_output;
        }

        // Method to convert arraylist to string
        public String EnglishArrayToEnglishString(ArrayList arrayList) {
            String string_output = "";
            while (arrayList.size() > 0) {
                string_output += arrayList.get(0) + "";
                arrayList.remove(0);
            }

            return string_output;
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
