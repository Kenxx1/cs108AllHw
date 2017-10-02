
package cs237prog3;


public class Cs237prog3 {

 
    public static void main(String[] args)
    {
      // String ch = "0123456789ABCDEF";
       int num = 11;   //base 10
       int toBase = 12;
       int remainder = 0;
       double power = 0.0;
       int ans = 0;
       do
       {
           remainder = num%toBase;
           num = num/toBase;
           ans += remainder * Math.pow(10, power);
       }while(num>0);
       System.out.println(ans);
    }
}
