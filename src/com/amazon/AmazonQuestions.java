package com.amazon;

public class AmazonQuestions {

    // Write a function that returns true if the binary representation of an integer is a palindrome. 
    public static boolean returnNumberIfPalindrome(int i)
    {
        String s = returnBinaryNumberString(i,"");
        System.out.println(s);
        char[] charArray = s.toCharArray();
        int k=0, j = charArray.length-1;
        while(k<=j)
        {
          if(charArray[k]==charArray[j])
          {
              k++;
              j--;
          }
          else
          {
              return false;
          }
        
        }
        
        return true;
        
    }
    
    
    public static void returnUniqueObjects(final AmazonQuestions o1, AmazonQuestions ...objects)
    {
        int[] hashCodes = new int[32];
        Object[] objectList = new Object[32];
        
        hashCodes[o1.hashCode() % 32] = 1;
        
        for (Object o2 : objects) {
            
            int hashCode = o2.hashCode() % 32;
            
            hashCodes[hashCode]+= 1; 
            objectList[hashCode] = o2;
        }
        
        for (int i = 0; i < hashCodes.length; i++) {
            if(hashCodes[i] == 1)
            {
                System.out.println(objectList[i]);
                return;             
            }
        }
    }
    
    private static String returnBinaryNumberString(int i, String s)
    {
        if (i == 0 || i == 1) return  i + s;
                
        return returnBinaryNumberString (i/2,  i % 2 +s);
        
    }
    
    public static void main(String[] args) {
        System.out.println(AmazonQuestions.returnNumberIfPalindrome(2));
        System.out.println(AmazonQuestions.returnNumberIfPalindrome(4));
        System.out.println(AmazonQuestions.returnNumberIfPalindrome(9));
        System.out.println(AmazonQuestions.returnNumberIfPalindrome(12));
        System.out.println(AmazonQuestions.returnNumberIfPalindrome(17));
        
         AmazonQuestions o1 = new AmazonQuestions();
         AmazonQuestions o2 = new AmazonQuestions();
         AmazonQuestions o3 = new AmazonQuestions();

         
         
         AmazonQuestions.returnUniqueObjects(o1, o1,o2,o3,o1);
    }
    
    public String toString()
    {
        return "object:"+this.hashCode()+"";
    }

}

