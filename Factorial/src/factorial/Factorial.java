package factorial;

import java.util.Scanner;
public class Factorial 
{
    public static int fact(int x)
    {
        int f=1;
        for(int i=1; i<=x; i++)
        {
            f= f*i;
        }
        return f;
    }
    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a number: ");
       int num = sc.nextInt();
       int factorial = fact(num);
       System.out.println("Factorial of a number is: "+factorial);
    }
}