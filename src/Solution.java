

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode  n = head;
        ListNode locall1 = l1;
        ListNode locall2 = l2;
        int l1Len = 0;
        int l2Len = 0;
        while (locall1!=null){
            locall1 = locall1.next;
            l1Len++;
        }
        while (locall2!=null){
            locall2 = locall2.next;
            l2Len++;
        }
        locall1 = l1;
        locall2 = l2;
        while (l1Len > 0 || l2Len > 0){
            if (l1Len == 0) {
                head = add(head, locall2.val);
                l2Len--;
                locall2 = locall2.next;
                continue;
            }
            if (l2Len == 0){
                head = add(head, locall1.val);
                l1Len--;
                locall1 = locall1.next;
                continue;
            }
            if (locall1.val >= locall2.val){
                head = add(head, locall2.val);
                l2Len--;
                locall2 = locall2.next;
            }else{
                head = add(head, locall1.val);
                l1Len--;
                locall1 = locall1.next;
            }
        }
        head = n.next;
        return head;
    }

    public ListNode add(ListNode node, int val){
        node.next = new ListNode(val);
        node = node.next;
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = s.mergeTwoLists(l1, l2);
        System.out.println("listNode = " + listNode.val+":"+listNode.next.val);
    }
}