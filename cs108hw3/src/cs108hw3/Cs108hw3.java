package cs108hw3;

import java.util.*;
public class Cs108hw3
{


public static Stack<String> mbin = new Stack<String>(); //main bin
public static Stack<String>[] sbins = new Stack[10]; //declare sort bins


public static void main(String args[])
{
    Scanner scan = new Scanner(System.in);


    for (int i=0; i<=9; i++)
    {
       sbins[i] = new Stack<String>(); //initialize each sort bin
    }


    System.out.println("Input a number, 0 to 9999, or press ENTER to stop:");
    String s = scan.nextLine();
    while (! s.equals(""))
    {
      mbin.push(s);
      System.out.println("Input a number, 0 to 9999, or press ENTER to stop:");
      s = scan.nextLine();
    }


    System.out.println("Your original mbin, outputting from bottom to top:");
    System.out.println(mbin);


    for (int i=3; i>=0; i--)
    {
       MtoS(i);
       StoM();
    }


    System.out.println("Your now-sorted mbin, outputting from bottom to top:");
    System.out.println(mbin);

}



public static void MtoS(int p)   //p=3: transfer by 1's-place digits,
{                                // ..., p=0: transfer by 1000's-place digits.

   while ( ! mbin.isEmpty() )
   {
      String x = mbin.pop();

      String s = x;
      while (s.length() < 4) { s = "0"+s; }   //ensuring item has 4 digits,
                                              //so the charAt will not crash.
      char c = s.charAt(p);
      int k = (int)c;  //note: there are lots of ways to calculate k
      
      sbins[k].push(x);   //adding original item x, not s
   }

}



public static void StoM()
{

   for (int k=9; k>=0; k--)
   {
      while ( ! sbins[k].isEmpty() )
      {
         String s = sbins[k].pop();
         mbin.push(s);
      }
   }

}



}  //class


