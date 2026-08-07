package dsa.blind75Question.linkedlist;

/*
LC 23
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 */

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0)
            return null;
        return mergeKListsHelper(lists,0,lists.length-1);


    }
    private ListNode mergeKListsHelper(ListNode[]lists, int start, int end){
        if(start == end)
            return lists[start];
        if(start+1== end)
            return mergeTwoLists(lists[start],lists[end]);
        int mid = start +(end-start)/2;
        ListNode left=mergeKListsHelper(lists,start,mid);
        ListNode right=mergeKListsHelper(lists,mid+1,end);
        return mergeTwoLists(left,right);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;

        }
        if (list1 != null)
            temp.next = list1;
        else
            temp.next = list2;

        return dummyNode.next;


    }



}



