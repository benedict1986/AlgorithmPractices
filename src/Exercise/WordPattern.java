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
public class WordPattern {
    
    public static void main(String[] args)
    {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
    }
    
    public boolean wordPattern(String pattern, String str) {
        int nP = pattern.length(), i, index;
        String[] words = str.split(" ");
        int nS = words.length;
        if (nP != nS) return false;
        
        int[] lettersCount = new int[26];
        String[] letterWordMatch = new String[26];
        
        for(i = 0; i < nP; i++)
        {
            index = pattern.charAt(i) - 'a';
            if (letterWordMatch[index] == null)
                letterWordMatch[index] = words[i];
            else if (!letterWordMatch[index].equals(words[i]))
                return false;
        }
        
        return true;
    }
}
