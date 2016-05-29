/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SymbolTable;

import StackQueue.StackOfStrings;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BasicSymbolTableTest {
    
    public static void main(String[] args)
    {
        BasicSymbolTable<String, Integer> st = new BasicSymbolTable<String, Integer>();
        for(int i = 0; ;i++)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Key: ");
            String s = scanner.nextLine();
            System.out.println("Enter Value: ");
            int j = Integer.parseInt(scanner.nextLine());
            if (!s.isEmpty())
            {
                st.put(s, j);
            }
            else
                break;
        }
        for(String s : st.keys())
        {
            System.out.println(s + " " + st.get(s));
        }
    }
}
