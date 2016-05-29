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
public class PalindromeLinkedList {
    
    public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
    }
    public static void main(String[] args)
    {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        int[] list = {1,2,3, 4,2,1};
        ListNode head = null;
        ListNode pointer = null;
        for(int i : list)
        {
            if (head == null)
            {
                head = new ListNode(i);
                pointer = head;
            }
            else
            {
                pointer.next = new ListNode(i);
                pointer = pointer.next;
            }
        }
        
        System.out.println(pll.isPalindrome(head));
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        ListNode current = null;
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        current = reverse(slow);
        ListNode pointer = head;
        while(pointer != null && current != null)
        {
            if (pointer.val != current.val)
                return false;
            pointer = pointer.next;
            current = current.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode current)
    {
        if (current == null || current.next == null) return current;
        
        ListNode newCurrent = reverse(current.next);
        current.next.next = current;
        current.next = null;
        
        return newCurrent;
    }
}
