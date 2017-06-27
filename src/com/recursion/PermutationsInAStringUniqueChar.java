package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * WIP to get  permutations of a string with distinct characters. * 
 * 
 * @author Rohit Dumbre 
 */
public class PermutationsInAStringUniqueChar
{

    private static Set<String> getPermutationsOfString (final String s)
    {
        if (s.isEmpty())
            return Collections.emptySet();

        Set<String> listOfPerms = new HashSet<String>();
        getPermutationsOfString(s, "", listOfPerms);
        return listOfPerms;
    }

    private static void getPermutationsOfString (String s1, String s2, Set<String> listOfPerms)
    {
        if (s1.length() == 0)
        {
            listOfPerms.add(s2);
            return;
        }

        for (int i = 0; i < s1.length(); i++)
        {
            char c1 = s1.charAt(i);
            String sub1 = s1.substring(0, i);
            String sub2 = s1.substring(i + 1);

            getPermutationsOfString(sub1 + sub2, s2 + c1, listOfPerms);

        }

    }

    public static void main (String[] args)
    {
        String perm = "abad";
        Set<String> permutationsOfString = PermutationsInAStringUniqueChar.getPermutationsOfString(perm);
        permutationsOfString.stream().forEach(System.out::println);
        System.out.println("Number of permutations possible for " + permutationsOfString.size());
    }

}
