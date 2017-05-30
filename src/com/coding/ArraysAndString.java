package com.coding;

public class ArraysAndString {

	/**
	 * Q1 : Return if string has unique
	 * 
	 * @param s
	 */
	public static void returnUnique(String s) {

		char[] a = s.toLowerCase().toCharArray();
		int length = a.length;

		for (int i = 0; i < length; i++) {

			int lower = (a[i] - 'a');
			int upper = (a[i] - 'A');

			int subValue = (lower >= 0 && lower <= 10) ? lower : upper;

			int value = subValue % length;

			if (a[value] == '1') {
				System.out.println("Non unique");
				return;
			}

			a[value] = '1';

		}

		System.out.println("Unique");

	}

	public static void returnIfPerm(String s1, String s2) {
		int count = 0;
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		if (s1.length() != s2.length()) {
			System.out.println("Is not a perm");
			return;
		}

		for (int i = 0; i < a1.length; i++) {

			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					count++;
				}
			}
		}

		if (count == a1.length - 1) {
			System.out.println("Is a perm");
			return;
		}

		System.out.println("Is not a perm");

		// Or implement this using hash tables.
	}

	public static void returnUrlString(String s1) {
		char[] a1 = s1.toCharArray();
		int lIndex = 0;
		int hIndex = a1.length - 1;

		for (int i = hIndex; i >= 0; i--) {
			if (a1[i] != ' ') {
				lIndex = i;
				break;
			}
		}

		while (lIndex >= 0 && hIndex >= 2) {
			if (a1[lIndex] != ' ') {
				a1[hIndex] = a1[lIndex];
			} else {
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

	public static void checkIfPalindrome(String s1) {
		int[] holder = new int[26];
		char[] a1 = s1.toCharArray();
		for (int i = 0; i < a1.length; i++) {

			int v = (a1[i] - 'a') % a1.length;
			holder[v] += 1;
		}

		int noOfUnique = 0;

		for (int i = 0; i < holder.length; i++) {
			if (holder[i] == 1) {
				noOfUnique++;
			}
		}

		if (noOfUnique > 1) {
			System.out.println("Not a palindrome");
			return;
		}

		System.out.println("Palindrome");
	}
	
   public static void compressString(String s)
  {
    StringBuilder compressor = new StringBuilder();
    char[] a1 = s.toCharArray();
    
    int i = 0;
    int compressLength = 0;
    for(int j=1; j<a1.length; j++)
    {
        compressLength++;

        if(a1[i] != a1[j])
        {
            compressor.append(a1[i]);
            compressor.append(compressLength);
            i=j;
            compressLength = 0;
        }   
        
        
        
        if(j==a1.length -1)
        {
           compressor.append(a1[j]);
           compressor.append(++compressLength);
        }
     }
    
    if(compressor.length() < s.length())
    {
    System.out.println(compressor.toString());
	    return;
    }
    System.out.println(s);	   
  }  
	
	public static void OneOrMoreEdits()
	{
		
	}

	public static void main(String[] args) {
		ArraysAndString.returnUnique("abcdac");
		ArraysAndString.returnIfPerm("abcd", "dabc");
		ArraysAndString.returnUrlString("M r John Smith      ");
		ArraysAndString.checkIfPalindrome("tactcoa");
		
	}
}
