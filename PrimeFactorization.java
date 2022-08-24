import java.math.BigInteger;
import java.util.*;

public class PrimeFactorization
{
    private ArrayList<BigInteger> factors; 
  
    /*
     * Given any n, first check if n is prime
     * If not, it is guarenteed to have some prime factor <= sqrt(n)
     * Search for all primes <= sqrt(n)
     * Check each prime until all divisors are found
     */
    public ArrayList<BigInteger> factor(BigInteger n)
    {
        factors = null;
        factors = new ArrayList<BigInteger>();
        findPrimes(n);
        
        /*
         * for (int i = 0; i<factors.size(); i++)
        {
            System.out.println(factors.get(i));
        }
         */
        return factors;
    }
    
    public void findPrimes(BigInteger n)
    {
        ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
        for (BigInteger i = new BigInteger("2"); i.compareTo(n.sqrt()) < 1; i = i.add(BigInteger.ONE))
        {
            if (checkDivisible(primes, i)) {continue;} //Continue because composite
            primes.add(i);
            if (n.remainder(i) == BigInteger.ZERO) {factors.add(i); findPrimes(n.divide(i)); return;}
        }
        factors.add(n);
        return;
    }
    
    public boolean checkDivisible(ArrayList<BigInteger> primes, BigInteger n)
    {
        for (BigInteger i : primes)
        {
            if (n.remainder(i) == BigInteger.ZERO) {return true;}
        }
        return false;
    }
    
    public boolean isPrime(BigInteger p)
    {
        //ArrayList<BigInteger> nonF = new ArrayList<BigInteger>();
        for (BigInteger i = new BigInteger("2"); i.compareTo(p.sqrt()) < 1; i = i.add(BigInteger.ONE))
        {
            //if(checkDivisible(nonF, i)) {continue;}
            if (p.remainder(i) == BigInteger.ZERO) {return false;}
            //nonF.add(i);
        }
        return true;
    }
}