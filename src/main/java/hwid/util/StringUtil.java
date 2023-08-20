/*
 * Copyright (c) 2023. Vili and contributors.
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 *  file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */

package hwid.util;

import java.util.ArrayList;

public class StringUtil {

    /**
     * Convert a string to a number
     * @param letter The letter to convert
     * @return The number
     */
    public static int convertToString(String letter) {
        Alphabet.LETTERS letters = null;
        for (int i = 0; i < Alphabet.LETTERS.values().length; i++) {
            if (Alphabet.get(i).equalsIgnoreCase(letter)) {
                letters = Alphabet.LETTERS.values()[i];
            }
        }

        if (letters == null) {
            return -1;
        }

        return letters.ordinal();
    }

    /**
     * Get the substrings
     * @param s The string
     * @return The substrings
     */
    public static ArrayList<String> getSubstrings(String s) {
        ArrayList<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            substrings.add(substring);
        }
        return substrings;
    }
}