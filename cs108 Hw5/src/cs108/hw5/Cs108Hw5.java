package cs108.hw5;

import java.util.*;
import java.io.*;


class GridSquare
{

   public int i;   //row index
   public int j;   //column index

   public GridSquare(int i, int j)
   {
      this.i = i;
      this.j = j;
   }

   public String toString()
   {
      return  this.i+" "+this.j;
   }

}



public class Cs108Hw5
{
public static void main(String args[]) throws IOException
{
Scanner scan = new Scanner(System.in);



System.out.print("Filename with maze pattern = ?");
String filename = scan.nextLine();

Scanner scanf = new Scanner(new File(filename));
ArrayList<String> lines = new ArrayList<String>();
while ( scanf.hasNext() )
{
   String s = scanf.nextLine();
   s = s.trim();
   if (s.equals("")) continue;
   lines.add(s);
}
scanf.close();



int numberOfRows = lines.size();
int numberOfCols = (lines.get(0)).length();

int[][] arr = new int[numberOfRows][numberOfCols];
      //array encoding:
      //   0 means walkable square
      //   1 means hedge square
      //   2 means walkable, but was already explored

//transfer file info into int array:
for (int r=0; r<numberOfRows; r++)
{
   String t = lines.get(r);
   for (int c=0; c<numberOfCols; c++)
   {
      arr[r][c]  =  t.charAt(c)=='*'?1:0;
   }
}



System.out.print("Start, row index = ?");
   int starti = scan.nextInt();   //eg, 6

System.out.print("Start, col index = ?");
   int startj = scan.nextInt();   //eg, 3

System.out.print("Target, row index = ?");
   int targeti = scan.nextInt();   //eg, 1

System.out.print("Target, col index = ?");
   int targetj = scan.nextInt();   //eg, 1



Stack<GridSquare> st1 = new Stack<GridSquare>(); //tracks your path

GridSquare startsqr = new GridSquare(numberOfRows , numberOfCols);
   st1.push(startsqr);   //move to start square
   arr[starti][startj] = 2; //move to start square


boolean reachedtarget = false;
while ( startsqr!=null  &&  !reachedtarget )
{

   GridSquare curr = st1.peek();   //get current location

   GridSquare newloc = null;  //tracks the new location

   if ( upisokay(arr, curr.i, curr.j) )
   {
      newloc = new GridSquare(curr.i-1, curr.j);
   }
   else if ( downisokay(arr, curr.i, curr.j) )
   {
      newloc = new GridSquare(curr.i+1, curr.j);
   }
   else if ( leftisokay(arr, curr.i, curr.j) )
   {
      newloc = new GridSquare(curr.i, curr.j-1);
   }
   else if ( rightisokay(arr, curr.i, curr.j) )
   {
      newloc = new GridSquare(curr.i, curr.j+1);
   }


   if (newloc != null)
   {
      st1.push(curr);
      arr[newloc.i][newloc.j] = 2; //move to newloc

      if ( newloc.i==targeti  &&  newloc.j==targetj )
      {
         reachedtarget = true;
         continue; //jump up
      }
   }
   else
   {
      GridSquare ss = st1.pop();
   }

} //while



System.out.println();
if ( reachedtarget )
   System.out.println("Target square was hit!");
else
   System.out.println("Target square can not get hit.");


for (int i=0; i<st1.size(); i++)
{
   GridSquare gs = st1.elementAt(i); //using elementAt, for ease
   System.out.println("square#" + (i+1) + " = " + gs);
}

} //main



public static boolean upisokay(int[][] arr, int i, int j)
{
   return  arr[i-1][j]==0;
}


public static boolean downisokay(int[][] arr, int i, int j)
{
   return  arr[i+1][j]==0;
}


public static boolean leftisokay(int[][] arr, int i, int j)
{
   return  arr[i][j-1]==0;
}


public static boolean rightisokay(int[][] arr, int i, int j)
{
   return  arr[i][j+1]==0;
}



} //class