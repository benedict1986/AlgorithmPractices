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
public class OddEvenLinkedList {
    
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode pointer = head;
        for(int i = 2; i < 9; i++)
        {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }
        OddEvenLinkedList oell = new OddEvenLinkedList();
        ListNode newListNode = oell.oddEvenList(head);
    }
    
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode oddEvenList(ListNode head) {

        ListNode begin = head;
        ListNode end = head.next;
        ListNode endPointer = end;
        while(begin.next != null && endPointer.next != null)
        {
            begin.next = begin.next.next;
            begin = begin.next;
            endPointer.next = endPointer.next.next;
            endPointer = endPointer.next;
        }
        begin.next = end;
        
        return head;
    }
}
