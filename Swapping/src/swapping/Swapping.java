package swapping;
import java.util.Scanner;
public class Swapping 
{
   public static void twovar(int a, int b)
   {
       a = a+b;
       b = a-b;
       a = a-b;
       System.out.println("Swapping using two variables: ");
       System.out.println("a= "+a);
       System.out.println("b= "+b);
   }
   public static void threevar(int a, int b)
   {
       int T = a;
       a = b;
       b = T;
       System.out.println("Swapping using three variables: ");
       System.out.println("a= "+a);
       System.out.println("b= "+b);
   }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a: ");
        int a = sc.nextInt();
        System.out.println("Enter the value of b: ");
        int b = sc.nextInt();
        System.out.println("Before swapping: ");
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        System.out.println("After swapping: ");
        twovar(a,b);
        threevar(a,b);
    }
}
