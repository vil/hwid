package hwid.util;

import java.util.ArrayList;

/*
 *
 * @Author Vp (https://github.com/herravp)
 * Code is free to use :)
 *
 */

public class StringUtil {
    public static int string = -1;

    public static int convertToString(String letter) {
        Alphabet.LETTERS letters = null;
        for (int i = 0; i < Alphabet.LETTERS.values().length; i++) {
            if (Alphabet.get(i).equalsIgnoreCase(letter)) {
                letters = Alphabet.LETTERS.values()[i];
            }
        }

        // Really good way of doing this FR
        if (letters == letters.A) string = 1;
        else if (letters == letters.B) string = 2;
        else if (letters == letters.C) string = 3;
        else if (letters == letters.D) string = 4;
        else if (letters == letters.E) string = 5;
        else if (letters == letters.F) string = 6;
        else if (letters == letters.G) string = 7;
        else if (letters == letters.H) string = 8;
        else if (letters == letters.I) string = 9;
        else if (letters == letters.J) string = 10;
        else if (letters == letters.K) string = 11;
        else if (letters == letters.L) string = 12;
        else if (letters == letters.M) string = 13;
        else if (letters == letters.N) string = 14;
        else if (letters == letters.O) string = 15;
        else if (letters == letters.P) string = 16;
        else if (letters == letters.Q) string = 17;
        else if (letters == letters.R) string = 18;
        else if (letters == letters.S) string = 19;
        else if (letters == letters.T) string = 20;
        else if (letters == letters.U) string = 21;
        else if (letters == letters.V) string = 22;
        else if (letters == letters.W) string = 23;
        else if (letters == letters.X) string = 24;
        else if (letters == letters.Y) string = 25;
        else if (letters == letters.Z) string = 26;

        return string;
    }

    public static ArrayList<String> getSubstrings(String s) {
        ArrayList<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            substrings.add(substring);
        }
        return substrings;
    }
}