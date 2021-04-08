package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";

        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        List<Map.Entry<String, Integer>> sorted = new LinkedList<>(map.entrySet());
        sorted.sort((a, b) -> {
            int cmp0 = a.getValue().compareTo(b.getValue());
            if(cmp0 == 0){
                return a.getKey().compareTo(b.getKey());
            }
            return -cmp0;
        });

        for(Map.Entry<String, Integer> entry : sorted)
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
