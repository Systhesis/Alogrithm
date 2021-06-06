package com.neil.algorithm.customdatastruct;

import java.util.List;

/**
 * @author neil zhong
 * @classname Sum
 * @description TODO
 * @date 2021/6/6 上午11:13
 **/
public class Solution {
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if(l == arr.length) {
            return 0;
        }else {
            return arr[l] + sum(arr, l + 1);
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        return null;
    }



    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public ListNode(int[] nums) {

            this.val = nums[0];

            for (int i = 1; i < nums.length; i++) {
                next = new ListNode(nums[i]);
                next = next.next;
            }

        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append("ListNode : [ " + val + " , ");
            while (next != null) {
                res.append(next.val + " , ");
                next = next.next;
            }
            res.append(" ] ");
            return res.toString();

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(nums);
        System.out.println(head);
    }
}
