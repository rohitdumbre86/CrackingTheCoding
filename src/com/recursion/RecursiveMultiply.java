package com.recursion;

/**
 * Perform recursive multiply.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class RecursiveMultiply
{
    private static int getRecursiveMultiply (int a, int b)
    {
        if (b <= 0)
            return 0;
        if (b == 1)
            return a;

        int sqrt = (int) Math.sqrt(b);
        if (Math.pow(sqrt, 2) == Math.pow(b, 2))
        {
            return a << (b / 2);
        }

        return a + getRecursiveMultiply(a, --b);

    }

    public static void main (final String[] args)
    {
        int a = 5;
        for (int i = 1; i < 10; i++)
        {
            System.out.println(a + " X " + i + " = " + RecursiveMultiply.getRecursiveMultiply(a, i));

        }

    }
}
