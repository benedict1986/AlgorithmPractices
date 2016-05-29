/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import edu.princeton.cs.algs4.In;

/**
 *
 * @author Admin
 */
public class DigraphTest {
    
    public static void main(String[] args)
    {
        In in = new In("C:\\Users\\Admin\\Desktop\\Java Practice\\AlgorithmPractice\\src\\Graph\\tinyDG.txt");
        Digraph G = new Digraph(in);
        
//        for(int v = 0; v < G.V(); v++)
//        {
//            for (int w : G.adj(v))
//            {
//                System.out.println(v + "->" + w);
//            }
//        }
    }
}
