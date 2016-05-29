/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;

/**
 *
 * @author Admin
 */
public class UglyNumber {
    public static void main(String[] args)
    {
        UglyNumber un = new UglyNumber();
        System.out.println(un.isUgly(2147483647));
    }
    
    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num < 0) return false;
        
        if (num != 0)
            while(num % 2 == 0)
                num /= 2;
        if (num != 0)
            while(num % 3 == 0)
                num /= 3;
        if (num != 0)  
            while(num % 5 == 0)
                num /= 5;
                
        if (num == 0)
            return true;
        else
            return false;
    }
}
