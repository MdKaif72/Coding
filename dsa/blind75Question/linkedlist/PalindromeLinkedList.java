package dsa.blind75Question.linkedlist;
/*
LC 234
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.



Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false

 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)//for odd one we are excluding the next of slow
            slow=slow.next;

        slow=reverseList(slow);
        fast=head;

        while(slow!=null){
            if(fast.val!=slow.val)
                return false;

            fast=fast.next;
            slow=slow.next;
        }
        return true;

    }
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;


    }
}
