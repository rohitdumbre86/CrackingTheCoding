package com.coding.searching_sorting;


/**
 * If there are two sorted arrays merge then to one, given that one of the array has a enough space at the end to fit it.
 * @author Rohit Dumbre (RD025989)
 * @since X.X
 */
public class MergeSortedArrays
{

    public static void mergeSortedArrays (int[] a, int[] b)
    {
        int[] big = a.length > b.length ? a : b;
        int[] small = a.length < b.length ? a : b;

        int i = 1;
        while (i < big.length && big[i] != 0)
        {
            i++;
        }
        i--;

        int j = small.length - 1;
        int k = big.length - 1;

        if (k - i != j + 1)
        {
            System.out.println("The bigger array doesnt have proper capacity to include smaller");
            return;
        }

        while (i >= 0 && j >= 0)
        {
            if (big[i] > small[j])
            {
                big[k] = big[i];
                i--;
            }
            else if (big[i] < small[j])
            {
                big[k] = small[j];
                j--;
            }
            else
            {
                big[k] = big[i];
                big[--k] = big[i];
                i--;
                j--;
            }

            k--;
        }

    }

    public static void main (String[] args)
    {
        int[] a = {1, 3, 4, 8, 0, 0, 0, 0};
        int[] b = {2, 5, 9, 10};

        MergeSortedArrays.mergeSortedArrays(a, b);

        System.out.print("{ ");
        for (int i = 0; i < a.length - 1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length - 1] + " }");

    }

}
