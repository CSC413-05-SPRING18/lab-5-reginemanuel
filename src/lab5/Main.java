package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// new imports
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Reads file "Test.java" and then takes each word from the file, including symbols,
* stores them on a hashmap then counts how many words exists, then prints out
* the keys and values of it */

public class Main {

    public static void main(String[] args) {

        /* declare HashMap */
        HashMap myMap = new HashMap();

        try {
            File f = new File("src/lab5/Test.java");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {

                String[] words = readLine.split(" "); // reading the words in the file

                // looks for a new word and save it, then adds to map and increases value to word
                for (int i = 0; i < words.length; i++) {
                    if (myMap.get(words[i]) == null) {
                        myMap.put(words[i], 1);
                    } else {
                        int newValue = Integer.valueOf(String.valueOf(myMap.get(words[i])));
                        newValue++;
                        myMap.put(words[i], newValue);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // prints keys and values
        TreeMap<String, String> sorted = new TreeMap<String, String>(myMap);
        for (Object key : sorted.keySet()) {
            System.out.println("Word: " + key);
            System.out.println("Count: " + myMap.get(key) + "\n");
        }
    }
}
