package com.coding.searching_sorting;

/**
 * If the sorted string array have empty strings as part of its array then search for the element.
 * @author Rohit Dumbre (RD025989)
 * @since X.X
 */
public class SearchFromEmptyStrings
{
    private static int getIndexForStringFromBlankStringArray (String[] array, String key)
    {
        return getIndexForStringFromBlankStringArray(array, 0, array.length - 1, key);
    }

    private static int getIndexForStringFromBlankStringArray (String[] array, int left, int right, String key)
    {

        int pivot = (right + left) / 2;

        if (array[pivot] == key)
        {
            return pivot;
        }

        if (left > right)
        {
            return -1;
        }

        if (key == array[left])
            return left;
        if (key == array[right])
            return right;

        if (array[pivot] == "")
        {
            int i = pivot + 1;
            int j = pivot - 1;
            while (i >= left || j <= right)
            {
                i--;
                j++;
                if (array[i] != "")
                {
                    pivot = i;
                    break;
                }
                else if (array[j] != "")
                {
                    pivot = j;
                    break;
                }
            }
        }

        if (key.compareTo(array[pivot]) == 0)
        {
            return pivot;
        }

        else if (key.compareTo(array[pivot]) < 0)
        {
            return getIndexForStringFromBlankStringArray(array, left, pivot - 1, key);
        }
        else
        {
            return getIndexForStringFromBlankStringArray(array, pivot + 1, right, key);
        }

    }

    public static void main (String[] args)
    {
        String[] arrays1 = new String[] {"at", "", "bat", ""};

        System.out.println("Index for bat :" + SearchFromEmptyStrings.getIndexForStringFromBlankStringArray(arrays1, "bat"));

        String[] arrays2 = new String[] {"", "", "bat", ""};

        System.out.println("Index for bat :" + SearchFromEmptyStrings.getIndexForStringFromBlankStringArray(arrays2, "bat"));

        String[] arrays3 = new String[] {"", "", "", "bat", "", "cat", "", "", "mat"};

        System.out.println("Index for bat :" + SearchFromEmptyStrings.getIndexForStringFromBlankStringArray(arrays3, "bat"));

        String[] array4 = new String[] {"", "", "", "bat", "", "cat", "", "", "mat"};

        System.out.println("Index for cat :" + SearchFromEmptyStrings.getIndexForStringFromBlankStringArray(array4, "cat"));
    }

}
