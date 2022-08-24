import java.util.*;
import java.math.BigInteger;

public class PrimeFracRunner
{
   static Scanner scan = new Scanner(System.in);
   static PrimeFactorization pf = new PrimeFactorization();
   public static void RunSingle()
   {  
       ArrayList<BigInteger> factors = pf.factor(new BigInteger(scan.nextLine()));
       for (BigInteger i : factors)
       {
           System.out.println(i);
       }
   }
   
   public static void TenMultTest()
   {
       for (int i = 1; i<=30; i++)
       {
            long start = System.nanoTime();
            pf.factor(new BigInteger(""+(int)Math.pow(10, i)));
            long end = System.nanoTime();
            
            System.out.println(end-start);
       }
   }
   
   public static void ThouroughTimeTestRatio()
   {
       int max = scan.nextInt();
       long last = 1;
       for (int i = 1; i<max; i++)
       {
            long start = System.nanoTime();
            pf.factor(new BigInteger(""+(i+1)));
            long end = System.nanoTime();
            
            System.out.println((double) (end-start)/last);
            last = end-start;
       }
   }
   
   public static void ThouroughTimeTestActual()
   {
       int max = scan.nextInt();

       for (int i = 1; i<max; i++)
       {
            long start = System.nanoTime();
            pf.factor(new BigInteger(""+(i+1)));
            long end = System.nanoTime();
            
            System.out.println(end-start);
       }
   }
}
