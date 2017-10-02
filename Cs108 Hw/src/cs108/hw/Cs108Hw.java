package cs108.hw;

import java.util.*;
public class Cs108Hw 
{
    Stack<String>[] list = new Stack[10];
    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        String s = "456789";

        String t = s.substring(1,2);   //t is now the String "5"
                                       //i.e., we obtained the substring of s
                                       //which starts at string index 1,
                                       //and ends before (but not including)
                                       //string index 2.
                                       //NOTE: Java string indices start at 0, on the
                                       //left side of the string.

        char c = s.charAt(1);   //c is now the char '5'
                                //i.e., we obtained the "char data-type" character
                                //located at string index 1.
                                //NOTE: Java string indices start at 0, on the
                                //left side of the string.

        int k = (int)c - (int)'0';   //k is now the int number 5

        int w = Integer.parseInt("100");   //w is now the int number 100

        String str = scan.nextLine();
        if (str.equals(""))
        { 
            System.out.println("You hit the ENTER key only");
        }
        else 
        {
             
        }



    }   
    
}
