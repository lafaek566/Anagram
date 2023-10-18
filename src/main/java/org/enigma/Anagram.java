package org.enigma;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    public static List<List<String>> groupAnagrams(String[] strings) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, Integer> anagramMap = new HashMap<>();

        for (String str : strings) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, groupedAnagrams.size());
                List<String> anagramGroup = new ArrayList<>();
                anagramGroup.add(str);
                groupedAnagrams.add(anagramGroup);
            } else {
                int index = anagramMap.get(sortedStr);
                groupedAnagrams.get(index).add(str);
            }
        }

        return groupedAnagrams;
    }

    public static void main(String[] args) {
        String[] input = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        List<List<String>> result = groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }

}
