package com.coding.searching_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO Description.
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">Copyright &copy; Cerner Corporation 2017 All rights reserved.
 * </p>
 * @author Rohit Dumbre 
 * @since X.X
 */
public class SortAnagrams
{
    public static void sortAnagrams (String[] strings)
    {
        Map<String, List<String>> asciiByString = new HashMap<String, List<String>>();

        for (int i = 0; i < strings.length; i++)
        {
            String sortedString = getSortedValue(strings[i]);
            if (asciiByString.containsKey(sortedString))
            {
                asciiByString.get(sortedString).add(strings[i]);
            }
            else
            {
                List<String> string = new ArrayList<String>();
                string.add(strings[i]);
                asciiByString.put(sortedString, string);
            }

        }

        LinkedHashMap<String, List<String>> linkedHashMap = asciiByString.entrySet()
                .stream() //
                .sorted(Map.Entry.comparingByKey(sortStrings())) //
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        List<List<String>> sortValues = new ArrayList<List<String>>();

        for (List<String> values : linkedHashMap.values())
        {
            List<String> sorted = values.stream()
                    .sorted(sortStrings()) //
                    .collect(Collectors.toList());//

            sortValues.add(sorted);
        }

        int k = 0;
        for (List<String> values : sortValues)
        {
            for (String string : values)
            {
                strings[k] = string;
                ++k;
            }
        }

        System.out.println("New list");
        for (int j = 0; j < strings.length; j++)
        {
            System.out.print(strings[j] + " ");
        }
    }

    private static Comparator<String> sortStrings ()
    {
        return (String s1, String s2) -> {
            char c1 = s1.charAt(0);
            char c2 = s2.charAt(0);

            if (c1 > c2)
            {
                return 1;
            }
            else if (c1 < c2)
            {
                return -1;
            }

            return 0;

        };
    }

    private static String getSortedValue (String value)
    {
        Arrays.sort(value.toCharArray());
        return value;
    }

    /**
     * @param args
     */
    public static void main (String[] args)
    {
        String[] anagrams = {"atw", "wot", "taw", "tow"};
        System.out.println("Original list");
        for (int j = 0; j < anagrams.length; j++)
        {
            System.out.print(anagrams[j] + " ");
        }
        System.out.println();
        SortAnagrams.sortAnagrams(anagrams);
    }
}
