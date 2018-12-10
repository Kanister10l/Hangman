package com.mygdx.hangman;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import static java.lang.Character.*;


public class WordAnalyzer {

    private static final String FILEPATH = "resources/words.txt";
    private static final Character ALL_CHARS_KEY = valueOf('@');
    private static final Map<Character, Double> CHARS_MAP = new HashMap();


    static {
        populateAllCharsMap();
    }

    private static void populateAllCharsMap() {

        CHARS_MAP.put(ALL_CHARS_KEY, Double.valueOf(0));

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));

            int allCharsNum = 0;
            int i;
            while ((i = reader.read()) != -1) {
                char c = (char) i;
                Character character = valueOf(Character.toLowerCase(c));

                if (!isAlphabetic(i)) {
                    continue;
                }

                Double counter = CHARS_MAP.get(character);
                if (null == counter) {
                    counter = 0.0;
                }

                CHARS_MAP.put(character, ++counter);
                allCharsNum++;
            }
            CHARS_MAP.put(ALL_CHARS_KEY, Double.valueOf(allCharsNum));
        } catch (IOException e) {
            e.printStackTrace();
        }

        double allLetters = CHARS_MAP.get(ALL_CHARS_KEY);

        for (Character key : CHARS_MAP.keySet()) {
            double amount = CHARS_MAP.get(key);

            CHARS_MAP.put(key, 1/Math.ceil(amount / allLetters * 100)*10);
        }

    }

    private static double calculateWordComplexity(String str) {

        Map<Character, Integer> VALUE_MAP = new HashMap();
        final String word = str.toLowerCase();
        double difficult = 0.0;

        for (int i = 0; i < word.length(); i++) {

            Integer counter = VALUE_MAP.get(Character.valueOf(word.charAt(i)));
            if (null == counter) {
                counter = 0;
            }
            VALUE_MAP.put(Character.valueOf(word.charAt(i)), ++counter);
        }

        for (Character key : VALUE_MAP.keySet()) {

            difficult = difficult + (Math.pow(0.9, VALUE_MAP.get(key)-1.0) * VALUE_MAP.get(key) * (CHARS_MAP.get(key)));
        }

        difficult = Math.round(difficult * 100.0) / 100.0;

        return difficult;

    }

    public static void populateDataBase() {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("resources/data.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILEPATH));
            String word = reader.readLine();
            do {
                writer.println(word + ";" + calculateWordComplexity(word));
                word = reader.readLine();
            } while (word != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
