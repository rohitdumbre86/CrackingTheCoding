package com.coding.arrays_strings;

/**
 * Problems from Cracking the coding interview.
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; 2017 All rights reserved.
 * </p>
 * 
 * @author Rohit Dumbre 
 * @since X.X
 */
public class ArraysAndString
{

    /**
     * Q1 : Return if string has unique
     * 
     * @param s
     */
    public static void returnUnique (String s)
    {

        char[] a = s.toLowerCase().toCharArray();
        int length = a.length;

        for (int i = 0; i < length; i++)
        {

            int lower = (a[i] - 'a');
            int upper = (a[i] - 'A');

            int subValue = (lower >= 0 && lower <= 10) ? lower : upper;

            int value = subValue % length;

            if (a[value] == '1')
            {
                System.out.println("Non unique");
                return;
            }

            a[value] = '1';

        }

        System.out.println("Unique");

    }

    public static void returnIfPerm (String s1, String s2)
    {
        int count = 0;
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        if (s1.length() != s2.length())
        {
            System.out.println("Is not a perm");
            return;
        }

        for (int i = 0; i < a1.length; i++)
        {

            for (int j = 0; j < a2.length; j++)
            {
                if (a1[i] == a2[j])
                {
                    count++;
                }
            }
        }

        if (count == a1.length - 1)
        {
            System.out.println("Is a perm");
            return;
        }

        System.out.println("Is not a perm");

        // Or implement this using hash tables.
    }

    public static void returnUrlString (String s1)
    {
        char[] a1 = s1.toCharArray();
        int lIndex = 0;
        int hIndex = a1.length - 1;

        for (int i = hIndex; i >= 0; i--)
        {
            if (a1[i] != ' ')
            {
                lIndex = i;
                break;
            }
        }

        while (lIndex >= 0 && hIndex >= 2)
        {
            if (a1[lIndex] != ' ')
            {
                a1[hIndex] = a1[lIndex];
            }
            else
            {
                a1[hIndex] = '0';
                a1[hIndex - 1] = '2';
                a1[hIndex - 2] = '%';
                hIndex = hIndex - 2;
            }

            hIndex--;
            lIndex--;
        }

        System.out.println(new String(a1));
    }

    public static void checkIfPalindrome (String s1)
    {
        int[] holder = new int[26];
        char[] a1 = s1.toCharArray();
        for (int i = 0; i < a1.length; i++)
        {

            int v = (a1[i] - 'a') % a1.length;
            holder[v] += 1;
        }

        int noOfUnique = 0;

        for (int i = 0; i < holder.length; i++)
        {
            if (holder[i] == 1)
            {
                noOfUnique++;
            }
        }

        if (noOfUnique > 1)
        {
            System.out.println("Not a palindrome");
            return;
        }

        System.out.println("Palindrome");
    }

    public static void compressString (String s)
    {
        StringBuilder compressor = new StringBuilder();
        char[] a1 = s.toCharArray();

        int i = 0;
        int compressLength = 0;
        for (int j = 1; j < a1.length; j++)
        {
            compressLength++;

            if (a1[i] != a1[j])
            {
                compressor.append(a1[i]);
                compressor.append(compressLength);
                i = j;
                compressLength = 0;
            }

            if (j == a1.length - 1)
            {
                compressor.append(a1[j]);
                compressor.append(++compressLength);
            }
        }

        if (compressor.length() < s.length())
        {
            System.out.println(compressor.toString());
            return;
        }
        System.out.println(s);
    }

    public static void nullifyForZeros (int[][] matrix)
    {
        int M = matrix.length;
        int N = matrix[0].length;

        System.out.println("Pre conversion");

        print(matrix);
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // If coloumns have a zero field.
        for (int i = 0; i < M; i++)
        {
            if (matrix[i][0] == 0)
            {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < N; j++)
        {
            if (matrix[0][j] == 0)
            {
                nullifyColumn(matrix, j);
            }
        }

        System.out.println("After conversion");
        print(matrix);
    }

    private static void print (int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void nullifyRow (int[][] matrix, int row)
    {
        for (int j = 0; j < matrix[0].length; j++)
        {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn (int[][] matrix, int col)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][col] = 0;
        }
    }

    public static void rotateMatrixBy90 (int[][] matrix)
    {

        System.out.println("============ Matrix before rotation =========");
        print(matrix);
        int N = matrix.length;
        for (int layer = 0; layer <= N / 2; layer++)
        {
            int first = layer;
            int last = N - 1 - layer;
            for (int i = first; i < last; i++)
            {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        System.out.println("============ Matrix after 90 rotation =========");
        print(matrix);
    }

    public static void main (String[] args)
    {
        ArraysAndString.returnUnique("abcdac");
        ArraysAndString.returnIfPerm("abcd", "dabc");
        ArraysAndString.returnUrlString("M r John Smith      ");
        ArraysAndString.checkIfPalindrome("tactcoa");

        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 0, 7}, {8, 9, 10, 11}};
        System.out.println("========= Example 1=========");
        ArraysAndString.nullifyForZeros(matrix1);

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 0, 7}, {8, 9, 1, 1}, {1, 3, 4, 5}};

        System.out.println("========= Example 2=========");
        ArraysAndString.nullifyForZeros(matrix2);

        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 0, 7}, {8, 9, 1, 1}, {1, 3, 4, 0}};

        System.out.println("========= Example 3=========");
        ArraysAndString.nullifyForZeros(matrix3);

        int[][] matrix90 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArraysAndString.rotateMatrixBy90(matrix90);
    }
}
