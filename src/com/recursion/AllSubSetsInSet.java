package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Recursive function to print all the subsets.
 * 
 * @author Rohit Dumbre (RD025989)
 * @since X.X
 */
public class AllSubSetsInSet
{

    private static List<List<Integer>> allSetsInSubSets (List<Integer> sets)
    {
        final Set<List<Integer>> allSubSets = new HashSet<List<Integer>>();
        allSubSets(sets, allSubSets);
        allSubSets.add(sets);
        List<List<Integer>> sortedSet = allSubSets.stream().sorted( (set1, set2) -> Integer.compare(set1.size(), set2.size())).collect(Collectors.toList());

        return sortedSet;
    }

    private static void allSubSets (List<Integer> set, Set<List<Integer>> sets)
    {
        if (set.size() <= 0)
        {
            return;
        }

        for (int i = 0; i < set.size(); i++)
        {
            List<Integer> s3 = new ArrayList<Integer>();
            List<Integer> s1 = set.subList(0, i);

            if (i + 1 < set.size())
            {
                List<Integer> s2 = set.subList(i + 1, set.size());
                s3.addAll(s2);
            }
            s3.addAll(s1);
            
            Collections.sort(s3);
            sets.add(s3);

            allSubSets(s3, sets);
        }

        return;
    }

    public static void main (String[] args)
    {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        List<List<Integer>> allSetsInSubSets = allSetsInSubSets(integers);
        allSetsInSubSets.stream().forEach(System.out::println);
        System.out.println("Expected no of subsets : " + (int) Math.pow(2,integers.size()));
        System.out.println("Actual no of subsets : " + allSetsInSubSets.size());

    }

}
