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
public class IsomorphicStrings {
    public static void main(String[] args)
    {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic("ab", "aa"));
    }
    
    public boolean isIsomorphic(String s, String t) {
        if (s == t) return true;
        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) return false;
        
        int[] listS = new int[256];
        int[] listT = new int[256];
        int i;
        for(i = 0; i < sLength; i++)
        {
            if (listS[s.charAt(i)] != 0 || listT[t.charAt(i)] != 0)
            {
                if (listS[s.charAt(i)] != t.charAt(i) || listT[t.charAt(i)] != s.charAt(i))
                    return false;
            }
            else
            {
                listS[s.charAt(i)] = t.charAt(i);
                listT[t.charAt(i)] = s.charAt(i);
            }
        }
        return true;
    }
}
