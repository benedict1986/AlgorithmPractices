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
public class ReverseLinkedList {
    
    public static void main(String[] args)
    {
        int[] list = {1,2,3,4,5,6};
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
        
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode result = rll.reverseList(head);
        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
        
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode previous = head;
        ListNode current = head.next;
        if (head.next.next == null) 
        {
            current.next = previous;
            previous.next = null;
        }
        else
        {
            ListNode next = head.next.next;
            int i = 0;
            while(next != null)
            {
                current.next = previous;
                if (i == 0)
                    previous.next = null;

                previous = current;
                current = next;
                next = next.next;
                i++;
            }
            current.next = previous;
        }
        return current;
    }
}
