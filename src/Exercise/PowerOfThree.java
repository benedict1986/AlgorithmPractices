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
public class PowerOfThree {
    public static void main(String[] args)
    {
        PowerOfThree pot = new PowerOfThree();
        System.out.println(pot.isPowerOfThree(243));
    }
    
    public boolean isPowerOfThree(int n)
    {
        System.out.println((Math.log10(n)/Math.log10(3))%1 == 0 );
        return true;
    }
}
