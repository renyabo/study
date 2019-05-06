package org.yabo.utils.poi;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;//进位
        ListNode node = sum;
        while (l1 != null && l2 != null) {
            int n = l1.val + l2.val + carry;
            carry = n / 10;
            n = n % 10;
            node.next = new ListNode(n);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int n = l1.val + carry;
            carry = n / 10;
            n = n % 10;
            node.next = new ListNode(n);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int n = l2.val + carry;
            carry = n / 10;
            n = n % 10;
            node.next = new ListNode(n);
            node = node.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return sum.next;
    }
}
