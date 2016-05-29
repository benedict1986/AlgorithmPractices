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
public class ReverseBits {
    
    public static void main(String[] args)
    {
        int a = 1;
        ReverseBits rb = new ReverseBits();
        rb.reverseBits(a);
    }
    
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
//            if ((n & 1) == 1)
//            {
//                result++;
//            }
//            result = result << 1;
//            n = n >> 1;
//            System.out.println(result);
            result = (result << 1) | (n & 1);
            n = (n >> 1);   
            System.out.println(result);
        }

        return result;
    }
}
