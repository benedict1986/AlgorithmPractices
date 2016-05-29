/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author Admin
 */
public class BSTTest {
    public static void main(String[] args)
    {
        BST<Integer, String> bst = new BST<Integer, String>();
        int[] keys = new int[]{8, 2, 0, 5, 6, 1, 3, 7};
        String[] values = new String[]{"Q", "W", "E", "T", "Y", "U", "I", "O"};
        
        for(int i = 0; i < 8; i++)
        {
            bst.put(keys[i], values[i]);
        }
        
        String a = bst.get(7);
        String min = bst.min();
        String max = bst.max();
        int floor = bst.Floor(5);
        int ceiling = bst.Ceiling(2);
        int rank = bst.rank(4);
//        bst.deleteMin();
        bst.delete(5);
    }
}
