/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class CountPrimes {
    public static void main(String[] args)
    {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(35));
    }
    
    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        else if (n  < 5) return 2;
        else if (n < 7) return 3;
        else if (n < 11) return 4;
        else if (n < 13) return 5;
        else if (n < 17) return 6;
        else if (n < 19) return 7;
        else if (n < 23) return 8;
        else if (n < 29) return 9;
        else if (n < 31) return 10;
        else
        {
            int count = 10;
            int i, j;
            for( i = 31; i < n; i++)
            {
                int end = (int)Math.sqrt(n)+1;
                boolean isPrime = true;
                for (j = 2; j <= end; j++)
                {
                    if (i % j == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) count++;
            }
            return count;
        }
    }
}
