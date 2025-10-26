public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = getNum(l1);
        int b = getNum(l2);
        int sum = a + b;
        String sumStr = Integer.toString(sum);

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        for (int i = sumStr.length() - 1; i >= 0; i--) {
            current.next = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
            current = current.next;
        }

        return dummyHead.next;
    }

    public int getNum(ListNode n){
        StringBuilder sb = new StringBuilder();
        ListNode current = n;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
        }
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
}
